package framework.pages.fubotv.footer;

import framework.pages.Page;
import framework.utility.LogFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;

import java.util.function.Function;

public class FooterLinksPage extends Page {

    private static final Logger LOG = LogFactory.getLogger(FooterLinksPage.class);

    @FindBy(xpath = "//a[@href='mailto:advertising@fubo.tv']")
    public WebElement advertiseLink;//mail is opened

    @FindBy(xpath = "//a[@href='https://boards.greenhouse.io/fubotv']/span[contains(., 'Careers')]")
    public WebElement careersLink;

    @FindBy(xpath = "//a[@href='https://www.fubo.tv/lp/affiliate/']/span[contains(., 'Become an Affiliate')]")
    public WebElement becomeAnAffiliateLink;

    @FindBy(xpath = "//a[@href='mailto:press@fubo.tv']")
    public WebElement pressInquiriesLink;//mail is opened

    @FindBy(xpath = "//a[@href='https://fubotv.zendesk.com/hc']//span[text()='Help Center']")
    public WebElement helpCenterLink;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/fuboTV']")
    public WebElement facebookLink;

    @FindBy(xpath = "//a[@href='https://twitter.com/fuboTV']")
    public WebElement twitterLink;

    @FindBy(xpath = "//a[@href='https://www.instagram.com/fubotv']")
    public WebElement instagramLink;

    @FindBy(xpath = "//a[@href='/documents/USA/terms-of-service']/span[contains(.,'Terms')]")
    public WebElement termsLink;

    @FindBy(xpath = "//a[@href='/documents/USA/privacy-policy']/span[contains(.,'Privacy')]")
    public WebElement privacyLink;

    @FindBy(xpath = "//a[@href='/documents/USA/cookie-policy']/span[contains(.,'Cookie Policy')]")
    public WebElement cookiePolicyLink;


    public FooterLinksPage(WebDriver webDriver) {
        super(webDriver);

    }

    @Step("Checking advertiseLink is displayed")
    public boolean isAdvertiseLinkDisplayed() {
        LOG.info("Checking advertiseLink is displayed");
        return advertiseLink.isDisplayed();
    }

    @Step("Checking careersLink is displayed")
    public boolean isCareersLinkDisplayed() {
        LOG.info("Checking careersLink is displayed");
        return careersLink.isDisplayed();
    }

    @Step("Checking becomeAnAffiliateLink is displayed")
    public boolean isBecomeAnAffiliateLinkDispalyed() {
        LOG.info("Checking becomeAnAffiliateLink is displayed");
        return becomeAnAffiliateLink.isDisplayed();
    }

    @Step("Checking pressInquiriesLink is displayed")
    public boolean isPressInquiriesLinkDisplayed() {
        LOG.info("Checking pressInquiriesLink is displayed");
        return pressInquiriesLink.isDisplayed();
    }

    @Step("Checking helpCenterLink is displayed")
    public boolean isHelpCenterLinkDisplayed() {
        LOG.info("Checking helpCenterLink is displayed");
        return helpCenterLink.isDisplayed();
    }

    @Step("Checking facebookLink is displayed")
    public boolean isFacebookLinkDisplayed() {
        LOG.info("Checking facebookLink is displayed");
        return facebookLink.isDisplayed();
    }

    @Step("Checking twitterLink is displayed")
    public boolean isTwitterLinkDisplayed() {
        LOG.info("Checking twitterLink is displayed");
        return twitterLink.isDisplayed();
    }

    @Step("Checking instagramLink is displayed")
    public boolean isInstagramLinkDisplayed() {
        LOG.info("Checking instagramLink is displayed");
        return instagramLink.isDisplayed();
    }

    @Step("Checking termsLink is displayed")
    public boolean isTermsLinkDisplayed() {
        LOG.info("Checking termsLink is displayed");
        return termsLink.isDisplayed();
    }

    @Step("Checking privacyLink is displayed")
    public boolean isPrivacyLinkDisplayed() {
        LOG.info("Checking privacyLink is displayed");
        return privacyLink.isDisplayed();
    }

    @Step("Checking cookiePolicyLink is displayed")
    public boolean isCookiePolicyLinkDisplayed() {
        LOG.info("Checking cookiePolicyLink is displayed");
        return cookiePolicyLink.isDisplayed();
    }

    @Step("Checking advertiseLink is correct")
    public String getAdvertiseLink() {
        LOG.info("Checking advertiseLink is correct");
        return advertiseLink.getAttribute("href");
    }

    @Step("Checking pressInquiriesLink is correct")
    public String getPressInquiriesLink() {
        LOG.info("Checking pressInquiriesLink is correct");
        return pressInquiriesLink.getAttribute("href");
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(helpCenterLink);
    }
}
