package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_017_FlioVerifySixthVisit extends Hook {
    @Test(description = "Verify FLIO sixth visit verification functionality")
    public void testFLIOVerifySixthVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: FLIO Sixth Visit Verification");
        logger.info("Starting FLIO sixth visit verification test");

        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        // Step 1: Verify visit flow
        test.log(Status.INFO, "Performing FLIO visit verification flow");
        logger.info("Performing FLIO visit verification flow");
        flioLoginPage.verifyVisitFlow();
        test.log(Status.INFO, "FLIO visit verification flow completed");
        logger.info("FLIO visit verification flow completed");

        // Log success
        test.log(Status.PASS, "FLIO sixth visit verification completed successfully");
        logger.info("FLIO sixth visit verification completed successfully");

        test.log(Status.PASS, "Test FLIO Sixth Visit Verification passed successfully");
        logger.info("Test completed: FLIO sixth visit verification");
    }
}