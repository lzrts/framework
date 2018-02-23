package framework.fubotv.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.pages.FuboTVPageFactory;
import framework.pages.fubotv.spoofing.SpoofingModal;
import framework.utility.LogFactory;
import framework.utility.PropertyLoader;
import framework.webdriver.WebDriverFactory;

public class TestSetup {

  private static final Logger LOG = LogFactory.getLogger(TestSetup.class);

  protected WebDriver webDriver;
  protected SpoofingModal spoofingModal;

  @BeforeMethod
  public void beforeTest() {
    String browserName = System.getProperty("browser");
    webDriver = WebDriverFactory.getInstance(browserName);

    LOG.info("Navigating to test url");
    webDriver.get(PropertyLoader.loadProperty("fubo.url"));

    spoofingModal = FuboTVPageFactory.initElements(webDriver, SpoofingModal.class);
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
    if (webDriver != null) {
      LOG.info("Killing web driver");
      WebDriverFactory.killDriverInstance();
    }
  }

  protected WebDriverWait getWebDriverWait(int seconds) {
    return new WebDriverWait(webDriver, seconds);
  }

}