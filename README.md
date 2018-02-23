# Automated Testing in Java with TestNG and Selenium-Webdriver

This is a Java project that can be used as a template (or archetype) to start a WebDriver web browser testing project. I chose to simplify and and implement using simply WebDriver and Maven.


# Example Test

```sh
@Test
public void fuboSignInTest() {
	HomeSportPage page = welcomePage.clickOnSignInButton().submitSignInForm("test777@dummy.com", "77777777");
	Assert.assertTrue(page.isSportsButtonDisplayed(), "Sports button is not displayed");
	Assert.assertTrue(page.isFootballButtonDisplayed(), "Football button is not displayed");

	EntertainmentPage page2 = homeSportPage.clickOnEntertainmentButton();
	Assert.assertTrue(page2.isLiveSeriesDisplayed(), "Live Series section is not displayed");
	page2.clickOnPlayLiveVideo();

}
```

# Quick Start

  - Clone repository
  - Run CLI command: mvn clean test -Dsuite.name=test-fubo.xml -D browser=chrome

# Browsers' support

To Run in diff browser use next options:
- Chrome: mvn clean test -Dsuite.name=test-fubo.xml -D browser=chrome
- Firefox: mvn clean test -Dsuite.name=test-fubo.xml -D browser=firefox
- ...: mvn clean test -Dsuite.name=test-fubo.xml -D browser=...
