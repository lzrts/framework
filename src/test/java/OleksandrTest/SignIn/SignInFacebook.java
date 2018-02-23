package OleksandrTest.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static OleksandrTest.Spoof.spoof;

public class SignInFacebook {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        By startSignInButton = By.xpath("(//button)[2]");
        By signInWithFacebook = By.cssSelector("body > div.ReactModalPortal > div > div > div > div.modal-content.modal-small > div.modal-body > div > div > div:nth-child(1) > button:nth-child(1)");
        By facebookEmailInput = By.id("email");
        By facebookPasswordInput = By.id("pass");
        By facebookSignInButton = By.id("loginbutton");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[1]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");
        By userEmail = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span");


        String testEmail = "alex.qa.org@gmail.com";
        String password = "test123456789";

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(driver, "USA", "94124");

        driver.findElement(startSignInButton).click();

        driver.findElement(signInWithFacebook).click();

        String winHandleBefore = driver.getWindowHandle();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if (driver.getTitle().contains("Log into Facebook")) {
                WebDriverWait wait = new WebDriverWait(driver, 60);
                wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete' ? 'complete' : null"));
                driver.findElement(facebookEmailInput).sendKeys(testEmail);
                driver.findElement(facebookPasswordInput).sendKeys(password);
                driver.findElement(facebookSignInButton).click();

            }
        }

        driver.switchTo().window(winHandleBefore);

        driver.findElement(menuButton).click();

        driver.findElement(myAccountButton).click();

        String useremail = driver.findElement(userEmail).getText();

        System.out.println("User email is: " + useremail);

        if (testEmail.equals(useremail)) {
            System.out.println("Emails are equals");
        } else {
            System.out.println("Emails are different");


        }
        driver.close();

    }
}
