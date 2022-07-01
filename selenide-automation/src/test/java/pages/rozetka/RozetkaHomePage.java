package pages.rozetka;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RozetkaHomePage extends BasePage {
  static SelenideElement searchField = $(By.name("search"));
  static SelenideElement searchButton = $(By.xpath("//button[contains(text(), 'Найти')]"));

  public static final String URL = "https://rozetka.com.ua/";

  public static void openURL() {
    open(URL);
    logger.info("Opened Rozetka home page");
  }

  public static void performSearchAndClickResult(String searchRequest) {
    logger.info("perform search");
    searchField.setValue(searchRequest);
    searchButton.click();
  }
}
