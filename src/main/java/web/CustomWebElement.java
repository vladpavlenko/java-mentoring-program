package web;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//example of a page implemented per Strategy pattern
//methods from CustomWebElement and WebElement become interchangeable
//methods called from CustomWebElement extend capabilities of WebElement's methods
public class CustomWebElement implements WebElement {
    private static final int WAIT_TIMEOUT_SEC = 5;
    private static final int SLEEP_TIMEOUT_MS = 100;
    protected final WebDriver driver;
    protected final String name;
    protected final WebDriverWait wait;
    protected By byLocator;

    public WebElement getWebElement() {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Don't see " + this, e);
        }
    }

    public CustomWebElement(WebDriver driver, String name) {
        this.driver = driver;
        wait = newWait(WAIT_TIMEOUT_SEC);
        this.name = name;
    }

    protected WebDriverWait newWait(int timeout) {
        return new WebDriverWait(this.driver, Duration.ofSeconds(timeout), Duration.ofSeconds(SLEEP_TIMEOUT_MS));
    }

    public void click() {
        click(5);
    }

    public void click(int timeout) {
    }

    @Override
    public void submit() {
        wait.until(ExpectedConditions.visibilityOf(this)).submit();
    }

    public void sendKeys(CharSequence... value) {
        sendKeys(5, value);
    }

    public void sendKeys(int timeout, CharSequence... value) {
        try {
            WebElement element = getWebElement();
            newWait(timeout).until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(value);
        } catch (TimeoutException e) {
            throw new TimeoutException("Failed to send keys to " + name + " with locator " + byLocator, e);
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String propertyName) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return null;
    }
}
