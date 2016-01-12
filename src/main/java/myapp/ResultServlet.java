package myapp;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import com.google.appengine.api.utils.SystemProperty;

/**
 * Servlet for storing results in the database.
 */
public class ResultServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
      String cmpStr = req.getParameter("cmp");
      String firstStr = req.getParameter("first");
      String secondStr = req.getParameter("second");
      String countStr = req.getParameter("count");
      String timeStr = req.getParameter("time");
      if (cmpStr != null && firstStr != null &&
          secondStr != null && countStr != null && timeStr != null) {
        try {
          int cmp = Integer.parseInt(cmpStr);
          int first = Integer.parseInt(firstStr);
          int second = Integer.parseInt(secondStr);
          int count = Integer.parseInt(countStr);
          int time = Integer.parseInt(timeStr);
          String url = Common.getDatabaseURL();
          if (url == null) {
            Common.serverError(resp, "Database connection error.");
          } else {
            try {
              Connection conn = DriverManager.getConnection(url);
              try {
                String statement =
                  "INSERT INTO results (ipaddr, cmp, first, second, count, time) VALUES (?, ?, ?, ?, ?, ?);";
                PreparedStatement stmt = conn.prepareStatement(statement);
                stmt.setString(1, req.getRemoteAddr());
                stmt.setInt(2, cmp);
                stmt.setInt(3, first);
                stmt.setInt(4, second);
                stmt.setInt(5, count);
                stmt.setInt(6, time);
                int success = stmt.executeUpdate();
              } finally {
                conn.close();
              }
            } catch (SQLException e) {
              e.printStackTrace();
              Common.serverError(resp, "Database error.");
            }
          }
        } catch (NumberFormatException ex) {
          Common.errorMessage(resp, "Args not valid.");
        }
      } else {
        Common.errorMessage(resp, "Missing required args.");
      }
    }

}
