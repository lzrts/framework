package framework.pages.fubotv.onboarding;

import framework.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SportsHomePage extends Page {

	@FindBy(xpath="//*[@id='root']")
	public WebElement page;
	
	@FindBy(xpath="//div[@class='wristbands-wrapper']")
	public WebElement wristBand;
	
	
	public SportsHomePage(WebDriver webDriver) {
		super(webDriver);
		
	}

	@Override
	public java.util.function.Function<WebDriver, ?> isPageLoaded() {
		
		return ExpectedConditions.visibilityOf(wristBand);
	}

}
