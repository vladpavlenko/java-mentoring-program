package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.impl.Waiter;
import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Rule;

import java.util.logging.Logger;

public class BaseTest {
  /**
   *  Rule to take screenshots for both passed and failed tests
   */
  @Rule
  public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

  /**
   *  The task requirement says to user implicit waiter class
   *  But, I wouldn't use it, since the default selenide ".should" method is enough in most cases
   */
  private final Waiter waiter = new Waiter();

  Logger logger = java.util.logging.Logger.getLogger(BaseTest.class.getName());

  @Before
  public void setUp() {
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }
}
