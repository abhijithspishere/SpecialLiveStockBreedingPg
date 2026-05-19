package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import PageObjects.Doctor_Login;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_012_FourthVisit extends Hook {

    @Test(description = "Verify doctor date of birth update, FLIO fourth visit approval and AHELP fourth visit functionality")
    public void testDoctorUpdateDateOfBirthAndThirdVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: Doctor Date of Birth Update, FLIO Fourth Visit Approval and AHELP Fourth Visit");
        logger.info("Starting doctor date of birth update, FLIO fourth visit approval and AHELP fourth visit test");

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
        String newDateOfBirth = "07/02/2026";
        test.log(Status.INFO, "Updating date of birth to: " + newDateOfBirth);
        logger.info("Updating date of birth to: " + newDateOfBirth);
        doctorLoginPage.updateDateOfBirth(newDateOfBirth);
        test.log(Status.INFO, "Date of birth updated successfully");
        logger.info("Date of birth updated successfully");

        // Print to console
        System.out.println("Date updated successfully!");
        test.log(Status.INFO, "Date updated successfully!");
        logger.info("Date updated successfully!");

        // Step 4: FLIO navigation and approval for fourth visit
        test.log(Status.INFO, "Performing FLIO operations for fourth visit");
        logger.info("Performing FLIO operations for fourth visit");

        FLIO_Login flioV = new FLIO_Login(driver);

        test.log(Status.INFO, "Executing Flionew method");
        logger.info("Executing Flionew method");
        flioV.Flionew();

        test.log(Status.INFO, "Clicking navigation link");
        logger.info("Clicking navigation link");
        flioV.navigationLink();

        test.log(Status.INFO, "Accessing FLIO approval page");
        logger.info("Accessing FLIO approval page");
        flioV.flioApproval();

        test.log(Status.INFO, "Updating fourth visit");
        logger.info("Updating fourth visit");
        flioV.updateFourthvisit();
        test.log(Status.INFO, "FLIO fourth visit update completed");
        logger.info("FLIO fourth visit update completed");

        // Step 5: AHELP fourth visit update
        test.log(Status.INFO, "Performing AHELP fourth visit update");
        logger.info("Performing AHELP fourth visit update");

        AHELP_LoginPage ahelp = new AHELP_LoginPage(driver);
        ahelp.FourthVisitUpdate();
        test.log(Status.INFO, "AHELP fourth visit update completed");
        logger.info("AHELP fourth visit update completed");

        // Print to console
        System.out.println("AHELP Fourth Visit completed successfully!");
        test.log(Status.PASS, "AHELP Fourth Visit completed successfully");
        logger.info("AHELP Fourth Visit completed successfully");

        // Step 6: Verify visit for configured mobile
        test.log(Status.INFO, "Verifying visit for configured mobile number");
        logger.info("Verifying visit for configured mobile number");
        flioV.clickVerifyVisitForConfiguredMobile();
        test.log(Status.INFO, "Visit verification completed for configured mobile");
        logger.info("Visit verification completed for configured mobile");

        test.log(Status.PASS, "Test Fourth Visit passed successfully");
        logger.info("Test completed: Fourth visit");
    }
}