package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.BasePage;

public class GoogleSearchPage extends BasePage {

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchForElementAndClick(String searchText, String resultText) {
        enterText("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input", searchText);
        waitForElementToAppear(By.xpath("//span[text()='" + resultText + "']"));
        clickElement("//span[text()='" + resultText + "']");
    }

}
