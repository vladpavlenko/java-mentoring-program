package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private WebDriver driver;
    BrowserList chrome = BrowserList.CHROME; //in a proper project this should come from Properties file

    @BeforeSuite
    public void BeforeSuite() {
        switch (chrome) {
            case CHROME:
            default:
                this.driver = new ChromeDriver();
                break;
            case MOZILLA:
                this.driver = new FirefoxDriver();
                break;
            case EDGE:
                this.driver = new EdgeDriver();
                break;
            case SAFARI:
                this.driver = new SafariDriver();
                break;
        }
    }

    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openURL(String websiteURL) {
        driver.get(websiteURL);
    }
}
