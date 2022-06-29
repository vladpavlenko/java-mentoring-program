package pages.steam;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SteamHomePage extends BasePage {
  static SelenideElement searchField = $(By.id("store_nav_search_term"));
  static SelenideElement searchSuggestionFirstItem = $("div#search_suggestion_contents > a");

  public static final String URL = "https://store.steampowered.com/";

  public static void openURL() {
    open(URL);
    logger.info("Opened Steam home page");
  }

  public static void performSearchAndFirstItem(String searchRequest) {
    logger.info("perform search and click first item");
    searchField.setValue(searchRequest);
    searchSuggestionFirstItem.click();
  }
}
