package framework.pages.fubotv.mlp;

import com.google.common.base.Function;
import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChannelsPage extends Page {

    @FindBy(xpath = "//a[@href='/welcome/channels' and @class='active link']")
    private WebElement headerChannelsButton;

    @FindBy(xpath = "//div[@class='start-free-trial-button']")
    private WebElement startTrialButtonChannelsPage;

    @FindBy(xpath = "//div[contains(@class,'help')]")
    private WebElement headerHelpButton;

    @FindBy(xpath = "//div[contains(@class,'header-wrap')]/div/*[2]/*[3]//a")
    private WebElement headerAppsButton;

    @FindBy(xpath = "//div[@class='login-button']//button")
    private WebElement signInButton;

    @FindBy(xpath = "//span[contains(text(),'Let’s Get Started')]")
    private WebElement startTrialFooterButtonChannelsPage;

    @FindBy(xpath = "//div/a[@href='https://fubotv.zendesk.com/hc' and count(*)=2]")
    private WebElement visitHelpCentrButton;

    @Step
	public SignUpPage startSignUpFromChannelsPage(){
        startTrialButtonChannelsPage.click();

        return FuboTVPageFactory.initElements(webDriver, SignUpPage.class);
    }

    public ChannelsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public java.util.function.Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(startTrialButtonChannelsPage);
    }
}
