package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import PageObjects.Doctor_Login;
import Utils.VisitDateUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_007_Doctor_Login extends Hook {

    @Test(description = "Verify doctor login and age edit functionality")
    public void testDoctorLogin() throws InterruptedException, IOException {

        AHELP_LoginPage ahelpPage = new AHELP_LoginPage(driver);
        String calfDOB = ahelpPage.getCalfDateOfBirth();

        String expectedDate = VisitDateUtils.getVisitDate(calfDOB, 30);

        System.out.println("Calf DOB: " + calfDOB);
        System.out.println("Expected Visit Date: " + expectedDate);

        Doctor_Login doctorLoginPage = new Doctor_Login(driver);

        doctorLoginPage.loginAsDoctor();

        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains("showOffices");
        Assert.assertTrue(isLoggedIn, "Doctor login failed");

        boolean urlContainsShowOffices = driver.getCurrentUrl().contains("showOffices");
        Assert.assertTrue(urlContainsShowOffices, "URL does not contain 'showOffices'. Current URL: " + driver.getCurrentUrl());
        System.out.println("Doctor login successful! URL contains showOffices: " + driver.getCurrentUrl());

        doctorLoginPage.editAge(expectedDate);

        String actualDate = doctorLoginPage.getUpdatedDateAfterEdit();

        Assert.assertEquals(actualDate, expectedDate,
                "Date update verification failed! Expected: " + expectedDate + ", Actual: " + actualDate);

        System.out.println("Date successfully verified: " + actualDate);
    }
}