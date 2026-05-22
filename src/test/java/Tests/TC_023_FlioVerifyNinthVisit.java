package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_023_FlioVerifyNinthVisit extends Hook {
    @Test(description = "Verify FLIO ninth visit verification functionality")
    public void testFLIOVerifyNinthVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: FLIO Ninth Visit Verification");
        logger.info("Starting FLIO ninth visit verification test");

        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        // Step 1: Verify visit flow
        test.log(Status.INFO, "Performing FLIO visit verification flow");
        logger.info("Performing FLIO visit verification flow");
        flioLoginPage.verifyVisitFlow();
        test.log(Status.INFO, "FLIO visit verification flow completed");
        logger.info("FLIO visit verification flow completed");

        // Log success
        test.log(Status.PASS, "FLIO ninth visit verification completed successfully");
        logger.info("FLIO ninth visit verification completed successfully");

        test.log(Status.PASS, "Test FLIO Ninth Visit Verification passed successfully");
        logger.info("Test completed: FLIO ninth visit verification");
    }
}