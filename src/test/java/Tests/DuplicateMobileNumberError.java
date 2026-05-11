package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DuplicateMobileNumberError extends Hook {

    @Test
    public void testRequestCalfEnrollment() throws InterruptedException {
        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        loginPage.loginWithConfigCredentials();

        // Verify login success
        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;
        Assert.assertTrue(isLoggedIn, "AHELP login failed");

        Thread.sleep(2000);


        loginPage.newSlbpProfile();
        loginPage.addFarmerDuplicateMobile();
        loginPage.getMobileNumberError();
        String actualMessage = loginPage.getMobileNumberError();

        Assert.assertEquals(
                actualMessage.trim(),
                "Mobile number already exists",
                "Duplicate mobile number error message mismatch"
        );

        System.out.println("Success Message: " + actualMessage);


    }
}