package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static WebDriver driver = null;

    //example of a Singleton pattern functionality
    // we shouldn't create a new instance of a Driver when one is already existing
    public static WebDriver initDriver(BrowserList browserName) {
        if (driver == null) {
            switch (browserName) {
                case CHROME -> driver = new ChromeDriver();
                case MOZILLA -> driver = new FirefoxDriver();
                case EDGE -> driver = new EdgeDriver();
                case SAFARI -> driver = new SafariDriver();
            }
            System.out.println("New instance of WebDriver created");
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
