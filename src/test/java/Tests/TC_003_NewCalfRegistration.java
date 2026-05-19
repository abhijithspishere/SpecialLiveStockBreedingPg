package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_003_NewCalfRegistration extends Hook {

    @Test(description = "Verify new calf registration functionality")
    public void testRegisterNewCalf() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: New Calf Registration");
        logger.info("Starting new calf registration test");

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

        // Step 5: Register new calf and get alert message
        test.log(Status.INFO, "Registering new calf");
        logger.info("Registering new calf");
        String alertMsg = loginPage.newCalfRegAndGetAlert();

        test.log(Status.INFO, "Alert message received: " + alertMsg);
        logger.info("Alert message received: " + alertMsg);
        test.log(Status.PASS, "New calf registration completed successfully");
        logger.info("New calf registration successful");

        // Print to console
        System.out.println("Alert message: " + alertMsg);

        test.log(Status.PASS, "Test New Calf Registration passed successfully");
        logger.info("Test completed: New calf registration");
    }
}