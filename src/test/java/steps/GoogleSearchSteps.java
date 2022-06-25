package steps;

import org.openqa.selenium.By;

public class GoogleSearchSteps extends BaseSteps{

    public static void searchForElementAndClick(String searchText, String resultText) {
        basePage.enterText("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input", searchText);
        basePage.waitForElementToAppear(By.xpath("//span[text()='" + resultText + "']"));
        basePage.clickElement("//span[text()='" + resultText + "']");
    }
}
