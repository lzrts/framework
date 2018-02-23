package framework.pages.fubotv.onboarding;

import framework.pages.FuboTVPageFactory;
import framework.pages.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

public class OnboardingSecondStep extends Page {

    @FindBy(xpath = "//div/span[contains(text(),'Go to Next Step')]")
    private WebElement goToNextStepButton;

    @Step("Proceed to step #3")
    public OnboardingThirdStep onboardingStep3() {

        goToNextStepButton.click();

        return FuboTVPageFactory.initElements(webDriver, OnboardingThirdStep.class);

    }

    public OnboardingSecondStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public Function<WebDriver, ?> isPageLoaded() {
        return ExpectedConditions.visibilityOf(goToNextStepButton);
    }
}
