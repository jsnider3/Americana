package myapp;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;
import com.google.appengine.api.utils.SystemProperty;

/**
 * Servlet for returning the countries and Elo rankings.
 */
public class EloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
      resp.setContentType("application/json");
      resp.getWriter().print("{ \"updated\": " + getTimestamp() + ", \"countries\" : [");
      List<Map.Entry<String, Integer>> list = new LinkedList(getRankings().entrySet());
      Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o2)).getValue())
              .compareTo(((Map.Entry) (o1)).getValue());
            }
       });

      for (Map.Entry<String, Integer> entry : list) {
        resp.getWriter().print("[\"" + entry.getKey() + "\", " + entry.getValue() + "]");
        if (entry != list.get(list.size() - 1)) {
          resp.getWriter().print(", ");
        }
      }
      resp.getWriter().println("]}");
    }

    /**
     * Adjust the Elo scores based on the matches played. Use redis later.
     */
    public void getMatches(List<Player<String>> countries) {
      String url = Common.getDatabaseURL();
      if (url == null) {
        System.err.println("Database connection error.");
      } else {
        try (Connection conn = DriverManager.getConnection(url)) {
          String statement =
            "SELECT FROM results (cmp, first, second);";
          Statement stmt = conn.createStatement();
          ResultSet rs = stmt.executeQuery(statement);
          while (rs.next()) {
            int first = rs.getInt("first");
            int second = rs.getInt("second");
            int cmp = rs.getInt("cmp");
            Match.Outcomes result = null;
            switch (cmp) {
              case -1:
                result = Match.Outcomes.ePlayer_One_Won;
                break;
              case 0:
                result = Match.Outcomes.ePlayer_Two_Won;
                break;
              case 1:
                result = Match.Outcomes.eDraw;
                break;
            }
            if (result != null) {
              new Match(countries.get(first), countries.get(second),
                  result);
            }
          }
          rs.close();
        } catch (SQLException e) {
          e.printStackTrace();
          System.err.println("Database error.");
        }
      }
    }

    /**
     * Get the updated ranks. For now manually. Later from redis.
     */
    public Map<String, Integer> getRankings() {
      List<Player<String>> countries = new ArrayList<>();
      for (int x = 0; x < Common.NUM_COUNTRIES; x++) {
        countries.add(new Player<String>(
            new CountryServlet().getCountryName(x)));
      }
      getMatches(countries);
      Map<String, Integer> ranks = new HashMap<String, Integer>();
      for (Player<String> country : countries) {
        ranks.put(country.getID(), country.getRating());
      }
      return ranks;
    }

    public long getTimestamp() {
      return 1453525864169L;
    }

}
