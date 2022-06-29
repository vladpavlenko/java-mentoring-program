package pages.google;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleHomePage extends BasePage {
  static SelenideElement searchField = $(By.name("q"));

  public static final String URL = "https://google.com/";

  public static void openURL() {
    open(URL);
    logger.info("Opened Rozetka home page");
  }

  public static void performSearchAndClickResult(String searchText, String resultText) {
    logger.info("perform search");
    searchField.setValue(searchText);
    $(By.xpath("//span[text()='" + resultText + "']")).should(appear).click();
  }
}
