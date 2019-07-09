package tests;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CleartripFlights;
import utility.DriverBase;

import java.util.List;

public class FlightBookingTest extends DriverBase {
    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        String fromLocation = "Bangalore", toLocation ="Delhi";

        CleartripFlights cf = new CleartripFlights(driver);

        driver.get("https://www.cleartrip.com");

        cf.clikOnOneWayRadioButton();

        cf.enterFromLocation(fromLocation);

        cf.selectLocationFromsuggestions(fromLocation);

        cf.enterToLocation(toLocation);

        cf.selectLocationFromsuggestions(toLocation);

        cf.selectDataOfJourney();

        cf.clickOnSearchbutton();

        Assert.assertTrue(cf.isSearchSummaryDisplayed(), "Search Summary is not displaying");
    }
}
