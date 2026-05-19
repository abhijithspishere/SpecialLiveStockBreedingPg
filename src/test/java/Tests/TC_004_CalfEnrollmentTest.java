package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_004_CalfEnrollmentTest extends Hook {

    @Test(description = "Verify calf enrollment request functionality")
    public void testRequestCalfEnrollment() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: Calf Enrollment Request");
        logger.info("Starting calf enrollment request test");

        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        // Step 1: Login with configured credentials
        test.log(Status.INFO, "Logging in with configured credentials");
        logger.info("Attempting to login with configured credentials");
        loginPage.loginWithConfigCredentials();
        test.log(Status.PASS, "Login successful");
        logger.info("Login successful");

        Thread.sleep(2000);

        // Step 2: Navigate to SLBP profile
        test.log(Status.INFO, "Navigating to SLBP profile");
        logger.info("Navigating to SLBP profile");
        loginPage.newSlbpProfile();
        test.log(Status.INFO, "Successfully navigated to SLBP profile");
        logger.info("Successfully navigated to SLBP profile");

        // Step 3: Set registered mobile number
        String mobileNumber = loginPage.getTestFarmerMobile();
        test.log(Status.INFO, "Setting registered mobile number: " + mobileNumber);
        logger.info("Setting registered mobile number: " + mobileNumber);
        loginPage.setRegisteredMobileNumber(mobileNumber);
        test.log(Status.INFO, "Mobile number set successfully");
        logger.info("Mobile number set successfully");

        // Step 4: Search owner by mobile number
        test.log(Status.INFO, "Searching owner by mobile number: " + mobileNumber);
        logger.info("Searching owner by mobile number: " + mobileNumber);
        loginPage.searchOwnerByMobile();
        test.log(Status.INFO, "Owner search completed");
        logger.info("Owner search completed");

        // Step 5: Request calf enrollment
        test.log(Status.INFO, "Requesting calf enrollment");
        logger.info("Requesting calf enrollment");
        loginPage.requestCalfEnrollment();
        test.log(Status.INFO, "Calf enrollment request submitted");
        logger.info("Calf enrollment request submitted");

        // Step 6: Get enrollment success message
        test.log(Status.INFO, "Retrieving enrollment success message");
        logger.info("Retrieving enrollment success message");
        String successMessage = loginPage.getEnrollmentSuccessMessage();

        test.log(Status.INFO, "Success message received: " + successMessage);
        logger.info("Success message received: " + successMessage);
        test.log(Status.PASS, "Calf enrollment request completed successfully");
        logger.info("Calf enrollment request successful");

        // Print to console
        System.out.println("Success Message: " + successMessage);

        test.log(Status.PASS, "Test Calf Enrollment Request passed successfully");
        logger.info("Test completed: Calf enrollment request");
    }
}