package myapp;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.utils.SystemProperty;

/**
 * Wrapper class for app-wide shared functionality.
 */
public class Common {

    final static int NUM_COUNTRIES = 197;

    /**
     * Write an error message to a servlet response.
     */
    public static void errorMessage(HttpServletResponse resp, String msg)
          throws IOException {
      resp.setStatus(400);
      resp.setContentType("text/plain");
      resp.getWriter().println("{ \"message\": \"" + msg + "\" }");
    }

    public static String getDatabaseURL() {
      String url = null;
      try {
        if (SystemProperty.environment.value() ==
            SystemProperty.Environment.Value.Production) {
          // Load the class that provides the new "jdbc:google:mysql://" prefix.
          Class.forName("com.mysql.jdbc.GoogleDriver");
          url = "jdbc:google:mysql://americana-1185:worldpolice/results?user=root";
        } else {
          //TODO Debug.
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
      return url;
    }



}

