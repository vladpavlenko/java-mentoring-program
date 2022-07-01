package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.google.GoogleHomePage;

public class GoogleHomeTest extends BaseTest{
  @Test
  @Story("Simple Google search")
  @Description("Happy Path test of search")
  public void performSearchAndSelectResultTest() {
    GoogleHomePage.openURL();
    GoogleHomePage.performSearchAndClickResult("epam", "Epam");
  }
}
