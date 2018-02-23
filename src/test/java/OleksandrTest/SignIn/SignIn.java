package OleksandrTest.SignIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static OleksandrTest.Spoof.spoof;

public class SignIn {
    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        By signIn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div[5]/div/button/div/span");
        By signInEmailInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[1]/input");
        By signInPasswordInput = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/div[2]/div/input");
        By signInButton = By.xpath("/html/body/div[2]/div/div/div/div[1]/div[2]/div/div/form/div/button/div/span");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");

        String testEmail = "test@dummy.com";
        String password = "test1234";
        String[] myArray = {testEmail};
        String[] myArray2 = {password};

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(driver, "USA", "94124");

        driver.findElement(signIn).click();

        driver.findElement(signInEmailInput).sendKeys(myArray);

        driver.findElement(signInPasswordInput).sendKeys(myArray2);

        driver.findElement(signInButton).click();

        driver.findElement(menuButton).click();

        driver.findElement(myAccountButton).click();

        String useremail = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span")).getText();

        System.out.println("User email is: " + useremail);

        if (testEmail.equals(useremail)) {
            System.out.println("Emails are equals");
            } else {
            System.out.println("Emails are different");

        }
        driver.close();

    }
}