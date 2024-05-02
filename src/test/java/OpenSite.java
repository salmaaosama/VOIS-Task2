import Pages.ScrollHelper;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenSite {


    ChromeDriver driver = new ChromeDriver();

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        //Set Browser resolution
        driver.manage().window().setSize(new Dimension(1024, 768));
        //Open amazon site
        driver.navigate().to("https://ksrtc.in/oprs-web/guest/home.do?h=1");

    }

    @Test
    public void ValidData() throws InterruptedException {
        // Navigate to the page
        ScrollHelper.scrollDown(driver);

        // Wait for the slideshow element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstSlide = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul")));

        WebElement firstSlideLink = firstSlide.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a"));
        firstSlideLink.click();

        Thread.sleep(2000);

        // Click on date picker
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a")).click();
        Thread.sleep(2000);

        // Click on search for bus
        driver.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[3]/button")).click();
        Thread.sleep(2000);
        // Click on select seat
        driver.findElement(By.id("SrvcSelectBtnForward0")).click();
        //choose a seat & enter cutomer & passenger data
        driver.findElement(By.className("seatNumber")).click();
        driver.findElement(By.id("Forwardboarding-tab")).click();
        driver.findElement(By.id("Forwarddroping-tab")).click();
        driver.findElement(By.id("Forwardprofile-tab")).click();
        driver.findElement(By.name("mobileNo")).sendKeys("6789125987)");
        driver.findElement(By.name("email")).sendKeys("salma@gmail.com)");
        driver.findElement(By.name("passengerName")).sendKeys("amr");
        driver.findElement(By.name("genderCodeId")).sendKeys("MALE");
        driver.findElement(By.name("passengerAge")).sendKeys("20");
        driver.findElement(By.id("concessionIdsForward0")).sendKeys("GENERAL PUBLIC");
        driver.findElement(By.id("nationalityForward0")).sendKeys("INDIA");
        driver.findElement(By.id("RAZORPAY")).click();
        driver.findElement(By.name("termsChk")).click();
        driver.findElement(By.id("PgBtn")).click();

        driver.findElement(By.xpath("//*[@id=\"form-common\"]/div[1]/div[1]/div/div/div[2]/div/button[2]/div/div[1]/div[1]/div[1]")).click();
        driver.findElement(By.name("card[number]")).sendKeys("5555 5555 5555 5555");
        driver.findElement(By.name("card[expiry]")).sendKeys("10/25");
        driver.findElement(By.id("card_cvv")).sendKeys("555");
        driver.findElement(By.id("redesign-v15-cta")).click();
        // Close the browser
        // driver.quit();
    }
    @Test
    public void inValidData() throws InterruptedException {
        // Navigate to the page
        ScrollHelper.scrollDown(driver);
        // Wait for the slideshow element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstSlide = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul")));
        WebElement firstSlideLink = firstSlide.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/div[2]/div/div/ul/li[1]/a"));
        firstSlideLink.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("SrvcSelectBtnForward0")).click();
        //choose a seat & enter cutomer & passenger data
        driver.findElement(By.className("seatNumber")).click();
        driver.findElement(By.id("Forwardboarding-tab")).click();
        driver.findElement(By.id("Forwarddroping-tab")).click();
        driver.findElement(By.id("Forwardprofile-tab")).click();
        driver.findElement(By.name("mobileNo")).sendKeys("6789125987)");
        driver.findElement(By.name("email")).sendKeys("salma@gmail.com)");
        driver.findElement(By.name("passengerName")).sendKeys("amr");
        driver.findElement(By.name("genderCodeId")).sendKeys("MALE");
        driver.findElement(By.name("passengerAge")).sendKeys("20");
        driver.findElement(By.id("concessionIdsForward0")).sendKeys("GENERAL PUBLIC");
        driver.findElement(By.id("nationalityForward0")).sendKeys("INDIA");
        driver.findElement(By.id("RAZORPAY")).click();
        driver.findElement(By.name("termsChk")).click();
        driver.findElement(By.id("PgBtn")).click();
        driver.findElement(By.xpath("//*[@id=\"form-common\"]/div[1]/div[1]/div/div/div[2]/div/button[2]/div/div[1]/div[1]/div[1]")).click();
        // Enter incorrect payment details to simulate a payment failure
        driver.findElement(By.name("card[number]")).sendKeys("5555 5555 5555 5555");
        driver.findElement(By.name("card[expiry]")).sendKeys("10/25");
        driver.findElement(By.id("card_cvv")).sendKeys("555");
    }


//    private HomePage homePage;
//    ChromeDriver driver = new ChromeDriver();
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().setSize(new Dimension(1024, 768));
//        homePage = new HomePage(driver);
//    }
//
//    @Test(description = "Search for a bus without selecting a route")
//    public void searchForBusWithoutSelectingRoute() {
//        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
//        homePage.searchForBus();
//        assert homePage.isRouteSelectionErrorDisplayed();
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


}
