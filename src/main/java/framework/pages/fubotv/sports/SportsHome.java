package framework.pages.fubotv.sports;

import com.google.common.base.Function;
import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import framework.pages.fubotv.MyDvr.MyDvr;
import framework.pages.fubotv.entertainment.EntertainmentHome;
import framework.utility.LogFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;

public class SportsHome extends Page {

    private static final Logger LOG = LogFactory.getLogger(SportsHome.class);

    @FindBy(xpath = "//span[contains(.,'sports')]")
    private WebElement sportsTab;

    @FindBy(xpath = "//div[@id='root']//a[@href='/sports/111/football']")
    private WebElement footballTab;

    @FindBy(xpath = "//div[@id='root']//a[@href='/sports/199/soccer']")
    private WebElement soccerTab;

    @FindBy(xpath = "//div[@id='root']//a[@href='/sports/59/basketball']")
    private WebElement basketballTab;

    @FindBy(xpath = "//div[@class='long-dvr-button']//*[@type='button']//span[text()='Record']")
    private WebElement recordButton;

    @FindBy(xpath = "(//div[@class='long-dvr-button'])[]//button") //not sure if it's correct one
    private WebElement recordDvrButton;

    @FindBy(xpath = "(//div[@data-css-92pgci=\"\"])[7]") //not sure if it's correct one
    private WebElement match;

    @FindBy(xpath = "//span[contains(.,'entertainment')]")
    private static WebElement entertainmentTab;

    public SportsHome(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Checking sports tab is displayed")
    public boolean isSportsButtonDisplayed() {
        LOG.info("Checking sports tab is displayed");
        return sportsTab.isDisplayed();
    }

    @Step("Checking football tab is displayed")
    public boolean isFootballButtonDisplayed() {
        LOG.info("Checking football tab is displayed");
        return footballTab.isDisplayed();
    }

    @Step("Clicking on entertainment tab")
    public EntertainmentHome clickOnEntertainmentTab() {
        LOG.info("Clicking on entertainment tab");
        entertainmentTab.click();
        return FuboTVPageFactory.initElements(webDriver, EntertainmentHome.class);
    }

    @Step("Clicking on recordDvrButton")
    public MyDvr clickOnRecordDvrButton() {
        LOG.info("Clicking on recordDvrButton");
        recordDvrButton.click();
        return FuboTVPageFactory.initElements(webDriver, MyDvr.class);
    }

    @Step("Getting text from the match")
    public SportsHome getTextfromMatch() {
        LOG.info("Getting text from the match");
        String str = match.getText();
        str = str.replaceAll("(\\r|\\n)", " ");
        LOG.info(str);
        return FuboTVPageFactory.initElements(webDriver, SportsHome.class);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(sportsTab);
    }
}