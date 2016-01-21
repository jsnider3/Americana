package myapp;

import junit.framework.TestCase;
import org.junit.Before;
import java.io.File;
import java.util.HashSet;

public class BackendTest extends TestCase {

  /**
   * Make sure we don't have leftover data.
   */
  @Before
  public void deleteData() {
    try {
      new File("test.db").delete();
    } catch (Exception e){}
  }

  /**
   * Test that are countries have unique images.
   */
  public void testCountryURLs() {
    CountryServlet serve = new CountryServlet();
    assertTrue(serve.getCountryImage(-1).equals(""));
    assertTrue(serve.getCountryImage(Common.NUM_COUNTRIES).equals(""));
    HashSet<String> urls = new HashSet<String>();
    for (int id = 0; id < Common.NUM_COUNTRIES; id++) {
      urls.add(serve.getCountryImage(id));
    }
    assertTrue(urls.size() == Common.NUM_COUNTRIES);
    assertFalse(urls.contains(""));
  }

  /**
   * Test that are countries have unique names.
   */
  public void testCountryNames() {
    CountryServlet serve = new CountryServlet();
    assertTrue(serve.getCountryName(-1).equals("Invalid country"));
    assertTrue(
      serve.getCountryName(Common.NUM_COUNTRIES).equals("Invalid country"));
    HashSet<String> names = new HashSet<String>();
    for (int id = 0; id < Common.NUM_COUNTRIES; id++) {
      names.add(serve.getCountryName(id));
    }
    assertTrue(names.size() == Common.NUM_COUNTRIES);
    assertFalse(names.contains("Invalid country"));
  }

  /**
   * Test that we record results.
   */
  public void testLogResults() {
    ResultServlet serve = new ResultServlet();
    assertTrue(serve.makeTable());
  }

}
