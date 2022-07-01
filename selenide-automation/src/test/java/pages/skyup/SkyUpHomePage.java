package pages.skyup;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SkyUpHomePage extends BasePage {
  static SelenideElement modalWindowCloseIcon = $(By.xpath("//*[@id='open-appeal-modal']/div/div[2]/button"));
  static SelenideElement agreementAgreeButton = $(By.xpath("//button[contains(text(), 'Погодитися')]"));
  static SelenideElement passengersDropdown = $(By.id("headerTriggerDropdownPassengers"));
  static SelenideElement flightsOption = $(By.xpath("//*[@id='headerDropdownPassengers']/li[4]/a/span"));

  public static final String URL = "https://skyup.aero/uk/";

  public static void openURL() {
    open(URL);
    logger.info("Opened SkyUp home page");
  }

  public static void closeModalWindow() {
    modalWindowCloseIcon.shouldBe(Condition.visible).click();
  }

  public static void clickAgreeButton() {
    agreementAgreeButton.click();
  }

  public static void openPassengersDropdown() {
    passengersDropdown.click();
  }

  public static void selectFlightsOption() {
    flightsOption.should(appear).click();
  }
}
