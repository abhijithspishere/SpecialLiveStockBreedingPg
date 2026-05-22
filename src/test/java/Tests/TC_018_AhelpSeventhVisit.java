package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import PageObjects.Doctor_Login;
import Utils.VisitDateUtils;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_018_AhelpSeventhVisit extends Hook {
    @Test(description = "Verify AHELP Seventh visit update functionality")
    public void testAhelpSixthVisit() throws InterruptedException, IOException {
        // Log test start
        test.log(Status.INFO, "Starting test: AHELP Sixth Visit Update");
        logger.info("Starting AHELP sixth visit update test");

        AHELP_LoginPage ahelpPage = new AHELP_LoginPage(driver);
        String calfDOB = ahelpPage.getCalfDateOfBirth();

        String expectedDate = VisitDateUtils.getVisitDate(calfDOB, 271);

        System.out.println("Calf DOB: " + calfDOB);
        System.out.println("Expected 3rd Visit Date: " + expectedDate);

        Doctor_Login doctorLoginPage = new Doctor_Login(driver);

        doctorLoginPage.loginAsDoctor();

        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains("showOffices");
        Assert.assertTrue(isLoggedIn, "Doctor login failed");

        doctorLoginPage.updateDateOfBirth(expectedDate);
        AHELP_LoginPage ahelpLoginPage = new AHELP_LoginPage(driver);
        ahelpLoginPage.sixthVisitUpdate();

        System.out.println("AHELP Seventh Visit completed successfully!");
    }
}
