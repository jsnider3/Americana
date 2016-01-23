package myapp;

import java.io.*;
import java.sql.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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
          String err = logResult(req.getRemoteAddr(), cmp, first, second,
            count, time);
          if (err != null) {
            Common.serverError(resp, err);
          }
        } catch (NumberFormatException ex) {
          Common.errorMessage(resp, "Args not valid.");
        }
      } else {
        Common.errorMessage(resp, "Missing required args.");
      }
    }

    /**
     * Import a dump file.
     */
    public void importFile(String filename) {
      try {
        List<String> lines = Files.readAllLines(Paths.get(filename),
          StandardCharsets.UTF_8);
        String file = lines.get(0);
        file = file.substring(1, file.length() - 2);
        for (String record : file.split("\\),\\(")) {
          String[] fields = record.split(",");
          logResult(fields[0], Integer.parseInt(fields[1]),
            Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
            Integer.parseInt(fields[4]), Integer.parseInt(fields[5]));
          System.out.println(record);
        }
      } catch(Exception e) {}
    }

    /**
     * Log the given result. Return an error message if necessary.
     */
    public String logResult(String ipaddr, int cmp, int first, int second,
        int count, int time)
    {
      String url = Common.getDatabaseURL();
      if (url == null) {
        return "Database connection error.";
      } else {
        try {
          try (Connection conn = DriverManager.getConnection(url)) {
            String statement =
              "INSERT INTO results (ipaddr, cmp, first, second, count, time, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setString(1, ipaddr);
            stmt.setInt(2, cmp);
            stmt.setInt(3, first);
            stmt.setInt(4, second);
            stmt.setInt(5, count);
            stmt.setInt(6, time);
            stmt.setDouble(7, (double)System.currentTimeMillis());
            int success = stmt.executeUpdate();
          }
        } catch (SQLException e) {
          e.printStackTrace();
          return "Database error.";
        }
      }
      return null;
    }

    /**
     * Create the table we will write things in.
     */
    public boolean makeTable() {
      String url = Common.getDatabaseURL();
      if (url == null) {
        return false;
      } else {
        try {
          try (Connection conn = DriverManager.getConnection(url)) {
            String statement = "CREATE TABLE results (" +
              "ipaddr VARCHAR(30) NOT NULL, " +
              "cmp INT NOT NULL, " +
              "first INT NOT NULL, " +
              "second INT NOT NULL, " +
              "count INT NOT NULL, " +
              "time INT NOT NULL, " +
              "ruid INT PRIMARY KEY, " +
              "timestamp double DEFAULT NULL);";
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.executeUpdate();
          }
        } catch (SQLException e) {
          e.printStackTrace();
          return false;
        }
      }
      return true;
    }

}
