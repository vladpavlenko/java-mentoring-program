package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.CustomWebElement;

public class GoogleSearchPage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")
    private CustomWebElement searchInputField;

    private final String URL = "https://google.com/";

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
    }

}
