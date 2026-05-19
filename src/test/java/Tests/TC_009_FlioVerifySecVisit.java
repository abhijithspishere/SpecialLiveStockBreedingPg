package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_009_FlioVerifySecVisit extends Hook {

    @Test(description = "Verify FLIO second visit verification functionality")
    public void testFLIOVerifySecondVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: FLIO Second Visit Verification");
        logger.info("Starting FLIO second visit verification test");

        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        // Step 1: Verify visit flow
        test.log(Status.INFO, "Performing FLIO visit verification flow");
        logger.info("Performing FLIO visit verification flow");
        flioLoginPage.verifyVisitFlow();
        test.log(Status.INFO, "FLIO visit verification flow completed");
        logger.info("FLIO visit verification flow completed");

        // Log success
        test.log(Status.PASS, "FLIO second visit verification completed successfully");
        logger.info("FLIO second visit verification completed successfully");

        test.log(Status.PASS, "Test FLIO Second Visit Verification passed successfully");
        logger.info("Test completed: FLIO second visit verification");
    }
}