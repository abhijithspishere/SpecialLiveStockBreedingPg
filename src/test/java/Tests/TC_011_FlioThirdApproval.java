package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_011_FlioThirdApproval extends Hook {

    @Test(description = "Verify FLIO third visit approval functionality")
    public void testFLIOVerifyThirdVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: FLIO Third Visit Approval");
        logger.info("Starting FLIO third visit approval test");

        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        // Step 1: Verify visit flow for third approval
        test.log(Status.INFO, "Performing FLIO visit verification flow for third approval");
        logger.info("Performing FLIO visit verification flow for third approval");
        flioLoginPage.verifyVisitFlow();
        test.log(Status.INFO, "FLIO visit verification flow completed");
        logger.info("FLIO visit verification flow completed");

        // Log success
        test.log(Status.PASS, "FLIO third visit approval completed successfully");
        logger.info("FLIO third visit approval completed successfully");

        test.log(Status.PASS, "Test FLIO Third Visit Approval passed successfully");
        logger.info("Test completed: FLIO third visit approval");
    }
}