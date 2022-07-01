package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import pages.skyup.SkyUpDeparturePage;
import pages.skyup.SkyUpDirectionsPage;
import pages.skyup.SkyUpHomePage;
import pages.skyup.SkyUpLandingPage;

public class SkyUpHomeTest extends BaseTest{
  @Test
  @Story("Order tickets on SkyUp site")
  @Description("Order tickets on SkyUp site")
  public void searchAndBookTicketsTest() {
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
