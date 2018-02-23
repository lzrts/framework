package framework.pages.fubotv.mlp;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import framework.pages.fubotv.onboarding.OnboardingFirstStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class SignUpPage extends Page {

    @FindBy(xpath = "//*[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signUpButton;

    @FindBy(xpath = "//a[@href='/welcome']")
    private WebElement logoButton;

    @FindBy(xpath = "//div[@class='head-container']")
    private WebElement textContainer;

    @FindBy(xpath = "//span[@class='error']")
    private WebElement signUpErrorMessage;

    @FindBy(xpath = "//p[@class='signin']/a")
    private WebElement signInButton;

    @Step("Send email")
    public OnboardingFirstStep signUpStart() {

        emailField.sendKeys(emailGeneration());
        signUpButton.click();

        return FuboTVPageFactory.initElements(webDriver, OnboardingFirstStep.class);
    }

    @Step("Return to welcome page")
    public MarketingLandingPage returnToWelcomePage() {

        logoButton.click();

        return FuboTVPageFactory.initElements(webDriver, MarketingLandingPage.class);
    }

    @Step("Check if error message is displayed")
    public SignUpPage displayErrorMessage() {
        emailField.click();
        textContainer.click();

        return FuboTVPageFactory.initElements(webDriver, SignUpPage.class);
    }

    @Step("Is error displayed")
    public boolean isErrorMessageDisplayed() {
        signUpErrorMessage.isDisplayed();

        return true;
    }

    @Step("Check of the elements")
    public boolean checkElementsSignUpPage() {
        isElementPresent(logoButton);
        isElementPresent(emailField);
        isElementPresent(signUpButton);
        isElementPresent(signInButton);

        return true;
    }

    @Step
    public OnboardingFirstStep signUpWithExistingEmail(){
        emailField.sendKeys(standartEmail());
        signUpButton.click();

        return FuboTVPageFactory.initElements(webDriver, OnboardingFirstStep.class);
    }

    public SignUpPage(WebDriver webDriver) {
        super(webDriver);

    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(signUpButton);
    }
}
