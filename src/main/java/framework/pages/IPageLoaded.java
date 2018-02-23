package framework.pages;

import org.openqa.selenium.WebDriver;

public interface IPageLoaded {
	
	java.util.function.Function<WebDriver, ?> isPageLoaded();

}
