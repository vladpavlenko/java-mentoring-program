package test;

import org.testng.annotations.Test;
import page.GoogleSearchPage;
import util.BaseTest;

public class BasicSearchTest extends BaseTest {

    @Test
    public void shouldPerformSearch() throws InterruptedException {
        GoogleSearchPage searchPage = new GoogleSearchPage(getDriver());
        getDriver().manage().window().maximize();
        openURL("https://google.com/");
        searchPage.searchForElementAndClick("epam", "Epam");
    }
}
