package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_005_FLIO_Login extends Hook {

    @Test(description = "Verify FLIO login functionality")
    public void testFLIOLogin() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: FLIO Login");
        logger.info("Starting FLIO login test");

        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        // Step 1: Login as FLIO
        test.log(Status.INFO, "Logging in as FLIO user");
        logger.info("Attempting to login as FLIO user");
        flioLoginPage.loginAsFLIO();
        test.log(Status.INFO, "FLIO login credentials submitted");
        logger.info("FLIO login credentials submitted");

        Thread.sleep(3000);

        // Step 2: Verify login success
        test.log(Status.INFO, "Verifying FLIO login success");
        logger.info("Verifying FLIO login success");

        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;

        if (isLoggedIn) {
            test.log(Status.PASS, "FLIO login successful");
            logger.info("FLIO login successful");
        } else {
            test.log(Status.FAIL, "FLIO login failed");
            logger.error("FLIO login failed");
        }

        Assert.assertTrue(isLoggedIn, "FLIO login failed");

        test.log(Status.PASS, "Test FLIO Login passed successfully");
        logger.info("Test completed: FLIO login");
    }
}