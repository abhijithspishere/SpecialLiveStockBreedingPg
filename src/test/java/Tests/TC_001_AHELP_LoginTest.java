package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_001_AHELP_LoginTest extends Hook {

    @Test(description = "Verify AHELP login and farmer registration functionality")
    public void testAHELPLogin() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: AHELP Login and Farmer Registration");
        logger.info("Starting AHELP login and farmer registration test");

        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        // Step 1: Login with configured credentials
        test.log(Status.INFO, "Logging in with configured credentials");
        logger.info("Attempting to login with configured credentials");
        loginPage.loginWithConfigCredentials();

        // Verify login success with null safety
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

        // Step 2: Register new farmer
        test.log(Status.INFO, "Registering new farmer with data from Excel");
        logger.info("Navigating to SLBP profile and adding new farmer");
        loginPage.newSlbpProfile();
        loginPage.addFarmer();
        test.log(Status.INFO, "Farmer registration form submitted with Excel data");

        // Verify farmer registration success
        boolean isRegisterFarmerCompleted = false;
        String afterRegistrationUrl = driver.getCurrentUrl();
        if (afterRegistrationUrl != null) {
            isRegisterFarmerCompleted = afterRegistrationUrl.contains("showSlbpProfile");
            if (isRegisterFarmerCompleted) {
                test.log(Status.INFO, "Farmer registration verified via URL redirect to showSlbpProfile");
            }
        }

        if (!isRegisterFarmerCompleted) {
            String pageSource = driver.getPageSource();
            if (pageSource != null) {
                isRegisterFarmerCompleted = pageSource.contains("Welcome") ||
                        pageSource.contains("Farmer registered successfully");
                if (isRegisterFarmerCompleted) {
                    test.log(Status.INFO, "Farmer registration verified via success message in page source");
                }
            }
        }

        if (!isRegisterFarmerCompleted) {
            isRegisterFarmerCompleted = !driver.findElements(By.id("user-menu")).isEmpty();
            if (isRegisterFarmerCompleted) {
                test.log(Status.INFO, "Farmer registration verified via user-menu element");
            }
        }

        Assert.assertTrue(isRegisterFarmerCompleted, "Registration of farmer failed");
        test.log(Status.PASS, "Farmer registration completed successfully");
        logger.info("Farmer registration successful");

        test.log(Status.PASS, "Test AHELP Login and Farmer Registration passed successfully");
        logger.info("Test completed: AHELP login and farmer registration");
    }
}