package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverBase;
import utility.DriverHelper;

public class CleartripFlights extends DriverBase {

    WebDriver driver;

    @FindBy(id = "OneWay")
    private WebElement oneWayRadioButton;

    @FindBy(xpath = "//input[@id = 'FromTag']")
    private WebElement fromLocation;

    @FindBy(xpath = "//input[@id = 'ToTag']")
    private WebElement toLocation;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")
    private WebElement dateOfjourney;

    @FindBy(id = "SearchBtn")
    private WebElement searchButton;

    @FindBy(className = "searchSummary")
    private WebElement searchSummary;

    public CleartripFlights(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clikOnOneWayRadioButton(){
        oneWayRadioButton.click();
    }

    public void enterFromLocation(String fromLocationText){
        fromLocation.clear();
        fromLocation.sendKeys(fromLocationText);
    }

    public void selectLocationFromsuggestions(String locationName){
        DriverHelper.explicitWaitForVisibilityOfElement(driver, By.xpath("//li[@class = 'list']//a[contains(text(), '"+ locationName +"')]"));
        driver.findElement(By.xpath("//li[@class = 'list']//a[contains(text(), '"+ locationName +"')]")).click();
    }

    public void enterToLocation(String toLocationText){
        toLocation.clear();
        toLocation.sendKeys(toLocationText);
    }

    public void selectDataOfJourney(){
        dateOfjourney.click();
    }

    public void clickOnSearchbutton(){
        searchButton.click();
    }

    public boolean isSearchSummaryDisplayed(){
        try{
            DriverHelper.explicitWaitForElementToBeClickable(driver, By.xpath("//li[@class = 'allFlights']"));
            return searchSummary.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
