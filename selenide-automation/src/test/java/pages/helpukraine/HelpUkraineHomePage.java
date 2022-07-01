package pages.helpukraine;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HelpUkraineHomePage extends BasePage {
  public static final String URL = "https://helpukraine.center/";

  public static void openURL() {
    open(URL);
    logger.info("Opened HelpUkraine home page");
  }
}
