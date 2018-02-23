package framework.fubotv.smokeTests;

import framework.fubotv.testcase.TestSetup;
import framework.pages.fubotv.entertainment.EntertainmentHome;
import framework.pages.fubotv.entertainment.EntertainmentSeries;
import framework.pages.fubotv.mlp.MarketingLandingPage;
import framework.pages.fubotv.sports.SportsHome;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tabsTest extends TestSetup {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{"test777@dummy.com", "77777777"}};
    }

    @DataProvider(name = "invalidAuthentication")
    public static Object[][] badCredentials() {
        return new Object[][]{{"fserewrtrt@dummy.com", "223"}};
    }

    @Test(dataProvider = "Authentication")
    public void SearchFieldTest(String sUsername, String sPassword){
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SportsHome sportsHome = marketingLandingPage.clickOnSignInButton().submitSignInForm(sUsername, sPassword);
        EntertainmentHome entertainmentHome = sportsHome.clickOnEntertainmentTab();
        Assert.assertTrue(entertainmentHome.isLiveSeriesDisplayed(), "Live Series section is not displayed");

        EntertainmentSeries entertainmentSeries = entertainmentHome.clickOnSeriesTab();
        Assert.assertEquals(entertainmentSeries.findSerielInSearchInputField(), true);

    }

    @Test(dataProvider = "Authentication")
    public void tabsTest(String sUsername, String sPassword) {
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SportsHome sportsHome = marketingLandingPage.clickOnSignInButton().submitSignInForm(sUsername, sPassword);
        Assert.assertTrue(sportsHome.isSportsButtonDisplayed(), "Sports tab is not displayed");

        EntertainmentHome entertainmentHome = sportsHome.clickOnEntertainmentTab();
        Assert.assertTrue(entertainmentHome.isLiveSeriesDisplayed(), "Live Series section is not displayed");
        entertainmentHome.clickOnSeriesTab();
        entertainmentHome.clickOnPlayLiveVideo();
    }

    /*@Test(dataProvider = "Authentication")
    public void signOutButtonTest(String sUsername, String sPassword){
        MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
        SportsHome sportsHome = marketingLandingPage.clickOnSignInButton().submitSignInForm(sUsername, sPassword);
        UserDropdownList userDropdownList = FuboTVPageFactory.initElements(webDriver, UserDropdownList.class);
        userDropdownList.checkSignOutButton();
        MarketingLandingPage marketingLandingPage2 = spoofingModal.setSpoofing("USA", "10044", "", "");
    }*/
}