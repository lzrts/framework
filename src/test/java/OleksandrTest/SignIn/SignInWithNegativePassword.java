package OleksandrTest.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static OleksandrTest.Spoof.spoof;

public class SignInWithNegativePassword {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        By startSignInButton = By.xpath("(//button)[2]");
        By signInEmailInput = By.xpath("(//input)[1]");
        By signInEmailPasswordInput = By.xpath("(//input)[2]");
        By signInButton = By.xpath("//div/span[.=\"Sign In with Email\"]");
        String useremail="test@dummy.com";
        String incorrectpassword="88888888";
        String correcterror = "That email and password combination is not valid. Please try again.";

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(driver, "USA", "94124");

        driver.findElement(startSignInButton).click();

        driver.findElement(signInEmailInput).sendKeys(useremail);

        driver.findElement(signInEmailPasswordInput).sendKeys(incorrectpassword);

        driver.findElement(signInButton).click();

        String errormessage = driver.findElement(By.xpath("//div[@class=\"error\"]")).getText();

        if (errormessage.equals(correcterror)) {
            System.out.println("The error message is correct.");
        } else {
            System.out.println("The error message is INCORRECT.");
        }
        driver.close();



    }
}
