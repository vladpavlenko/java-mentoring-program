package pages.steam;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SteamAgeRestrictionPage extends BasePage {
  static SelenideElement yearDropdown = $(By.id("ageYear"));
  static SelenideElement viewProductButton = $(By.id("view_product_page_btn"));

  public static void selectYearOfBorn(String year) {
    logger.info("select year of born as: " + year);
    yearDropdown.selectOptionByValue(year);
  }

  public static void clickOnViewProductButton() {
    logger.info("clicking on the View Product button");
    viewProductButton.click();
  }
}
