package tests;

import custom.MyAnnotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseSteps;
import steps.GoogleSearchSteps;
import util.DriverManager;

public class BasicSearchTest extends BaseTest {

    @Test
    public void shouldPerformSearch() {
        DriverManager.initDriver(chrome);
        BaseSteps.navigateToGoogleSearchPage(); //navigate to Google main page regardless of the Env. example of Facade pattern
        GoogleSearchSteps.searchForElementAndClick("epam", "Epam");
    }

    @Test
    @MyAnnotation(name="UI")
    public void shouldPerformSomethingInTheFuture() {
        DriverManager.initDriver(chrome); //returning existing instance, because Singleton
        Assert.assertEquals(true, true);
    }

    @Test
    @MyAnnotation(name="UI")
    public void shouldExistForStatistics() {
        DriverManager.initDriver(chrome); //returning existing instance, because Singleton
        Assert.assertEquals(true, true);
    }
}
