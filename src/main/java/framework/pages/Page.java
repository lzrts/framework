package framework.pages;

import com.google.common.base.Function;
import framework.utility.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
 * Abstract class representation of a Page in the UI with additional features. Page object pattern
 */
public abstract class Page implements IPageLoaded {

    public static final Logger LOG = LogFactory.getLogger(Page.class);

    protected WebDriver webDriver;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public String getPageUrl() {
        return webDriver.getCurrentUrl();
    }

    public boolean isElementPresent(WebElement element) {
        LOG.info("Checking if element is present " + element);
        try {
            element.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebDriverWait getWebDriverWait(int seconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, seconds);
        return wait;
    }

    public void jsClickOnElement(WebElement webElement) {
        LOG.info("Clicking on web element " + webElement);
        getJSExecutor().executeScript("arguments[0].click();", webElement);
    }

    public void scrollToElement(WebElement webElement) {
        LOG.info("Scrolling to web element " + webElement);
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public void switchToTab() {
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
    }

    public void switchToNewBrowserWindow() {
        String winHandleBefore = webDriver.getWindowHandle(); // Perform the click operation that opens new window
    }

    public void performActionsOnNewWindow() {
        for (String winHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(winHandle);
        }
    }

    public void switchToDefaultBrowserWindow() { //the method is not working yet, need to investigate
        String winHandleBefore = webDriver.getWindowHandle();
        webDriver.switchTo().window(winHandleBefore); // Switch back to original browser (first window)
    }


    public String emailGeneration() {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        return date + "@dummy.com";
    }

    public String standartPassword(){
        String stPassword = "testonly1";
        return stPassword;
    }

    public String standartEmail(){
        String stEmail = "tstr@dummy.com";
        return stEmail;
    }

    public void switchToIFrame(WebElement webElement) {
        LOG.info("Switching to web element " + webElement);
        webDriver.switchTo().frame(webElement);
    }

    public void switchToDefault() {
        webDriver.switchTo().defaultContent();
    }


    public boolean isElementPresent(int seconds, WebElement webElement) {
        try {
            getWebDriverWait(seconds).until(driver -> webElement.isEnabled());
            return true;
        } catch (TimeoutException e) {
            LOG.error("Element is not available");
            return false;
        }
    }

    private JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) webDriver;
    }

}