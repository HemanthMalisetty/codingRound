package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverHelper extends DriverBase {
    WebDriver driver;
    public DriverHelper(WebDriver driver){
        this.driver = driver;
    }
    public static void explicitWaitForVisibilityOfElement(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public static void explicitWaitForElementToBeClickable(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
