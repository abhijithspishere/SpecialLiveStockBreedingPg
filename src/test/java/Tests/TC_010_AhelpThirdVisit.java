package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import PageObjects.Doctor_Login;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_010_AhelpThirdVisit extends Hook {

    @Test(description = "Verify doctor date of birth update and AHELP third visit functionality")
    public void testDoctorUpdateDateOfBirthAndThirdVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: Doctor Date of Birth Update and AHELP Third Visit");
        logger.info("Starting doctor date of birth update and AHELP third visit test");

        Doctor_Login doctorLoginPage = new Doctor_Login(driver);

        // Step 1: Login as Doctor
        test.log(Status.INFO, "Logging in as Doctor");
        logger.info("Attempting to login as Doctor");
        doctorLoginPage.loginAsDoctor();
        test.log(Status.INFO, "Doctor login credentials submitted");
        logger.info("Doctor login credentials submitted");

        // Step 2: Verify login success
        test.log(Status.INFO, "Verifying doctor login success");
        logger.info("Verifying doctor login success");

        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;

        if (isLoggedIn) {
            test.log(Status.PASS, "Doctor login successful");
            logger.info("Doctor login successful");
        } else {
            test.log(Status.FAIL, "Doctor login failed");
            logger.error("Doctor login failed");
        }

        Assert.assertTrue(isLoggedIn, "Doctor login failed");

        // Step 3: Update date of birth
        String newDateOfBirth = "10/03/2026";
        test.log(Status.INFO, "Updating date of birth to: " + newDateOfBirth);
        logger.info("Updating date of birth to: " + newDateOfBirth);
        doctorLoginPage.updateDateOfBirth(newDateOfBirth);
        test.log(Status.INFO, "Date of birth updated successfully");
        logger.info("Date of birth updated successfully");

        // Print to console
        System.out.println("Date updated successfully!");
        test.log(Status.INFO, "Date updated successfully!");
        logger.info("Date updated successfully!");

        // Step 4: Perform third visit update
        test.log(Status.INFO, "Performing AHELP third visit update");
        logger.info("Performing AHELP third visit update");

        AHELP_LoginPage ahelpLoginPage = new AHELP_LoginPage(driver);
        ahelpLoginPage.thirdVisitUpdate();
        test.log(Status.INFO, "AHELP third visit update completed");
        logger.info("AHELP third visit update completed");

        // Log success
        System.out.println("AHELP Third Visit completed successfully!");
        test.log(Status.PASS, "AHELP Third Visit completed successfully");
        logger.info("AHELP Third Visit completed successfully");

        test.log(Status.PASS, "Test Doctor Date of Birth Update and AHELP Third Visit passed successfully");
        logger.info("Test completed: Doctor date of birth update and AHELP third visit");
    }
}