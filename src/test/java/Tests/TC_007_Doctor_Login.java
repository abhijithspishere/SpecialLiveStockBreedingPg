package Tests;

import Hooks.Hook;
import PageObjects.Doctor_Login;
import com.aventstack.extentreports.Status;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_007_Doctor_Login extends Hook {

    @Test(description = "Verify doctor login and age edit functionality")
    public void testDoctorLogin() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: Doctor Login and Age Edit");
        logger.info("Starting doctor login and age edit test");

        Doctor_Login doctorLoginPage = new Doctor_Login(driver);

        // Step 1: Login as Doctor
        test.log(Status.INFO, "Logging in as Doctor");
        logger.info("Attempting to login as Doctor");
        doctorLoginPage.loginAsDoctor();
        test.log(Status.INFO, "Doctor login credentials submitted");
        logger.info("Doctor login credentials submitted");

        Thread.sleep(3000);

        // Step 2: Verify login success
        test.log(Status.INFO, "Verifying doctor login success");
        logger.info("Verifying doctor login success");

        boolean isLoggedIn = driver.getCurrentUrl().contains("showOffices");

        if (isLoggedIn) {
            test.log(Status.PASS, "Doctor login successful");
            logger.info("Doctor login successful");
        } else {
            test.log(Status.FAIL, "Doctor login failed");
            logger.error("Doctor login failed");
        }

        Assert.assertTrue(isLoggedIn, "Doctor login failed");

        // Step 3: Verify URL contains showOffices
        test.log(Status.INFO, "Verifying URL contains 'showOffices'");
        logger.info("Verifying URL contains 'showOffices'");

        boolean urlContainsShowOffices = driver.getCurrentUrl().contains("showOffices");

        if (urlContainsShowOffices) {
            test.log(Status.PASS, "URL verification successful - contains 'showOffices'");
            logger.info("URL verification successful - contains 'showOffices'");
        } else {
            test.log(Status.FAIL, "URL verification failed - does not contain 'showOffices'");
            logger.error("URL verification failed - does not contain 'showOffices'");
        }

        Assert.assertTrue(urlContainsShowOffices, "URL does not contain 'showOffices'. Current URL: " + driver.getCurrentUrl());

        System.out.println("Doctor login successful! URL contains showOffices: " + driver.getCurrentUrl());
        test.log(Status.INFO, "Doctor login successful! URL: " + driver.getCurrentUrl());
        logger.info("Doctor login successful! URL: " + driver.getCurrentUrl());

        // Step 4: Edit age
        test.log(Status.INFO, "Editing age");
        logger.info("Editing age");
        doctorLoginPage.editAge();
        test.log(Status.INFO, "Age edit action performed");
        logger.info("Age edit action performed");

        // Step 5: Get updated date after edit
        test.log(Status.INFO, "Retrieving updated date after edit");
        logger.info("Retrieving updated date after edit");

        String expectedDate = "09/04/2026";
        String actualDate = doctorLoginPage.getUpdatedDateAfterEdit();

        test.log(Status.INFO, "Expected date: " + expectedDate);
        test.log(Status.INFO, "Actual date: " + actualDate);
        logger.info("Expected date: " + expectedDate);
        logger.info("Actual date: " + actualDate);

        // Step 6: Verify date update
        test.log(Status.INFO, "Verifying date update");
        logger.info("Verifying date update");

        try {
            Assert.assertEquals(actualDate, expectedDate,
                    "Date update verification failed! Expected: " + expectedDate + ", Actual: " + actualDate);
            test.log(Status.PASS, "Date update verification successful");
            logger.info("Date update verification successful");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Date update verification failed: " + e.getMessage());
            logger.error("Date update verification failed: " + e.getMessage());
            throw e;
        }

        System.out.println("Date successfully verified: " + actualDate);
        test.log(Status.INFO, "Date successfully verified: " + actualDate);
        logger.info("Date successfully verified: " + actualDate);

        test.log(Status.PASS, "Test Doctor Login and Age Edit passed successfully");
        logger.info("Test completed: Doctor login and age edit");
    }
}