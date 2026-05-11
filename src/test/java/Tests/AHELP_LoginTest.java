package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AHELP_LoginTest extends Hook {

    @Test
    public void testAHELPLogin() throws InterruptedException {
        AHELP_LoginPage loginPage = new AHELP_LoginPage(driver);

        loginPage.loginWithConfigCredentials();

        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;  // example

        Assert.assertTrue(isLoggedIn, "AHELP login failed");
        loginPage.newSlbpProfile();
        loginPage.addFarmer();

        boolean isRegisterFarmerCptd = driver.getCurrentUrl().contains("showSlbpProfile") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;  // example

        Assert.assertTrue(isRegisterFarmerCptd, "Registration of farmer failed");
    }
}