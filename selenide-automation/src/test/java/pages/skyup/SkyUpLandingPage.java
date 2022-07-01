package pages.skyup;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SkyUpLandingPage extends BasePage {
  static SelenideElement arrivalCityField = $(By.xpath("//input[@id='arrivalCityName']//parent::div"));
  static SelenideElement athensCityOption = $(By.xpath("//span[contains(text(), 'Афіни')]"));
  static SelenideElement forwardDateDatePicker = $(By.id("forwardDateItem"));
  static ElementsCollection dateOptions = $$(By.xpath("//div[@class='day toMonth valid tooltip-trigger']"));
  static SelenideElement searchForTicketsButton = $(By.xpath("//button[contains(text(), 'Пошук квитків')][not(@id='searchBtn')]"));

  public static void clickArrivalCityField() {
    arrivalCityField.click();
  }

  public static void selectAthensCityOption() {
    athensCityOption.should(appear).click();
  }

  public static void openForwardDateDatePicker() {
    forwardDateDatePicker.click();
  }

  public static void selectFirstAvailableDateFromThePage() {
    dateOptions.first().should(appear).click();
  }

  public static void clickSearchButton() {
    searchForTicketsButton.should(appear).click();
  }
}
