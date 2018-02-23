package framework.fubotv.mlptest;

import framework.fubotv.testcase.TestSetup;
import framework.pages.fubotv.footer.FooterLinksPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class FooterTest extends TestSetup {
  @Test
  public void checkingFooterLinksPageTest() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(footerLinksPage.isAdvertiseLinkDisplayed(), "AdvertiseLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isBecomeAnAffiliateLinkDispalyed(), "BecomeAnAffiliateLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isCareersLinkDisplayed(), "CareersLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isPressInquiriesLinkDisplayed(), "PressInquiriesLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isHelpCenterLinkDisplayed(), "HelpCenterLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isFacebookLinkDisplayed(), "FacebookLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isTwitterLinkDisplayed(), "TwitterLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isInstagramLinkDisplayed(), "InstagramLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isTermsLinkDisplayed(), "TermsLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isPrivacyLinkDisplayed(), "PrivacyLink is not displayed");
    softAssert.assertTrue(footerLinksPage.isCookiePolicyLinkDisplayed(), "CookiePolicyLink is not displayed");
  }

  @Test
  public void getAdvertiseLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    assertEquals(footerLinksPage.getAdvertiseLink(), "mailto:advertising@fubo.tv");
  }

  @Test
  public void getPressInquiriesLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    assertEquals(footerLinksPage.getPressInquiriesLink(), "mailto:press@fubo.tv");
  }

  @Test
  public void getCareersLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.careersLink.click();
    footerLinksPage.switchToTab();
    Assert.assertEquals(webDriver.getTitle().contains("Jobs"), true);
  }

  @Test
  public void getBecomeAnAffiliateLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.becomeAnAffiliateLink.click();
    footerLinksPage.switchToTab();
    Assert.assertEquals(webDriver.getTitle().contains("Affiliate"), true);
  }

  @Test
  public void getHelpCenterLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.helpCenterLink.click();
    footerLinksPage.switchToTab();
    Assert.assertEquals(webDriver.getTitle().contains("Help Center"), true);
  }

  @Test
  public void getFacebookLinkLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.facebookLink.click();
    footerLinksPage.switchToTab();
    Assert.assertEquals(webDriver.getTitle().contains("Facebook"), true);
  }

  @Test
  public void getTwitterLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.twitterLink.click();
    footerLinksPage.switchToTab();
    Assert.assertEquals(webDriver.getTitle().contains("Twitter"), true);
  }

  @Test
  public void getInstagramLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.instagramLink.click();
    footerLinksPage.switchToTab();
    Assert.assertEquals(webDriver.getTitle().contains("Instagram"), true);
  }

  @Test
  public void getTermsLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.termsLink.click();
    footerLinksPage.switchToTab();
    getWebDriverWait(5).until(ExpectedConditions.titleContains("fuboTV - Watch & DVR Live Sports & TV Online"));
  }

  @Test
  public void getPrivacyLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.privacyLink.click();
    footerLinksPage.switchToTab();
    getWebDriverWait(5).until(ExpectedConditions.titleContains("fuboTV - Watch & DVR Live Sports & TV Online"));
  }

  @Test
  public void getCookiePolicyLink() {
    FooterLinksPage footerLinksPage = spoofingModal.setFooterSpoofing("USA", "10044", "", "");
    footerLinksPage.cookiePolicyLink.click();
    footerLinksPage.switchToTab();
    getWebDriverWait(10).until(ExpectedConditions.titleContains("fuboTV - Watch & DVR Live Sports & TV Online"));
  }
}
