package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import PageObjects.Doctor_Login;
import Utils.VisitDateUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_014_AhelpFifthVisit extends Hook {
    @Test(description = "Verify doctor can update date of birth and AHELP fifth visit functionality")
    public void testDoctorUpdateDateOfBirthAndThirdVisit() throws InterruptedException, IOException {


        AHELP_LoginPage ahelpPage = new AHELP_LoginPage(driver);
        String calfDOB = ahelpPage.getCalfDateOfBirth();

        String expectedDate = VisitDateUtils.getVisitDate(calfDOB, 151);

        System.out.println("Calf DOB: " + calfDOB);
        System.out.println("Expected 3rd Visit Date: " + expectedDate);

        Doctor_Login doctorLoginPage = new Doctor_Login(driver);

        doctorLoginPage.loginAsDoctor();

        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains("showOffices");
        Assert.assertTrue(isLoggedIn, "Doctor login failed");

        doctorLoginPage.updateDateOfBirth(expectedDate);
        AHELP_LoginPage ahelpLoginPage = new AHELP_LoginPage(driver);
        ahelpLoginPage.fifthVisitUpdate();

        System.out.println("AHELP Fifth Visit completed successfully!");
    }
}
