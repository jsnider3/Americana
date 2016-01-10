package myapp;

import java.io.IOException;
import javax.servlet.http.*;

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
      if (cmpStr != null && firstStr != null && secondStr != null) {
        try {
          int cmp = Integer.parseInt(cmpStr);
          int first = Integer.parseInt(firstStr);
          int second = Integer.parseInt(secondStr);
          Common.errorMessage(resp, "Not implemented yet.");
        } catch (NumberFormatException ex) {
          Common.errorMessage(resp, "Args not valid.");
        }
      } else {
        Common.errorMessage(resp, "Missing required args.");
      }
    }

}
