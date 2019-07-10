package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CleartripSignin;
import utility.DriverBase;

public class SignInTest extends DriverBase {

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        CleartripSignin signin = new CleartripSignin(driver);

        signin.clickOnYourTrips();

        signin.clickOnsigninInDropdown();

        signin.clickOnSigninInPopup();

        signin.getErrorMessages();

        Assert.assertTrue(signin.getErrorMessages().contains("There were errors in your submission"));
    }
}