import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class paymentTestMethods
{
    WebDriver driver;

    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/ugurbaykoc/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://meditopia.app/int/FuoEFN3QDgLo06lrOhySuWubL5IbbO4f/");

    }

    public void verifyPageTitle() {
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Meditopia Premium";
        if (ActualTitle.equals(ExpectedTitle)) {
            System.out.println("Title test passed");
        } else {
            System.out.println("Title test failed" + ExpectedTitle);
        }

    }
    public boolean verifytermsAndConditionsButton()
    {
        boolean termsAndConditionsbtnPresent = driver.findElement(By.xpath("//a[@href='https://meditopia.com/en/privacy']")).isDisplayed();
        if (termsAndConditionsbtnPresent== true)
        {
            System.out.println("Terms and Conditions button is verified");
        }
        else
        {
            System.out.println("Terms and Conditions button is not there");

        }
        Assert.assertTrue(termsAndConditionsbtnPresent);
        return termsAndConditionsbtnPresent;

    }
    public boolean verifyPrivacyButton() throws InterruptedException {
        boolean PrivacybtnPresent = driver.findElement(By.xpath("//a[@href='https://meditopia.com/en/terms']")).isDisplayed();
        if (PrivacybtnPresent== true)
        {
            System.out.println("Privacy button is verified");
        }
        else
        {
            System.out.println("Privacy button is not there");
        }
        Thread.sleep(2000);

        return PrivacybtnPresent;
    }

    public void InputCardDetails() {
        WebElement cardHolderName = driver.findElement(By.id("cardHolderName"));
        WebElement cardNumber = driver.findElement(By.id("cardNumber"));
        WebElement cvv = driver.findElement(By.id("cardCVV"));
        WebElement startNowbtn = driver.findElement(By.xpath("//button[contains(@class,'btn btn-pay')]"));

        cardHolderName.sendKeys("TEST CARD");
        String cardNum = "4242 4444 4444 4443";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", cardNum, cardNumber);
        Select month = new Select(driver.findElement(By.id("cardExpirationMonth")));
        month.selectByIndex(3);
        Select year = new Select(driver.findElement(By.id("cardExpirationYear")));
        year.selectByIndex(6);
        cvv.sendKeys("433");
        startNowbtn.click();

    }
        public void compareUrl(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="https://meditopia.app/int/FuoEFN3QDgLo06lrOhySuWubL5IbbO4f/";
        Assert.assertEquals(expectedUrl,actualUrl );

    }
}
