package steps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;


public class SearchSteps {
  public static void searchForElementAndClick(String searchText, String resultText) {
    $(By.name("q")).setValue(searchText);
    $(By.xpath("//span[text()='" + resultText + "']")).should(appear).click();
  }
}
