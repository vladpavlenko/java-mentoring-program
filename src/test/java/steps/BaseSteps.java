package steps;

import pages.BasePage;
import util.DriverManager;

public class BaseSteps {
    public static BasePage basePage = new BasePage(DriverManager.getDriver());
    public static SharedContent sharedContent;

    /*this represents a Facade pattern
      when the project goes larger and we have multiple envs to run tests against,
      this method will navigate to the Search page regardless of the current env
    */
    public static void navigateToGoogleSearchPage() {
        System.out.println("Navigate to search page");
        sharedContent.googleSearchPage.navigateTo();
    }
}
