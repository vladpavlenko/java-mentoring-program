package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.hotline.HotlineHomePage;
import pages.hotline.HotlineItemPage;
import pages.hotline.HotlineSearchPage;

public class HotlineHomeTest extends BaseTest{
  @Test
  @Story("Search Hotline for graphics card")
  @Description("Happy Path test of search")
  public void performSearchAndVerifyNumberOfResultsTest() {
    HotlineHomePage.openURL();
    HotlineHomePage.performSearchAndClickResult("MSI GeForce RTX 3080 Ti SUPRIM X 12G");
    HotlineSearchPage.verifyOnlyOneResultReturned();
    HotlineSearchPage.clickOnTheItem();
    HotlineItemPage.verifyNumberOfBuyButtons();
  }
}
