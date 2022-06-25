package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import util.BrowserList;
import util.DriverManager;

public class BaseTest {

    public BrowserList chrome = BrowserList.CHROME; //in a proper project this should come from Properties file

    protected static WebDriver driver() {
        return DriverManager.getDriver();
    }

    @BeforeSuite
    public void BeforeSuite() {
        DriverManager.initDriver(chrome);
    }

    @AfterSuite
    public void afterSuite() {
        if (driver() != null) {
            driver().close();
            driver().quit();
        }
    }

    public void openURL(String websiteURL) {
        driver().get(websiteURL);
    }
}
