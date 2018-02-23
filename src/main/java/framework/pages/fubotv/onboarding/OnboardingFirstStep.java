package framework.pages.fubotv.onboarding;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import framework.pages.fubotv.sports.SportsHome;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class OnboardingFirstStep extends Page {

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement selectPackageButton;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='familyName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='givenName']")
    private WebElement firstNameField;

    @FindBy (xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInWithEmailButton;

    @Step("Proceed to step #2")
    public OnboardingSecondStep onboardingStep2(String password, String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        selectPackageButton.click();

        return FuboTVPageFactory.initElements(webDriver, OnboardingSecondStep.class);

    }

    @Step("Proceed to step #2")
    public OnboradingPreselectionPackagePage onboardingPreselection(String password, String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        selectPackageButton.click();

        return FuboTVPageFactory.initElements(webDriver, OnboradingPreselectionPackagePage.class);

    }

    @Step
    public SportsHome signUpAsExistingUser(){
        passwordField.sendKeys(standartPassword());
        signInWithEmailButton.click();

        return FuboTVPageFactory.initElements(webDriver, SportsHome.class);
    }

    public OnboardingFirstStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(selectPackageButton);
    }
}
