package pages.hotline;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HotlineHomePage extends BasePage {
  static SelenideElement searchField = $(By.id("searchbox"));
  static SelenideElement searchButton = $(By.id("doSearch"));

  public static final String URL = "https://hotline.ua/";

  public static void openURL() {
    open(URL);
    logger.info("Opened Hotline home page");
  }

  public static void performSearchAndClickResult(String searchRequest) {
    logger.info("perform search");
    searchField.setValue(searchRequest);
    searchButton.click();
  }
}
