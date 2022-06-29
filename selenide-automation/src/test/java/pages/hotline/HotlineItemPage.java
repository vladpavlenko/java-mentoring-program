package pages.hotline;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HotlineItemPage extends BasePage {
  static SelenideElement totalTitles = $(".many > div");
  static ElementsCollection buyButtons = $$(By.xpath("//a[contains(text(), 'Купити')]"));

  public static String getNumberOfTitlesListedOnThePage() {
    return totalTitles.should(Condition.appear).getText().trim().split(": ")[1];
  }

  public static void verifyNumberOfBuyButtons() {
    logger.info("verify number of Buy buttons on the page is accurate");
    buyButtons.filterBy(Condition.visible).shouldHave(size(Integer.parseInt(getNumberOfTitlesListedOnThePage())));
  }
}
