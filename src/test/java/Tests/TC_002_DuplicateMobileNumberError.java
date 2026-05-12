package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_002_DuplicateMobileNumberError extends Hook {

    @Test(description = "Verify that duplicate mobile number shows appropriate error message")
    public void testDuplicateMobileNumberError() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: Duplicate Mobile Number Error");
        logger.info("Starting duplicate mobile number validation test");

        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        // Step 1: Login
        test.log(Status.INFO, "Logging in with configured credentials");
        logger.info("Attempting to login with configured credentials");
        loginPage.loginWithConfigCredentials();

        // Verify login success with null safety
        boolean isLoggedIn = false;

        // Check URL with null safety
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl != null) {
            isLoggedIn = currentUrl.contains("home");
            if (isLoggedIn) {
                test.log(Status.INFO, "Login verified via URL redirect to home");
            }
        }

        // Check page source if URL check failed
        if (!isLoggedIn) {
            String pageSource = driver.getPageSource();
            if (pageSource != null) {
                isLoggedIn = pageSource.contains("Welcome");
                if (isLoggedIn) {
                    test.log(Status.INFO, "Login verified via Welcome message in page source");
                }
            }
        }

        // Check for user menu element as fallback
        if (!isLoggedIn) {
            isLoggedIn = !driver.findElements(By.id("user-menu")).isEmpty();
            if (isLoggedIn) {
                test.log(Status.INFO, "Login verified via user-menu element");
            }
        }

        Assert.assertTrue(isLoggedIn, "AHELP login failed");
        test.log(Status.PASS, "Login successful");
        logger.info("Login successful");

        Thread.sleep(2000);

        // Step 2: Create new SLBP profile and add duplicate mobile number
        test.log(Status.INFO, "Creating new SLBP profile with duplicate mobile number");
        logger.info("Navigating to new SLBP profile and adding farmer with duplicate mobile number");
        loginPage.newSlbpProfile();
        loginPage.addFarmerDuplicateMobile();
        test.log(Status.INFO, "Entered duplicate mobile number: " + loginPage.getTestFarmerMobile());

        // Step 3: Get and validate error message
        test.log(Status.INFO, "Capturing duplicate mobile number error message");
        String actualMessage = loginPage.getMobileNumberError();
        String expectedMessage = "Mobile number already exists";

        logger.info("Captured error message: '" + actualMessage + "'");
        logger.info("Expected error message: '" + expectedMessage + "'");
        test.log(Status.INFO, "Error message captured: " + actualMessage);

        // Assert the error message
        Assert.assertEquals(
                actualMessage.trim(),
                expectedMessage,
                "Duplicate mobile number error message mismatch"
        );

        // Log success
        test.log(Status.PASS, "Successfully validated duplicate mobile number error message");
        test.log(Status.PASS, "Expected: '" + expectedMessage + "' | Actual: '" + actualMessage + "'");
        logger.info("Test passed: Duplicate mobile number error message validated successfully");

        System.out.println("Success Message: " + actualMessage);
    }
}