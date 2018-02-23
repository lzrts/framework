package framework.pages.fubotv.entertainment;

import framework.pages.Page;
import framework.utility.LogFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.util.function.Function;

public class EntertainmentSeries extends Page {
    private static final Logger LOG = LogFactory.getLogger(EntertainmentSeries.class);

    @FindBy(xpath = "//a[@href='/entertainment/series']//span[contains(.,'series')]")
    private WebElement seriesTab;

    @FindBy(xpath = "//span[contains(.,'Live Series')]")
    private WebElement liveSeries;

    @FindBy(xpath = "//span[contains(.,'Recently Aired')]")
    private WebElement recentlyAired;

    @FindBy(xpath = "//span[contains(.,'Upcoming')]")
    private WebElement upcoming;

    @FindBy(xpath = "//span[contains(.,'Series On Demand')]")
    private WebElement seriesOnDemand;

    @FindBy(xpath = "//div[@class='glass-icon']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='Search series by title...']")
    private WebElement searchInputField;

    @FindBy(xpath = "//div[@class='cancel']")
    private WebElement cancelButton;

    @FindBy(xpath = "//span[@class='slick-slide slick-active']")
    private WebElement allLetter;

    @FindBy(xpath = "//div[@class='slick-slide slick-active'][1]//div[@class='title']")
    private WebElement recentlyAiredSeriel;//[2] element from Recently Aired series list

    @Step("Finding Seriel in search input field")
    public boolean findSerielInSearchInputField() {
        LOG.info("Finding Seriel in search input field");
        jsClickOnElement(searchButton);
        LOG.info("Clicked on search button");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchInputField));
        searchInputField.sendKeys(recentlyAiredSeriel.getText());
        LOG.info(recentlyAiredSeriel.getText());
        return webDriver.findElement(By.xpath("//*[@class='ReactVirtualized__Grid__innerScrollContainer']//div[@data-css-1jutx3y=''][1]//div[contains(@class,'media-tile-caption') and normalize-space(text()='" + recentlyAiredSeriel.getText() + "')]")).isDisplayed();
    }


    public EntertainmentSeries(WebDriver webDriver) {
        super(webDriver);

    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(searchButton);
    }
}
