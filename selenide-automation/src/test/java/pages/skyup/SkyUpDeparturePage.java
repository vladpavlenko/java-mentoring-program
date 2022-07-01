package pages.skyup;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SkyUpDeparturePage extends BasePage {
  static SelenideElement selectButton = $(By.xpath("//div[text()='Вибрати']"));
  static SelenideElement economOption = $(By.xpath("//*[@id='forwardEconomModal']/div/div[2]/div/div/div[1]/div[2]/button/span[1]"));
  static SelenideElement nextButton = $(By.id("progressNextBtn"));

  public static void clickSelectButton() {
    selectButton.shouldBe(visible).click();
  }

  public static void selectEconomOption() {
    economOption.should(appear).click();
  }

  public static void clickNextButton() {
    nextButton.should(appear).click();
  }
}
