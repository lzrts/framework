package framework.fubotv.mlptest;

import framework.fubotv.testcase.TestSetup;
import framework.pages.fubotv.mlp.MarketingLandingPage;
import framework.pages.fubotv.mlp.SignUpPage;
import framework.pages.fubotv.onboarding.*;
import framework.pages.fubotv.sports.SportsHome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends TestSetup {

    @Test
    public void SignUpFormAppsPage() throws InterruptedException {
        SportsHomePage sportsHome = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openAppsPage().startSignUpFormAppsPage()
                .signUpStart()
                .onboardingStep2("test1234", "Auto", "Test")
                .onboardingStep3().onboardingStep4()
                .finishOfTheRegistration("Auto", "Test", "4111111111111111",
                        "123", "02", "2020", "12345");


        Assert.assertEquals(sportsHome.getPageUrl(), "https://qa.fubo.tv/");
    }

    @Test
    public void SignUpFormChannelsPage() throws InterruptedException {
        SportsHomePage sportsHome = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openChannelsPage().startSignUpFromChannelsPage()
                .signUpStart()
                .onboardingStep2("test1234", "Auto", "Test")
                .onboardingStep3().onboardingStep4()
                .finishOfTheRegistration("Auto", "Test", "4111111111111111",
                        "123", "02", "2020", "12345");


        Assert.assertEquals(sportsHome.getPageUrl(), "https://qa.fubo.tv/");
    }

    @Test
    public void BasicSignUpTest() throws InterruptedException {
        SportsHomePage sportsHome = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openSignUpPage().signUpStart()
                .onboardingPreselection("test1234", "Auto", "Test").onboardingStep4()
                .finishOfTheRegistration("Auto", "Test", "4111111111111111",
                        "112", "03", "2020", "12345");

        Assert.assertEquals(sportsHome.getPageUrl(), "https://qa.fubo.tv/");

    }

    @Test
    public void ReturnToMLPTest() {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openSignUpPage().returnToWelcomePage();

        Assert.assertEquals(marketingLandingPage.getPageUrl(), "https://qa.fubo.tv/welcome");
    }

    @Test
    public void IsErrorDisplayed() {
        SignUpPage signUpPage = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openSignUpPage().displayErrorMessage();

        Assert.assertTrue(signUpPage.isErrorMessageDisplayed());

    }


    @Test
    public void SignUpElementsTest() {
        SignUpPage signUpPage = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openSignUpPage();

        Assert.assertEquals(signUpPage.checkElementsSignUpPage(), true);
    }

    @Test
    public void SignUpWithExistingEmail(){
        SportsHome sportsHome = spoofingModal.setSpoofing("USA", "10044", "", "")
                .openSignUpPage().signUpWithExistingEmail().signUpAsExistingUser();

        Assert.assertEquals(sportsHome.getPageUrl(), "https://qa.fubo.tv/");
    }



}
