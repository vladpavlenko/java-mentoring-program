package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;
import pages.helpukraine.HelpUkraineHomePage;

import static com.codeborne.selenide.Selenide.title;

public class HelpUkraineHomeTest extends BaseTest{
  @Test
  @Story("Stand with Ukraine")
  @Description("Stand with Ukraine")
  public void standWithUkraine() {
    HelpUkraineHomePage.openURL();
    takeScreenshot("HelpUkraineScreenshot");
    Assert.assertEquals("Help Ukraine Center", title());
  }
}
