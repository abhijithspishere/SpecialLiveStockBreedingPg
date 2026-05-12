package Tests;

import Hooks.Hook;
import PageObjects.FLIO_Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_005_FLIO_Login extends Hook {

    @Test
    public void testFLIOLogin() throws InterruptedException, IOException {
        FLIO_Login flioLoginPage = new FLIO_Login(driver);

        flioLoginPage.loginAsFLIO();
        Thread.sleep(3000);

        boolean isLoggedIn = driver.getCurrentUrl().contains("home") ||
                driver.getPageSource().contains("Welcome") ||
                driver.findElements(By.id("user-menu")).size() > 0;

        Assert.assertTrue(isLoggedIn, "FLIO login failed");
    }
}