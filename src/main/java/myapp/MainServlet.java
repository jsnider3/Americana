package myapp;

import java.io.IOException;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("{ \"name\": \"" + getCountryName(0) +
          "\", \"image\": \"" + getCountryImage(0) + "\" }");
    }

    /**
     * Get a picture of a country given it's unique ID.
     */
    private String getCountryImage(int id) {
      String url = "";
      switch (id) {
        default:
          url =
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/USA_orthographic.svg/220px-USA_orthographic.svg.png";
          break;
      }
      return url;
    }

    /**
     * Get the name of a country given it's unique ID.
     */
    private String getCountryName(int id) {
      String country = "";
      switch (id) {
        default:
          country = "United States of America";
          break;
      }
      return country;
    }

}
