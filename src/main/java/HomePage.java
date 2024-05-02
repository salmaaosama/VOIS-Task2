import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchForBus() {
        driver.findElement(By.xpath("//button[contains(text(),'Search for bus')]")).click();
    }

    public boolean isRouteSelectionErrorDisplayed() {
        return driver.findElement(By.xpath("//div[contains(text(),'Please select a route.')]")).isDisplayed();
    }
}
