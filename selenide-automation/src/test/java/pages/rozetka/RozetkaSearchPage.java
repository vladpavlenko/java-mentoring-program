package pages.rozetka;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class RozetkaSearchPage extends BasePage {
  static SelenideElement allResultsLabel = $(By.xpath("//span[text() = ' Все результаты ']"));

  public static void waitForResultsPageToAppear() {
    logger.info("waiting for results page");
    allResultsLabel.should(appear);
    logger.info("results appeared");
  }
}
