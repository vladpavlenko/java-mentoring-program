package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.steam.SteamAgeRestrictionPage;
import pages.steam.SteamHomePage;
import pages.steam.SteamItemPage;

public class SteamHomeTest extends BaseTest{
  @Test
  @Story("Search Steam for Resident evil")
  @Description("Verify age restriction validation")
  public void verifyAgeValidationTest() {
    SteamHomePage.openURL();
    SteamHomePage.performSearchAndFirstItem("resident evil");
    SteamAgeRestrictionPage.selectYearOfBorn("1992");
    SteamAgeRestrictionPage.clickOnViewProductButton();
    SteamItemPage.verifyTitle("Resident Evil Village");
  }
}
