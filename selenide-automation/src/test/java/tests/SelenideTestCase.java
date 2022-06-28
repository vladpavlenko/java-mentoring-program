package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import steps.SearchSteps;

import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Feature("Selenide automation mentoring")
public class SelenideTestCase extends BaseTest{

  @Test
  @Story("Open Rozetka and search for cozy hamster blankets")
  @Description("Happy Path test of search")
  public void rozetkaTest() {
    logger.info("navigate to rozetka");
    open("https://rozetka.com.ua/");
    logger.info("perform search");
    $(By.name("search")).setValue("плед-хомяк");
    $(By.xpath("//button[text() = ' Найти ']")).click();
    logger.info("validate results");
    $(By.xpath("//span[text() = ' Все результаты ']")).should(appear);
  }

  @Test
  @Story("Search Hotline for graphics card")
  @Description("Happy Path test of search")
  public void hotlineTest() {
    open("https://hotline.ua/");
    $(By.id("searchbox")).setValue("MSI GeForce RTX 3080 Ti SUPRIM X 12G");
    $(By.id("doSearch")).click();
    $$(".btn btn--orange").shouldHave(sizeLessThan(2));
    $(By.xpath("//a[text() = '\n" +
            "      MSI GeForce RTX 3080 Ti SUPRIM X 12G\n" +
            "    ']")).click();
    SelenideElement totalTitles = $(".many > div");
    totalTitles.should(appear);
    String[] numberOfTitles = totalTitles.getText().trim().split(": ");
    $$(By.xpath("//a[contains(text(), 'Купити')]")).filterBy(Condition.visible).shouldHave(size(Integer.parseInt(numberOfTitles[1])));
  }

  @Test
  @Story("Search Steam for Resident evil")
  @Description("Verify age restriction validation")
  public void steamTest() {
    open("https://store.steampowered.com/");
    $(By.id("store_nav_search_term")).setValue("resident evil");
    $("div#search_suggestion_contents > a").should(appear).click();
    $(By.id("ageYear")).selectOptionByValue("1992");
    $(By.id("view_product_page_btn")).click();
    $(By.id("appHubAppName")).shouldHave(Condition.text("Resident Evil Village"));
  }

  @Test
  @Story("Simple Google search")
  @Description("Happy Path test of search")
  public void googleTest() {
    open("https://google.com/");
    SearchSteps.searchForElementAndClick("epam", "Epam");
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
