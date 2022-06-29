package pages.hotline;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HotlineSearchPage extends BasePage {
  static ElementsCollection comparePriceButtons = $$(".btn btn--orange");
  static SelenideElement rtx3080ItemNameLink = $(By.xpath("//a[contains(text(), 'MSI GeForce RTX 3080 Ti SUPRIM X 12G')]"));

  public static void verifyOnlyOneResultReturned() {
    logger.info("waiting for results to appear");
    comparePriceButtons.shouldHave(CollectionCondition.size(1));
    logger.info("only one item returned as expected");
  }

  public static void clickOnTheItem() {
    logger.info("clicking on the selected item");
    rtx3080ItemNameLink.click();
  }
}
