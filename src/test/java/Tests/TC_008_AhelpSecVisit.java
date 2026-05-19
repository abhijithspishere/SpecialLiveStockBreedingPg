package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_008_AhelpSecVisit extends Hook {

    @Test(description = "Verify AHELP second visit update functionality")
    public void testAhelpSecondVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: AHELP Second Visit Update");
        logger.info("Starting AHELP second visit update test");

        AHELP_LoginPage ahelpLoginPage = new AHELP_LoginPage(driver);

        // Step 1: Perform second visit update
        test.log(Status.INFO, "Performing AHELP second visit update");
        logger.info("Performing AHELP second visit update");
        ahelpLoginPage.SecondVisitUpdate();
        test.log(Status.INFO, "AHELP second visit update completed");
        logger.info("AHELP second visit update completed");

        // Log success
        test.log(Status.PASS, "AHELP Second Visit completed successfully");
        logger.info("AHELP Second Visit completed successfully");

        // Print to console
        System.out.println("AHELP Second Visit completed successfully!");

        test.log(Status.PASS, "Test AHELP Second Visit passed successfully");
        logger.info("Test completed: AHELP second visit update");
    }
}