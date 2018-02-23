package framework.pages.fubotv.mlp;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import framework.pages.fubotv.sports.SportsHome;
import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class SignInModalWindow extends Page {


    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailSignInField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordSignInField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInWithEmailButton;

    @FindBy(xpath = "//button[contains(.,'Sign In with Google')]")
    public WebElement signInWithGoogleButton;

    @FindBy(xpath = "//input[@aria-label='Email or phone']")
    private WebElement emailOrPhoneField;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButtonEmail;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement nextButtonPass;

    @FindBy(xpath = "//input[@aria-label='Enter your password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='signup']/p/a[@href='/signup']")
    private WebElement signUpButton;

    @FindBy(xpath = "//button[contains(.,'Forgot password')]")
    private WebElement forgotPassword;

    @FindBy(xpath = "//div[@class='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class='modal-body']/div/input")
    private WebElement emailforgotPasswordField;

    @FindBy(xpath = "//button[contains(.,'Reset Password')]")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//div[@class='modal-body']/span")
    private WebElement resetPasswordPopUp;

    @FindBy(xpath = "(//form/div[contains(@class, \"modal-body\")]/div/p)[2]")
    private WebElement errorMessageOnResetPasswordPopUp;

    public SignInModalWindow(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Submit sign in form")
    public SportsHome submitSignInForm(String email, String password) {
        LOG.info("Submitting Sign In form-1");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(emailSignInField));
        emailSignInField.sendKeys(email);
        passwordSignInField.sendKeys(password);
        signInWithEmailButton.click();
        return FuboTVPageFactory.initElements(webDriver, SportsHome.class);
    }

    @Step("Submit sign in form")
    public SignInModalWindow submitSignInForm2(String email, String password) {
        LOG.info("Submitting Sign In form-2");
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(signInWithGoogleButton));
        signInWithGoogleButton.click();
        passwordSignInField.sendKeys(password);
        signInWithEmailButton.click();
        return FuboTVPageFactory.initElements(webDriver, SignInModalWindow.class);
    }

    @Step("Checking if errorMessage is displayed")
    public boolean isErrorMessageDisplayed() {
        LOG.info("Checking error message is displayed");
        return errorMessage.isDisplayed();
    }

    @Step("Get Error Message Text")
    public String getErrorMessageText() {
        LOG.info("Return Error Message Text");
        return errorMessage.getText();
    }

    @Step("Checking Forgot Password window")
    public String resetPasswordPopUp(String email) {
        forgotPassword.click();
        LOG.info("Clicking on Forgot Password");
        emailforgotPasswordField.sendKeys(email);
        resetPasswordButton.click();
        LOG.info("Clicked on resetPasswordButton");
        return resetPasswordPopUp.getText();

    }

    @Step("Checking Forgot Password window")
    public String resetPasswordPopUpInvalidMail(String email) {
        forgotPassword.click();
        LOG.info("Clicking on Forgot Password");
        emailforgotPasswordField.sendKeys(email);
        resetPasswordButton.click();
        LOG.info("Reading error message");
        return errorMessageOnResetPasswordPopUp.getText();

    }

    @Step("Checking Sign In with Google")
    public SportsHome signInWithGoogle(String email, String password) throws InterruptedException {
        LOG.info("Clicking on sign In With Google Button");
        String winHandleBefore = webDriver.getWindowHandle();
        signInWithGoogleButton.click();
        performActionsOnNewWindow();
        emailOrPhoneField.sendKeys(email);
        nextButtonEmail.click();
        LOG.info("Next Button after email entered clicked");
        passwordField.sendKeys(password);
        LOG.info("Password was entered");
        getWebDriverWait(10);
        nextButtonPass.click();
        getWebDriverWait(10);
        webDriver.switchTo().window(winHandleBefore);
        getWebDriverWait(10);
        return FuboTVPageFactory.initElements(webDriver, SportsHome.class);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(signInWithEmailButton);
    }
}
