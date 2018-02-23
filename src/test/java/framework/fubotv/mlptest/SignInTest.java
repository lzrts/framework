package framework.fubotv.mlptest;

import framework.fubotv.testcase.TestSetup;
import framework.pages.fubotv.entertainment.EntertainmentHome;
import framework.pages.fubotv.entertainment.EntertainmentSeries;
import framework.pages.fubotv.mlp.MarketingLandingPage;
import framework.pages.fubotv.mlp.SignInModalWindow;
import framework.pages.fubotv.sports.SportsHome;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInTest extends TestSetup {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{"test777@dummy.com", "77777777"}};
    }

    @DataProvider(name = "invalidAuthentication")
    public static Object[][] badCredentials() {
        return new Object[][]{{"fserewrtrt@dummy.com", "223"}};
    }

    @Test(dataProvider = "Authentication")
    public void validCredentialsTest_C104(String sUsername, String sPassword) {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SportsHome sportsHome = marketingLandingPage.clickOnSignInButton().submitSignInForm(sUsername, sPassword);
    }

    @Test(dataProvider = "invalidAuthentication")
    public void incorrectEmailTest_C106(String sUsername, String sPassword) {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SignInModalWindow page = marketingLandingPage.clickOnSignInButton().submitSignInForm2(sUsername, sPassword);

        Assert.assertTrue(page.isErrorMessageDisplayed(), "Error message is invalid");
        Assert.assertEquals(page.getErrorMessageText(), "Incorrect Email");
    }

    @Test
    public void wrongCombinationEmailPasswordTest_C105() {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SignInModalWindow page = marketingLandingPage.clickOnSignInButton().submitSignInForm2("test@dummy.com", "223");

        Assert.assertTrue(page.isErrorMessageDisplayed(), "Error message is invalid");
        Assert.assertEquals(page.getErrorMessageText(), "That email and password combination is not valid. Please try again.");
    }

    @Test
    public void signInWithGoogleTest_C118() throws InterruptedException {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SportsHome sportsHome = marketingLandingPage.clickOnSignInButton().signInWithGoogle("testerfubo@gmail.com", "test12345678");

    }

    @Test
    public void forgotPasswordTest_C115() {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SignInModalWindow page = marketingLandingPage.clickOnSignInButton();
        Assert.assertEquals(page.resetPasswordPopUp("viktoriya.statska@fubo.tv"), "A password reset email has been sent");

    }

    @Test
    public void forgotPasswordTest_C116() {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SignInModalWindow page = marketingLandingPage.clickOnSignInButton();
        Assert.assertEquals(page.resetPasswordPopUpInvalidMail("dfsdfsfs"), "Please Enter a valid email");

    }

    @Test
    public void forgotPasswordTest_C117() {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SignInModalWindow page = marketingLandingPage.clickOnSignInButton();
        Assert.assertEquals(page.resetPasswordPopUpInvalidMail("test@test.test"), "We don't recognize your email. Please check and try again.");

    }
    /*@Test
    public void signUpOnSignInModalWindowTest_C119(){
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SignInModalWindow page = marketingLandingPage.clickOnSignInButton();
        page.signUpOnSignInModalWindow();

    }*/

}