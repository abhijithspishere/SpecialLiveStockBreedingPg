package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import PageObjects.Doctor_Login;
import PageObjects.FLIO_Login;
import Utils.VisitDateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_012_FourthVisit extends Hook {

    @Test(description = "Verify doctor date of birth update, FLIO fourth visit approval and AHELP fourth visit functionality")
    public void testDoctorUpdateDateOfBirthAndFourthVisit() throws InterruptedException, IOException {

        AHELP_LoginPage ahelpPage = new AHELP_LoginPage(driver);
        String calfDOB = ahelpPage.getCalfDateOfBirth();

        // 4th Visit = 90 days after birth
        String expectedDate = VisitDateUtils.getVisitDate(calfDOB, 90);

        System.out.println("Calf DOB: " + calfDOB);
        System.out.println("Expected 4th Visit Date: " + expectedDate);

        Doctor_Login doctorLoginPage = new Doctor_Login(driver);

        doctorLoginPage.loginAsDoctor();

        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains("showOffices");
        Assert.assertTrue(isLoggedIn, "Doctor login failed");

        doctorLoginPage.updateDateOfBirth(expectedDate);

        FLIO_Login flioV = new FLIO_Login(driver);
        flioV.Flionew();
        flioV.navigationLink();
        flioV.flioApproval();
        flioV.updateFourthvisit();

        AHELP_LoginPage ahelp = new AHELP_LoginPage(driver);
        ahelp.FourthVisitUpdate();

        flioV.clickVerifyVisitForConfiguredMobile();

        System.out.println("AHELP Fourth Visit completed successfully!");
    }
}