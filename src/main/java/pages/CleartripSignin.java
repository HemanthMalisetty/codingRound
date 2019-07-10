package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverBase;
import utility.DriverHelper;

public class CleartripSignin extends DriverBase {

    WebDriver driver;

    @FindBy(xpath = "//a[@id='userAccountLink']")
    private WebElement yourTrips;

    @FindBy(xpath = "//li[@class='signInBlock']//input[@type='submit']")
    private WebElement signinInDropdown;

    @FindBy(xpath = "//button[@id='signInButton']")
    private WebElement signinInPopup;

    @FindBy(xpath = "//div[@id='errors1']")
    private WebElement errorMessages;

    public CleartripSignin(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickOnYourTrips(){
        yourTrips.click();
    }

    public void clickOnsigninInDropdown(){
        signinInDropdown.click();
    }

    public void clickOnSigninInPopup(){
        DriverHelper.switchToFrame(driver, 1);
        signinInPopup.click();
    }

    public String getErrorMessages(){
        return errorMessages.getText();
    }
}