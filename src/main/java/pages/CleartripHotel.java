package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.DriverBase;
import utility.DriverHelper;

public class CleartripHotel extends DriverBase {

    WebDriver driver;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @FindBy(xpath = "//a[text() ='Indiranagar, Bangalore, Karnataka, India']")
    private WebElement locationSuggetion;

    @FindBy(xpath = "//div[@class = 'searchSummary']")
    private WebElement searchSummary;

    @FindBy(xpath = "//span[text() = 'July']/ancestor::div[@class='monthBlock first']//table[@class = 'calendar']//a[text()='27']")
    private WebElement selectheckInDate;

    @FindBy(xpath = "//span[text() = 'July']/ancestor::div[@class='monthBlock first']//table[@class = 'calendar']//a[text()='28']")
    private WebElement selectheckOutDate;

    public CleartripHotel(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clickOnHotels(){
        hotelLink.click();
    }

    public void enterLocation(String location){
        localityTextBox.sendKeys(location);
    }

    public void setTravellerSelection(String travellers){
        new Select(travellerSelection).selectByVisibleText(travellers);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void selectLocationFromSuggetions(){
        DriverHelper.explicitWaitForVisibilityOfElement(driver, By.xpath("//a[text() ='Indiranagar, Bangalore, Karnataka, India']"));
        driver.findElement(By.xpath("//a[text() ='Indiranagar, Bangalore, Karnataka, India']")).click();
    }

    public boolean isSearchSummaryDisplayed(){
        try{
            DriverHelper.explicitWaitForElementToBeClickable(driver, By.xpath("//a[@data-text='Indiranagar']"));
            return driver.findElement(By.xpath("//div[@class = 'searchSummary']")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public void selectCheckInDate(){
        DriverHelper.explicitWaitForElementToBeClickable(driver, By.xpath("//span[text() = 'July']/ancestor::div[@class='monthBlock first']//table[@class = 'calendar']//a[text()='27']"));
        selectheckInDate.click();
    }

    public void selectCheckOutDate(){
        DriverHelper.explicitWaitForElementToBeClickable(driver, By.xpath("//span[text() = 'July']/ancestor::div[@class='monthBlock first']//table[@class = 'calendar']//a[text()='28']"));
        selectheckOutDate.click();
    }
}
