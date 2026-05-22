package Tests;

import Hooks.Hook;
import PageObjects.AHELP_LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC_013_AhelpFourthRestrict extends Hook {

    @Test(description = "Verify AHELP fourth visit restrict functionality")
    public void testAhelpFourthRestrict() throws InterruptedException, IOException {

        AHELP_LoginPage ahelpLoginPage = new AHELP_LoginPage(driver);
        ahelpLoginPage.fourthVisitRestrict();
        // Store the result of fourthVisitRestrict validation
        //boolean isRestricted = ahelpLoginPage.fourthVisitRestrict();

        // Assert that the restriction is working
        //Assert.assertTrue(isRestricted, "AHELP user should be restricted from 4th visit activities");
    }
}