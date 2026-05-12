package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_003_NewCalfRegistration extends Hook {

    @Test(description = "Verify new calf registration functionality")
    public void testRegisterNewCalf() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: New Calf Registration");
        logger.info("Starting new calf registration test");

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

        // Step 3: Register new calf with Excel data
        test.log(Status.INFO, "Registering new calf with data from Excel");
        logger.info("Filling calf registration form with Excel data");
        String alertMsg = loginPage.newCalfRegAndGetAlert();

        test.log(Status.INFO, "Alert message received: " + alertMsg);
        logger.info("Alert message: " + alertMsg);
        System.out.println("Alert message: " + alertMsg);

        // Verify calf registration success
        Assert.assertTrue(alertMsg.contains("New calf registered successfully."),
                "Calf registration failed. Alert message: " + alertMsg);

        test.log(Status.PASS, "New calf registered successfully with message: " + alertMsg);
        logger.info("Calf registration successful");

        test.log(Status.PASS, "Test New Calf Registration passed successfully");
        logger.info("Test completed: New calf registration");
    }
}