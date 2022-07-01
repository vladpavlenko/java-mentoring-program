package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.google.GoogleHomePage;
import pages.helpukraine.HelpUkraineHomePage;
import pages.hotline.HotlineHomePage;
import pages.hotline.HotlineItemPage;
import pages.hotline.HotlineSearchPage;
import pages.rozetka.RozetkaHomePage;
import pages.rozetka.RozetkaSearchPage;
import pages.skyup.SkyUpDeparturePage;
import pages.skyup.SkyUpDirectionsPage;
import pages.skyup.SkyUpHomePage;
import pages.skyup.SkyUpLandingPage;
import pages.steam.SteamAgeRestrictionPage;
import pages.steam.SteamHomePage;
import pages.steam.SteamItemPage;

import static com.codeborne.selenide.Selenide.*;

@Feature("Selenide automation mentoring")
public class SelenideTestCase extends BaseTest{

  @Test
  @Story("Open Rozetka and search for cozy hamster blankets")
  @Description("Happy Path test of search")
  public void openRozetkaHomePageAndPerformSearch() {
    RozetkaHomePage.openURL();
    RozetkaHomePage.performSearchAndClickResult("плед-хомяк");
    RozetkaSearchPage.waitForResultsPageToAppear();
  }

  @Test
  @Story("Search Hotline for graphics card")
  @Description("Happy Path test of search")
  public void hotlineTest() {
    HotlineHomePage.openURL();
    HotlineHomePage.performSearchAndClickResult("MSI GeForce RTX 3080 Ti SUPRIM X 12G");
    HotlineSearchPage.verifyOnlyOneResultReturned();
    HotlineSearchPage.clickOnTheItem();
    HotlineItemPage.verifyNumberOfBuyButtons();
  }

  @Test
  @Story("Search Steam for Resident evil")
  @Description("Verify age restriction validation")
  public void steamTest() {
    SteamHomePage.openURL();
    SteamHomePage.performSearchAndFirstItem("resident evil");
    SteamAgeRestrictionPage.selectYearOfBorn("1992");
    SteamAgeRestrictionPage.clickOnViewProductButton();
    SteamItemPage.verifyTitle("Resident Evil Village");
  }

  @Test
  @Story("Simple Google search")
  @Description("Happy Path test of search")
  public void googleTest() {
    GoogleHomePage.openURL();
    GoogleHomePage.performSearchAndClickResult("epam", "Epam");
  }

  @Test
  @Story("Stand with Ukraine")
  @Description("Stand with Ukraine")
  public void standWithUkraine() {
    HelpUkraineHomePage.openURL();
    takeScreenshot("HelpUkraineScreenshot");
    Assert.assertEquals("Help Ukraine Center", title());
  }

  @Test
  @Story("Order tickets on SkyUp site")
  @Description("Order tickets on SkyUp site")
  public void skyUpTest() {
    SkyUpHomePage.openURL();
    SkyUpHomePage.closeModalWindow();
    SkyUpHomePage.clickAgreeButton();
    SkyUpHomePage.openPassengersDropdown();
    SkyUpHomePage.selectFlightsOption();
    SkyUpDirectionsPage.chooseCountryFromList();
    SkyUpLandingPage.clickArrivalCityField();
    SkyUpLandingPage.selectAthensCityOption();
    SkyUpLandingPage.openForwardDateDatePicker();
    SkyUpLandingPage.selectFirstAvailableDateFromThePage();
    SkyUpLandingPage.clickSearchButton();
    SkyUpDeparturePage.clickSelectButton();
    SkyUpDeparturePage.selectEconomOption();
    SkyUpDeparturePage.clickNextButton();
    //I don't want to enter my personal info :)
  }
}
