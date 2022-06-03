package test;

import custom.MyAnnotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchPage;
import util.BaseTest;

public class BasicSearchTest extends BaseTest {

    @Test
    public void shouldPerformSearch() {
        GoogleSearchPage searchPage = new GoogleSearchPage(getDriver());
        getDriver().manage().window().maximize();
        openURL("https://google.com/");
        searchPage.searchForElementAndClick("epam", "Epam");
    }

    @Test
    @MyAnnotation(name="UI")
    public void shouldPerformSomethingInTheFuture() {
        Assert.assertEquals(true, true);
    }

    @Test
    @MyAnnotation(name="UI")
    public void shouldExistForStatistics() {
        Assert.assertEquals(true, true);
    }
}
