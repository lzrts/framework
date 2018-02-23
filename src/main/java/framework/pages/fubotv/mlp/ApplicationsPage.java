package framework.pages.fubotv.mlp;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class ApplicationsPage extends Page {

    @FindBy(xpath = "//span[contains(text(),'Let’s Get Started')]")
    public WebElement startTrialFooterButtonAppsPage;

    @FindBy(xpath = "//div/a[@href='https://fubotv.zendesk.com/hc' and count(*)=2]")
    public WebElement visitHelpCenterButton;

    @FindBy(xpath = "//a[@id='app-store']")
    public WebElement appStoreButton;

    @FindBy(xpath = "//a[@id='google-play']")
    public WebElement googlePlayButton;

    @FindBy(xpath = "//a[@href='https://www.amazon.com/gp/product/" +
            "B075XMZMWY/ref=as_li_tl?ie=UTF8&camp=1789&" +
            "creative=9325&creativeASIN=B075XMZMWY&linkCode=as2&tag=fubotv0f-20&linkId=104036e65dd067b0bc0e9a7bc5a4ef54']")
    public WebElement getRokuButton;

    @FindBy(xpath = "//a[@href='https://www.amazon.com/gp/product/"
            + "B00ZV9RDKK/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&"
            + "creativeASIN=B00ZV9RDKK&linkCode=as2&tag=fubotv-20&linkId=fb663c6a7c87257f31d4c05b37b8fa09']")
    public WebElement getFireTvButton;

    @FindBy(xpath = "//a[@href='https://www.amazon.com/gp/product/" +
            "B075NCMLYL/ref=as_li_tl?ie=UTF8&camp=1789&creative=9325&" +
            "creativeASIN=B075NCMLYL&linkCode=as2&tag=fubotv0f-20&linkId=f823001254eb0a36f09809bc7cd5c7ea']")
    public WebElement getAppleTvButton;

    public ApplicationsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Proceed to Apps page")
    public boolean checkElementsAppsPage() {
        isElementPresent(appStoreButton);
        isElementPresent(getAppleTvButton);
        isElementPresent(getFireTvButton);
        isElementPresent(getRokuButton);
        isElementPresent(googlePlayButton);
        isElementPresent(startTrialFooterButtonAppsPage);
        isElementPresent(visitHelpCenterButton);
        return true;
    }

    @Step
    public SignUpPage startSignUpFormAppsPage(){
        startTrialFooterButtonAppsPage.click();

        return FuboTVPageFactory.initElements(webDriver, SignUpPage.class);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(startTrialFooterButtonAppsPage);
    }
}
