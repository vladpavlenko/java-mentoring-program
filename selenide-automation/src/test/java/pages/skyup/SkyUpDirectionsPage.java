package pages.skyup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class SkyUpDirectionsPage extends BasePage {
  static SelenideElement georgiaDirection = $(By.xpath("//div[contains(text(), 'Грузія')]"));

  public static void chooseCountryFromList() {
    $(By.xpath("//div[contains(text(), 'Грузія')]")).should(appear).click();
  }
}
