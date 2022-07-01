package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.rozetka.RozetkaHomePage;
import pages.rozetka.RozetkaSearchPage;

public class RozetkaHomeTest extends BaseTest{
  @Test
  @Story("Open Rozetka and search for cozy hamster blankets")
  @Description("Happy Path test of search")
  public void openRozetkaHomePageAndPerformSearch() {
    RozetkaHomePage.openURL();
    RozetkaHomePage.performSearchAndClickResult("плед-хомяк");
    RozetkaSearchPage.waitForResultsPageToAppear();
  }
}
