package framework.pages.fubotv.mlp;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class MarketingLandingPage extends Page {

    @FindBy(xpath = "//div[contains(@class,'promo')]/a/span/span")
    private WebElement startTrialButton1;

    @FindBy(xpath = "//p[@class='button']/a")
    private WebElement startTrialButton2;

    @FindBy(xpath = "//div[@class='start-free-trial-button']")
    private WebElement startTrialButton3;

    @FindBy(xpath = "//div[contains(@class,'promo')]")
    public WebElement mlpBanner;

    @FindBy(xpath = "//div[contains(@class,'header-wrap')]/div/*[2]/*[2]//a")
    private WebElement headerChannelsButton;

    @FindBy(xpath = "//div[contains(@class,'header-wrap')]/div/*[2]/*[3]")
    private WebElement headerAppsButton;

    @FindBy(xpath = "//div[@class='device']/a")
    private WebElement bottomAllAppsButton;

    @FindBy(xpath = "//div[contains(@class,'help')]")
    private WebElement headerHelpButton;

    @FindBy(xpath = "//div[@class='login-button']//button")
    private WebElement signInButton;

    @FindBy(xpath = "//div[contains(@class,'lang-dropdown')]")
    private WebElement languageDropDown;

    @FindBy(xpath = "//a[@class='matches-link']")
    private WebElement matchesLinkButton;

    @FindBy(xpath = "//div/a[@href='/welcome']")
    private WebElement fuboTvLogoButton;

    @FindBy(xpath = "//div[@class='carousel-arrow right']")
    private WebElement matchesArrowRightButton;

    @FindBy(xpath = "//div[@class='carousel-arrow left']")
    private WebElement matchesArrowLeftButton;

    public MarketingLandingPage(WebDriver webDriver) {
        super(webDriver);

    }

    @Step("Proceed to SignUp page")
    public SignUpPage openSignUpPage() {

        startTrialButton1.click();

        return FuboTVPageFactory.initElements(webDriver, SignUpPage.class);
    }

    @Step("Proceed to AppsPage")
    public ApplicationsPage openAppsPage() {
        headerAppsButton.click();

        return FuboTVPageFactory.initElements(webDriver, ApplicationsPage.class);
    }

    @Step
    public ChannelsPage openChannelsPage() {
        headerChannelsButton.click();

        return FuboTVPageFactory.initElements(webDriver, ChannelsPage.class);
    }

    @Step("Clicking on Sign In button")
    public SignInModalWindow clickOnSignInButton() {
        LOG.info("Clicking on Sign In button");

        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.visibilityOf(signInButton));

        signInButton.click();
        return FuboTVPageFactory.initElements(webDriver, SignInModalWindow.class);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(signInButton);
    }
}
