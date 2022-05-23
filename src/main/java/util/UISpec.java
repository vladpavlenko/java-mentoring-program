package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;

public class UISpec {
    public WebDriver driver;

    public void invokeBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("Mozilla")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new SafariDriver();
        }
    }

    public void openURL(String websiteURL) {
        driver.get(websiteURL);
    }

    public void closeWindow() {
        driver.close();
    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }

    public void enterText(String xpath, String text) {
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }
}
