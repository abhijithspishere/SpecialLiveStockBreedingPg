package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_006_FlioApproval extends Hook {

    @Test
    public void testFLIOApproval() throws InterruptedException, IOException {
        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        flioLoginPage.loginAsFLIO();
        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;

        Assert.assertTrue(isLoggedIn, "FLIO login failed");

        flioLoginPage.navigationLink();
        flioLoginPage.flioApproval();
        flioLoginPage.clickApproveEnrollmentForConfiguredMobile();

        Thread.sleep(2000);
        Assert.assertTrue(
                flioLoginPage.isEnrollmentApproved(),
                "Enrollment approval failed for mobile number"
        );
    }
}