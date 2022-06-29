package pages.steam;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SteamItemPage extends BasePage {
  static SelenideElement totalTitles = $(By.id("appHubAppName"));

  public static void verifyTitle(String title) {
    logger.info("verify title of the item page");
    totalTitles.shouldHave(Condition.text(title));
  }
}
