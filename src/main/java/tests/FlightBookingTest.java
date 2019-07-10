package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CleartripFlights;
import utility.DriverBase;


public class FlightBookingTest extends DriverBase {

    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        String fromLocation = "Bangalore", toLocation ="Delhi";

        CleartripFlights cf = new CleartripFlights(driver);

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