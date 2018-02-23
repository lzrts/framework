package framework.pages.fubotv.onboarding;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class OnboardingLastStep extends Page {

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameCardField;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameCardField;

    @FindBy(xpath = "//iframe[@tabindex='3']")
    private WebElement cardNumberField;

    @FindBy(xpath = "//iframe[@tabindex='4']")
    private WebElement securityCodeField;

    @FindBy(xpath = "//iframe[@tabindex='5']")
    private WebElement monthExpirationField;

    @FindBy(xpath = "//iframe[@tabindex='6']")
    private WebElement yearExpirationField;

    @FindBy(xpath = "//input[@name='postal_code']")
    private WebElement billingZipCodeField;

    @FindBy(xpath = "//div/span[contains(text(),'Start Watching fuboTV')]")
    private WebElement startWatchingFuboTvButton;

    @FindBy(xpath = "//*[@id='recurly-hosted-field-input']")
    private WebElement iFrameCardNumber;

    @FindBy(xpath = "//*[@id='recurly-hosted-field-input']")
    private WebElement iFrameSecurityCode;

    @FindBy(xpath = "//*[@id='recurly-hosted-field-input']")
    private WebElement iFrameMonthExpiration;

    @FindBy(xpath = "//*[@id='recurly-hosted-field-input']")
    private WebElement iFrameYearExpiraton;

    @Step("Finish of the Registration")
    public SportsHomePage finishOfTheRegistration(String firstName, String lastName, String cardNumber, String cvv,
                                                  String monthExpiration, String yearExpiration, String zip) throws InterruptedException {

        firstNameCardField.sendKeys(firstName);
        lastNameCardField.sendKeys(lastName);
        switchToIFrame(cardNumberField);
        iFrameCardNumber.sendKeys(cardNumber);
        switchToDefault();
        switchToIFrame(securityCodeField);
        iFrameSecurityCode.sendKeys(cvv);
        switchToDefault();
        switchToIFrame(monthExpirationField);
        iFrameMonthExpiration.sendKeys(monthExpiration);
        switchToDefault();
        switchToIFrame(yearExpirationField);
        iFrameYearExpiraton.sendKeys(yearExpiration);
        switchToDefault();
        billingZipCodeField.sendKeys(zip);
        startWatchingFuboTvButton.click();

        return FuboTVPageFactory.initElements(webDriver, SportsHomePage.class);
    }

    public OnboardingLastStep(WebDriver webDriver) {
        super(webDriver);
    }


    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(lastNameCardField);
    }
}
