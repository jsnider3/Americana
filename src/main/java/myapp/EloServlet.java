
package myapp;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import com.google.appengine.api.utils.SystemProperty;

/**
 * Servlet for calculating and caching the Elo rankings.
 */
public class EloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
      if (req.getHeader("X-Appengine-Cron") != null) {
        resp.setContentType("text/plain");
        resp.getWriter().println("{ \"status\": \"TODO Implement\"}");
        //TODO
      } else {
        Common.errorMessage(resp, "Not authorized.");
      }
    }

}
