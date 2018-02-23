package framework.pages.fubotv.entertainment;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import framework.utility.LogFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;

import java.util.function.Function;

public class EntertainmentHome extends Page {
    private static final Logger LOG = LogFactory.getLogger(EntertainmentHome.class);

    @FindBy(xpath = "//div[@class='menu']//a[@href='/entertainment/series']")
    private WebElement seriesTab;

    @FindBy(xpath = "//a[@href='/entertainment/movies']//span[contains(.,'movies')]")
    private WebElement moviesTab;

    @FindBy(xpath = "//div[@class='wristbands-wrapper']") //div[@class='wristbands-wrapper']/*[3]
    private WebElement carouselWristband;

    @FindBy(xpath = "//span[contains(.,'Live Series')]")
    private WebElement liveSeries;

    @FindBy(xpath = "//span[contains(.,'Recently Aired Series')]")
    private WebElement recentlyAiredSeries;

    @FindBy(xpath = "//span[contains(.,'Live Movies')]")
    private WebElement liveMovies;

    @FindBy(xpath = "//span[contains(.,'Recently Aired Movies')]")
    private WebElement recentlyAiredMovies;

    @FindBy(xpath = "//div[@class='slick-slide slick-active'][2]//button[contains(.,'Watch Live')]")
    private WebElement playLiveVideo;


    public EntertainmentHome(WebDriver webDriver) {
        super(webDriver);

    }

    @Step("Checking Live Series section is displayed")
    public boolean isLiveSeriesDisplayed() {
        LOG.info("Checking Live Series section is displayed");
        return liveSeries.isDisplayed();
    }

    @Step("Checking recentlyAiredSeries section is displayed")
    public boolean isRecentlyAiredSeries() {
        LOG.info("Checking Live Series section is displayed");
        return recentlyAiredSeries.isDisplayed();
    }

    @Step("Checking Live Movies section is displayed")
    public boolean isLiveMovies() {
        LOG.info("Checking Live Movies section is displayed");
        return liveMovies.isDisplayed();
    }

    @Step("Checking Recently Aired Movies section is displayed")
    public boolean isrecentlyAiredMovies() {
        LOG.info("Checking Recently Aired Movies section is displayed");
        return recentlyAiredMovies.isDisplayed();
    }

    @Step("Clicking on playLiveVideo")
    public EntertainmentHome clickOnPlayLiveVideo() {
        LOG.info("Clicking on playLiveVideo");
        playLiveVideo.click();
        //wait
        return this;
    }

    @Step("Clicking on seriesTab")
    public EntertainmentSeries clickOnSeriesTab() {
        LOG.info("Clicking on seriesTab");
        seriesTab.click();
        //wait
        return FuboTVPageFactory.initElements(webDriver, EntertainmentSeries.class);
    }

    @Step("Clicking on moviesTab")
    public EntertainmentMovies clickOnMoviesTab() {
        LOG.info("Clicking on moviesTab");
        moviesTab.click();
        //wait
        return FuboTVPageFactory.initElements(webDriver, EntertainmentMovies.class);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(seriesTab);
    }
}
