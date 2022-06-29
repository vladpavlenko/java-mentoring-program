package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.google.GoogleHomePage;
import pages.hotline.HotlineHomePage;
import pages.hotline.HotlineItemPage;
import pages.hotline.HotlineSearchPage;
import pages.rozetka.RozetkaHomePage;
import pages.rozetka.RozetkaSearchPage;
import pages.steam.SteamAgeRestrictionPage;
import pages.steam.SteamHomePage;
import pages.steam.SteamItemPage;
import steps.SearchSteps;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
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
    open("https://helpukraine.center/");
    //take screenshot at any given moment
    screenshot("standWithUkraineScreen" + new Random().nextInt(999));
    Assert.assertEquals("Help Ukraine Center", title());
  }

  @Test
  @Story("Order tickets on SkyUp site")
  @Description("Order tickets on SkyUp site")
  public void skyUpTest() {
    open("https://skyup.aero/uk/");
    $(By.xpath("//*[@id='open-appeal-modal']/div/div[2]/button")).shouldBe(Condition.visible).click();
    $(By.xpath("//button[contains(text(), 'Погодитися')]")).click();
    $(By.id("headerTriggerDropdownPassengers")).click();
    $(By.xpath("//*[@id='headerDropdownPassengers']/li[4]/a/span")).should(appear).click();
    $(By.xpath("//div[contains(text(), 'Грузія')]")).should(appear).click();
    $(By.xpath("//input[@id='arrivalCityName']//parent::div")).click();
    $(By.xpath("//span[contains(text(), 'Афіни')]")).should(appear).click();
    $(By.id("forwardDateItem")).click();
    $$(By.xpath("//div[@class='day toMonth valid tooltip-trigger']")).filterBy(enabled).first().should(appear).click();
    $(By.xpath("//button[contains(text(), 'Пошук квитків')][not(@id='searchBtn')]")).should(appear).click();
    $(By.xpath("//div[text()='Вибрати']")).shouldBe(visible).click();
    $(By.xpath("//*[@id='forwardEconomModal']/div/div[2]/div/div/div[1]/div[2]/button/span[1]")).should(appear).click();
    $(By.id("progressNextBtn")).should(appear).click();
    //I don't want to enter my personal info :)
  }
}
