package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_006_FlioApproval extends Hook {

    @Test(description = "Verify FLIO approval functionality for calf enrollment")
    public void testFLIOApproval() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: FLIO Approval for Calf Enrollment");
        logger.info("Starting FLIO approval test");

        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        // Step 1: Login as FLIO
        test.log(Status.INFO, "Logging in as FLIO user");
        logger.info("Attempting to login as FLIO user");
        flioLoginPage.loginAsFLIO();
        test.log(Status.INFO, "FLIO login credentials submitted");
        logger.info("FLIO login credentials submitted");

        Thread.sleep(3000);

        // Step 2: Verify login success
        test.log(Status.INFO, "Verifying FLIO login success");
        logger.info("Verifying FLIO login success");

        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;

        if (isLoggedIn) {
            test.log(Status.PASS, "FLIO login successful");
            logger.info("FLIO login successful");
        } else {
            test.log(Status.FAIL, "FLIO login failed");
            logger.error("FLIO login failed");
        }

        Assert.assertTrue(isLoggedIn, "FLIO login failed");

        // Step 3: Navigate to approval section
        test.log(Status.INFO, "Navigating to approval section");
        logger.info("Navigating to approval section");
        flioLoginPage.navigationLink();
        test.log(Status.INFO, "Navigation link clicked");
        logger.info("Navigation link clicked");

        // Step 4: Access FLIO approval page
        test.log(Status.INFO, "Accessing FLIO approval page");
        logger.info("Accessing FLIO approval page");
        flioLoginPage.flioApproval();
        test.log(Status.INFO, "FLIO approval page accessed");
        logger.info("FLIO approval page accessed");

        // Step 5: Click approve enrollment for configured mobile number
        test.log(Status.INFO, "Clicking approve enrollment for configured mobile number");
        logger.info("Clicking approve enrollment for configured mobile number");
        flioLoginPage.clickApproveEnrollmentForConfiguredMobile();
        test.log(Status.INFO, "Approve enrollment action performed");
        logger.info("Approve enrollment action performed");

        Thread.sleep(2000);

        // Step 6: Verify enrollment approval status
        test.log(Status.INFO, "Verifying enrollment approval status");
        logger.info("Verifying enrollment approval status");

        boolean isApproved = flioLoginPage.isEnrollmentApproved();

        if (isApproved) {
            test.log(Status.PASS, "Enrollment approved successfully for configured mobile number");
            logger.info("Enrollment approved successfully for configured mobile number");
        } else {
            test.log(Status.FAIL, "Enrollment approval failed for configured mobile number");
            logger.error("Enrollment approval failed for configured mobile number");
        }

        Assert.assertTrue(isApproved, "Enrollment approval failed for mobile number");

        test.log(Status.PASS, "Test FLIO Approval passed successfully");
        logger.info("Test completed: FLIO approval");
    }
}