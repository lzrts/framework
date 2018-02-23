package framework.pages.fubotv.spoofing;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import framework.pages.fubotv.footer.FooterLinksPage;
import framework.pages.fubotv.mlp.MarketingLandingPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SpoofingModal extends Page {

    @FindBy(xpath = "//button[@type='button']/*[contains(text(),'Spoofing')]")
    private WebElement spoofingButton;

    @FindBy(xpath = "//*[contains(@class,'modal-body')]/*[1]/input")
    private WebElement countryCodeField;

    @FindBy(xpath = "//*[contains(@class,'modal-body')]/*[2]/input")
    private WebElement currentPostalCodeField;

    @FindBy(xpath = "//*[contains(@class,'modal-body')]/*[3]/input")
    private WebElement homePostalCodeField;

    @FindBy(xpath = "//*[contains(@class,'modal-body')]/*[4]/input")
    private WebElement dmaField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitSpoofingButton;

    public SpoofingModal(WebDriver webDriver) {
        super(webDriver);

    }

    @Step("Proceed to Home Page")
    public MarketingLandingPage setSpoofing(String countryCode, String postalCode, String homePostalCode, String dma) {
        spoofingButton.click();
        countryCodeField.sendKeys(countryCode);
        currentPostalCodeField.sendKeys(postalCode);
        submitSpoofingButton.click();

        return FuboTVPageFactory.initElements(webDriver, MarketingLandingPage.class);


    }

    @Step("Proceed to Home Page")
    public FooterLinksPage setFooterSpoofing(String countryCode, String postalCode, String homePostalCode, String dma) {
        spoofingButton.click();
        countryCodeField.sendKeys(countryCode);
        currentPostalCodeField.sendKeys(postalCode);
        submitSpoofingButton.click();

        return FuboTVPageFactory.initElements(webDriver, FooterLinksPage.class);

    }

    @Override
    public java.util.function.Function<WebDriver, ?> isPageLoaded() {

        return ExpectedConditions.visibilityOf(spoofingButton);
    }

}
