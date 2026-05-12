package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_004_CalfEnrollmentTest extends Hook {

    @Test(description = "Verify calf enrollment request functionality")
    public void testRequestCalfEnrollment() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: Calf Enrollment Request");
        logger.info("Starting calf enrollment request test");

        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        // Step 1: Login
        test.log(Status.INFO, "Logging in with configured credentials");
        logger.info("Attempting to login with configured credentials");
        loginPage.loginWithConfigCredentials();

        // Verify login success
        boolean isLoggedIn = false;
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl != null) {
            isLoggedIn = currentUrl.contains("home");
            if (isLoggedIn) {
                test.log(Status.INFO, "Login verified via URL redirect to home");
            }
        }

        if (!isLoggedIn) {
            String pageSource = driver.getPageSource();
            if (pageSource != null) {
                isLoggedIn = pageSource.contains("Welcome");
                if (isLoggedIn) {
                    test.log(Status.INFO, "Login verified via Welcome message in page source");
                }
            }
        }

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

        // Step 2: Navigate to SLBP profile and search owner
        test.log(Status.INFO, "Navigating to SLBP profile");
        logger.info("Creating new SLBP profile");
        loginPage.newSlbpProfile();

        test.log(Status.INFO, "Searching owner by mobile number");
        logger.info("Searching owner with mobile number: " + loginPage.getTestFarmerMobile());
        loginPage.setRegisteredMobileNumber(loginPage.getTestFarmerMobile());
        loginPage.searchOwnerByMobile();
        test.log(Status.PASS, "Owner found successfully");

        // Step 3: Request calf enrollment with Excel data
        test.log(Status.INFO, "Requesting calf enrollment with data from Excel");
        logger.info("Filling calf enrollment form with Excel data");
        loginPage.requestCalfEnrollment();
        test.log(Status.INFO, "Calf enrollment request submitted");

        // Step 4: Get and validate success message
        test.log(Status.INFO, "Capturing enrollment success message");
        String actualMessage = loginPage.getEnrollmentSuccessMessage();
        String expectedMessage = "Enrollment Request Submitted!";

        logger.info("Captured success message: '" + actualMessage + "'");
        logger.info("Expected success message: '" + expectedMessage + "'");
        test.log(Status.INFO, "Success message captured: " + actualMessage);

        // Assert enrollment success
        Assert.assertEquals(
                actualMessage.trim(),
                expectedMessage,
                "Enrollment request submission failed"
        );

        test.log(Status.PASS, "Enrollment request submitted successfully");
        test.log(Status.PASS, "Expected: '" + expectedMessage + "' | Actual: '" + actualMessage + "'");
        logger.info("Enrollment request successful");

        System.out.println("Success Message: " + actualMessage);

        test.log(Status.PASS, "Test Calf Enrollment Request passed successfully");
        logger.info("Test completed: Calf enrollment request");
    }
}