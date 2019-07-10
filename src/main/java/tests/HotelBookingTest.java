package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CleartripHotel;
import utility.DriverBase;

public class HotelBookingTest extends DriverBase {

    @Test
    public void shouldBeAbleToSearchForHotels() {

        CleartripHotel ch = new CleartripHotel(driver);

        ch.clickOnHotels();

        ch.enterLocation("Indiranagar, Bangalore");

        ch.selectLocationFromSuggetions();

        ch.selectCheckInDate();

        ch.selectCheckOutDate();

        ch.setTravellerSelection("2 rooms, 4 adults");

        ch.clickOnSearchButton();

        Assert.assertTrue(ch.isSearchSummaryDisplayed(), "Search summary is not displaying");
    }
}