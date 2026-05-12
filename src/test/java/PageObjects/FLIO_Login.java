package PageObjects;

import Hooks.Hook;
import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class FLIO_Login extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='LOGIN']")
    private WebElement loginLink;

    @FindBy(xpath = "//label[normalize-space()='AHD officials']")
    private WebElement ahdOfficialsOption;

    @FindBy(xpath = "//input[@id='inputEmailAHD']")
    private WebElement ahdUsernameField;

    @FindBy(xpath = "//input[@id='inputPasswordAHD']")
    private WebElement ahdPasswordField;

    @FindBy(xpath = "//form[@id='userLoginForm']//button[@value='Submit'][normalize-space()='Let me in']")
    private WebElement ahdLoginSubmitButton;

    @FindBy(xpath = "//a[@href='/navigation/slbp']")
    private WebElement navigationLink;

    @FindBy(xpath = "//span[normalize-space()='Task Schedule']")
    private WebElement taskScheduleLink;

    @FindBy(xpath = "//table[@id='flioTable']//a[normalize-space()='View Tasks']")
    private WebElement viewTasksLink;

    @FindBy(xpath = "//button[normalize-space()='Approve']")
    private WebElement approveBtnFinal;

    @FindBy(xpath = "//textarea[@id='approvalRemarks']")
    private WebElement approvalRemarksField;

    @FindBy(xpath = "//input[@id='approveConfirm']")
    private WebElement approveConfirmCheckbox;

    @FindBy(xpath = "//button[@id='submitApprove']")
    private WebElement submitApproveButton;


    public FLIO_Login(WebDriver driver) throws IOException {
        super(driver);
    }

    public void loginAsFLIO() throws InterruptedException {
        click(loginLink);
        click(ahdOfficialsOption);
        String username = ConfigReader.getUsername("flio");
        String password = ConfigReader.getPassword("flio");
        sendKeys(ahdUsernameField,username);
        sendKeys(ahdPasswordField,password);
        click(ahdLoginSubmitButton);
    }
    public void navigationLink() throws InterruptedException {
        click(navigationLink);
    }
    public void flioApproval() throws InterruptedException {

        waitForPageLoad();

        scrollToElement(taskScheduleLink);

        waitForMilliseconds(1000);

        clickWithJS(taskScheduleLink);
        click(viewTasksLink);
    }
    public void clickApproveEnrollmentForConfiguredMobile() throws InterruptedException {

        String mobileNumber = ConfigReader.getProperty("test.farmer.mobile");

        String xpath =
                "//tr[td[contains(.,'" + mobileNumber + "')]]//a[contains(.,'Approve Enrolment Request')]";

        WebElement approveButton = driver.findElement(By.xpath(xpath));

        click(approveButton);
//      Thread.sleep(2000);
        click(approveBtnFinal);
        sendKeys(approvalRemarksField,"Approved by FLIO");
        click(approveConfirmCheckbox);
        click(submitApproveButton);

    }

  /*  public boolean isMobileNumberRemovedAfterApproval() {
        String mobileNumber = ConfigReader.getProperty("test.farmer.mobile");
        String xpath =
                "//tr[td[contains(.,'" + mobileNumber + "')]]";
        return driver.findElements(By.xpath(xpath)).isEmpty();
    }*/

    public boolean isEnrollmentApproved() {

        String mobileNumber = ConfigReader.getProperty("test.farmer.mobile");

        String xpath =
                "//tr[td[contains(.,'" + mobileNumber + "')]]" +
                        "//div[contains(@class,'status-cell') and contains(.,'Completed')]";

        return driver.findElements(By.xpath(xpath)).size() > 0;
    }

}