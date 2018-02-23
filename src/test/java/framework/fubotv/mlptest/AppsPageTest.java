package framework.fubotv.mlptest;

import framework.fubotv.testcase.TestSetup;
import framework.pages.fubotv.mlp.ApplicationsPage;
import framework.pages.fubotv.mlp.MarketingLandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppsPageTest extends TestSetup {

	@Test
	public void appsPageElements_C40() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		Assert.assertEquals(applicationsPage.checkElementsAppsPage(), true);
	}

	@Test
	public void signInLinkTest_C51() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.startTrialFooterButtonAppsPage.click();
		Assert.assertEquals(webDriver.getCurrentUrl(), "https://qa.fubo.tv/signup");
	}

	@Test
	public void rokuDeviceLinkTest_C45() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.getRokuButton.click();
		applicationsPage.switchToTab();
		Assert.assertEquals(webDriver.getTitle().contains("Roku"), true);
	}

	@Test
	public void appleTvDeviceLinkTest_C46() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.getAppleTvButton.click();
		applicationsPage.switchToTab();
		Assert.assertEquals(webDriver.getTitle().contains("Apple"), true);
	}

	@Test
	public void fireTvDeviceLinkTest_C47() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.getFireTvButton.click();
		applicationsPage.switchToTab();
		Assert.assertEquals(webDriver.getTitle().contains("Fire TV"), true);
	}

	@Test
	public void appStoreLinkTest_C48() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.appStoreButton.click();
		applicationsPage.switchToTab();
		Assert.assertEquals(webDriver.getTitle().contains("fuboTV:"), true);
	}

	@Test
	public void googlePlayLinkTest_C49() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.googlePlayButton.click();
		applicationsPage.switchToTab();
		Assert.assertEquals(webDriver.getTitle().contains("fuboTV"), true);
	}

	@Test
	public void helpButtonLinkTest_C50() {
		MarketingLandingPage marketingLandingPage = spoofingModal.setSpoofing("USA", "10044", "", "");
		ApplicationsPage applicationsPage = marketingLandingPage.openAppsPage();
		applicationsPage.visitHelpCenterButton.click();
		applicationsPage.switchToTab();
		Assert.assertEquals(webDriver.getTitle().contains("Help Center"), true);
	}

}
