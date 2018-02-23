package OleksandrTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Spoof {
    public static void spoof(WebDriver driver, String countryCode, String postalCode) {

        By spoofCountryInput = By.xpath("(//input)[1]");
        By spoofPostalCodeInput = By.xpath("(//input)[2]");
        By spoofButton = By.xpath("(//button)[@type=\"submit\"]");
        By channelsButton = By.xpath("(//a[@href=\"/welcome/channels\"]/span[.=\"Channels\"])[2]");

        driver.findElement(spoofCountryInput).sendKeys(countryCode);

        driver.findElement(spoofPostalCodeInput).sendKeys(postalCode);

        driver.findElement(spoofButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.visibilityOfElementLocated(channelsButton));


    }
}