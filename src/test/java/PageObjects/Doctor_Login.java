package PageObjects;

import Utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Doctor_Login extends FLIO_Login {

    private AHELP_LoginPage ahelpLoginPage;

    @FindBy(xpath = "//p[contains(text(),'Chief Veterinary Officer 1')]")
    private WebElement selectVeterinary;

    @FindBy(xpath = "//a[@href='/navigation/owner']")
    private WebElement ownerAnimalMgmtLink;

    @FindBy(xpath = "//a[normalize-space()='View Profile']")
    private WebElement viewProfileLink;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement editProfileButton;

    @FindBy(xpath = "//button[normalize-space()='YES']")
    private WebElement confirmEditButton;

    @FindBy(xpath = "//span[@id='select2-select-ownership-container']")
    private WebElement ownershipDropdown;

    @FindBy(xpath = "//li[normalize-space()='Self-Owned']")
    private WebElement selfOwnedOption;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//span[@aria-labelledby='select2-simple-parity-container']")
    private WebElement simpleParityOption;

    @FindBy(xpath = "//li[normalize-space()='2']")
    private WebElement parityOption;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    private WebElement saveBtn;

    @FindBy(xpath = "//li[contains(@class,'dropdown')]//a[@data-target='.modal-shortcut']")
    private WebElement profileLink;

    @FindBy(xpath = "//p[normalize-space()='Logout']")
    private WebElement logoutLink;

    public Doctor_Login(WebDriver driver) throws IOException {
        super(driver);
        ahelpLoginPage = new AHELP_LoginPage(driver);
    }

    public void loginAsDoctor() throws InterruptedException {
        click(loginLink);
        click(ahdOfficialsOption);
        String username = ConfigReader.getUsername("doctor");
        String password = ConfigReader.getPassword("doctor");
        sendKeys(ahdUsernameField, username);
        sendKeys(ahdPasswordField, password);
        click(ahdLoginSubmitButton);
    }

    public void editAge() throws InterruptedException {
        click(selectVeterinary);
        click(ownerAnimalMgmtLink);
        ahelpLoginPage.setRegisteredMobileNumber(
                ahelpLoginPage.getTestFarmerMobile());
        ahelpLoginPage.searchOwnerByMobile();
        click(viewProfileLink);
        click(editProfileButton);
        click(confirmEditButton);
        click(ownershipDropdown);
        click(selfOwnedOption);
        click(simpleParityOption);
        click(parityOption);
        sendKeys(dateOfBirthField, "09/04/2026");
        click(saveBtn);
        Thread.sleep(3000);
    }

    public void updateDateOfBirth(String newDate) throws InterruptedException {
        click(selectVeterinary);
        click(ownerAnimalMgmtLink);
        ahelpLoginPage.setRegisteredMobileNumber(
                ahelpLoginPage.getTestFarmerMobile());
        ahelpLoginPage.searchOwnerByMobile();
        click(viewProfileLink);
        click(editProfileButton);
        click(confirmEditButton);

        // Clear existing date and enter new date
        dateOfBirthField.clear();
        sendKeys(dateOfBirthField, newDate);

        click(saveBtn);
        waitForMilliseconds(2000);
        click(profileLink);
        click(logoutLink);
    }

    public String getUpdatedDateAfterEdit() throws InterruptedException {
        click(editProfileButton);
        click(confirmEditButton);
        return dateOfBirthField.getAttribute("value");
    }
}