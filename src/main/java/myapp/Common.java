package myapp;

import java.io.IOException;
import javax.servlet.http.*;

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

}

