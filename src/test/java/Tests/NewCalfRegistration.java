package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCalfRegistration extends Hook {

    @Test
    public void testRegisterNewCalf() throws InterruptedException {
        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        loginPage.loginWithConfigCredentials();
        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;  // example

        Assert.assertTrue(isLoggedIn, "AHELP login failed");

        Thread.sleep(2000);

        loginPage.newSlbpProfile();
        loginPage.setRegisteredMobileNumber(loginPage.getTestFarmerMobile());
        loginPage.searchOwnerByMobile();

        String alertMsg = loginPage.newCalfRegAndGetAlert();
        System.out.println("Alert message: " + alertMsg);
        Assert.assertTrue(alertMsg.contains("New calf registered successfully."), "Alert message: " + alertMsg);
    }
}