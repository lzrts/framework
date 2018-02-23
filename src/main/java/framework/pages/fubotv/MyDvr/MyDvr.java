package framework.pages.fubotv.MyDvr;

import com.google.common.base.Function;
import framework.pages.Page;
import framework.pages.fubotv.entertainment.EntertainmentSeries;
import framework.utility.LogFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public class MyDvr extends Page {

    private static final Logger LOG = LogFactory.getLogger(EntertainmentSeries.class);

    @FindBy(xpath = "//input[@placeholder='Find by Title, Team, League or Channel.']")
    private WebElement searchInputFieldDvr;

    @Step("Finding Seriel in search input field")
    public boolean findSerielInSearchInputField(String findByText) {
        LOG.info("Finding scheduled item");
//		searchButton.click();
        jsClickOnElement(searchInputFieldDvr);
        LOG.info("Clicked on searchInputFieldDvr");
        searchInputFieldDvr.sendKeys(findByText);
        LOG.info(findByText);
//		wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@class='ReactVirtualized__Grid__innerScrollContainer']//div[@data-css-1jutx3y=''][1]//div[contains(@class,'media-tile-caption') and normalize-space(text()='" + recentlyAiredSeriel.getText() + "')]"))));
        return webDriver.findElement(By.xpath("//*[@class='ReactVirtualized__Grid__innerScrollContainer']//div[@data-css-1jutx3y=''][1]//div[contains(@class,'media-tile-caption') and normalize-space(text()='" + findByText + "')]")).isDisplayed();
    }


    public MyDvr(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public java.util.function.Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(searchInputFieldDvr);
    }
}
