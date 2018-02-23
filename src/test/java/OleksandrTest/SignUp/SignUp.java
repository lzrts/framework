package OleksandrTest.SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static OleksandrTest.Spoof.spoof;


public class SignUp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/ProgramData/SeleniumStuff/chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        By startSignUpButton = By.xpath("//div/a[@href=\"/signup\"]");
        By signUpEmailInput = By.xpath("//input[1]");
        By signUpButton = By.xpath("(//button)[4]");
        By signUpFirstNameInput = By.xpath("(//input)[1]");
        By signUpLastNameInput = By.xpath("(//input)[2]");
        By signUpPasswordInput = By.xpath("(//input)[3]");
        By selectPackageButton = By.xpath("(//button)[2]");
        By continueToLastStepButton = By.xpath("(//button)[14]");
        By cardHolderFirstNameInput = By.xpath("(//input)[1]");
        By cardHolderLastNameInput = By.xpath("(//input)[2]");
        By cardZip = By.xpath("(//input)[3]");
        By startWatchingButton = By.xpath("(//button)[2]");
        By menuButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span[2]");
        By myAccountButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div/a[1]/span");
        By userEmailField = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div[2]/span");

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qa.fubo.tv/sandbox/geolocation");

        spoof(driver, "USA", "94124");

        String testEmail = "autosignuptest" + System.currentTimeMillis() + "@dummy.com";

        String password = "test1234";
        String firstName = "John";
        String lastName = "Wick";
        String cardNumber = "5555 5555 5555 4444";
        String cardCVV = "019";
        String expMonth = "9";
        String expYear = "19";
        String billingZipCode = "94124";


        driver.findElement(startSignUpButton).click();

        driver.findElement(signUpEmailInput).sendKeys(testEmail);

        driver.findElement(signUpButton).click();

        Thread.sleep(3000);

        driver.findElement(signUpFirstNameInput).sendKeys(firstName);

        driver.findElement(signUpLastNameInput).sendKeys(lastName);

        driver.findElement(signUpPasswordInput).sendKeys(password);

        driver.findElement(selectPackageButton).click();

        driver.findElement(continueToLastStepButton).click();

        driver.findElement(cardHolderFirstNameInput).sendKeys(firstName);

        driver.findElement(cardHolderLastNameInput).sendKeys(lastName);

        driver.switchTo().frame(0);

        WebElement cardNumberInput = driver.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        cardNumberInput.sendKeys(cardNumber);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);

        WebElement cvv = driver.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        cvv.sendKeys(cardCVV);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(2);

        WebElement expMonthInput = driver.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        expMonthInput.sendKeys(expMonth);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(3);


        WebElement expYearInput = driver.findElement(By.xpath("//*[@id=\"recurly-hosted-field-input\"]"));
        expYearInput.sendKeys(expYear);

        driver.switchTo().defaultContent();

        driver.findElement(cardZip).sendKeys(billingZipCode);

        driver.findElement(startWatchingButton).click();

        driver.findElement(menuButton).click();

        driver.findElement(myAccountButton).click();

        String useremail = driver.findElement(userEmailField).getText();

        System.out.println("User email is: " + useremail);

        if (testEmail.equals(useremail)) {
            System.out.println("Emails are equals");
        } else {
            System.out.println("Emails are different");
            }
        driver.close();
    }

}

