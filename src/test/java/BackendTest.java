package myapp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BackendTest {

  /**
   * Make sure we don't have leftover data.
   */
  @After
  public void deleteData() {
    /*try {
      new File("test.db").delete();
    } catch (Exception e) {
      e.printStackTrace();
    }*/
  }

  /**
   * Test that our countries have unique images.
   */
  @Test
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
   * Test that our countries have unique names.
   */
  @Test
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
  @Test
  public void testLogResults() {
    ResultServlet serve = new ResultServlet();
    assertTrue(serve.makeTable());
  }

  /**
   * Test that we calculate our own things correctly.
   */
  @Test
  public void testElo() {
    EloServlet serve = new EloServlet();
    for (Map.Entry<String, Integer> ranking :
        serve.sortRankings(serve.getRankings())) {
      System.out.println(ranking.getKey() + " " + ranking.getValue());
    }
  }
}
