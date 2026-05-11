package PageObjects;

import Utils.ConfigReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AHELP_LoginPage extends BasePage {

    // The main LOGIN button on the home page
    @FindBy(xpath = "//a[normalize-space()='LOGIN']")
    private WebElement loginMainButton;

    // Radio button for AHELP role
    @FindBy(xpath = "//input[@id='exampleRadios4']")
    private WebElement ahelpRadioButton;

    // Username field (appears after clicking LOGIN)
    @FindBy(xpath = "//input[@id='tempid']")
    private WebElement usernameField;

    // Password field
    @FindBy(xpath = "//input[@id='inputPasswordOther']")
    private WebElement passwordField;

    // Submit button
    @FindBy(xpath = "(//button[@type='submit' and text()='Let me in'])[2]")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//a[@href='/navigation/slbp']")
    private WebElement slbpLink;

    @FindBy(xpath = "//span[normalize-space()='Farmer / Animal Registration']")
    private WebElement newFarmerAnimalRegistrationLink;

    @FindBy(xpath = "//a[normalize-space()='click here']")
    private WebElement clickHereLink;

    @FindBy(xpath = "//input[@id='mob']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@id='rationNo']")
    private WebElement rationCardNumberField;

    @FindBy(xpath = "//input[@id='pincode']")
    private WebElement pincodeField;

    @FindBy(xpath = "//span[@id='select2-reservationCategory-container']")
    private WebElement reservationCategoryDropdown;

    @FindBy(xpath = "//li[normalize-space()='General']")
    private WebElement reservationCategoryGeneralOption;

    @FindBy(xpath = "//span[@id='select2-select-district-container']")
    private WebElement districtDropdown;

    @FindBy(xpath = "//li[normalize-space()='Pathanamthitta']")
    private WebElement districtPathanamthittaOption;

    @FindBy(xpath = "//span[@id='select2-select-lgdType-container']")
    private WebElement localBodyTypeDropdown;

    @FindBy(xpath = "//li[normalize-space()='Panchayat']")
    private WebElement localBodyTypePanchayatOption;

    @FindBy(xpath = "//span[@id='select2-select-lgd-container']")
    private WebElement localBodyDropdown;

    @FindBy(xpath = "//li[text()='Mezhuveli']")
    private WebElement localBodyEnadimangalamOption;

    @FindBy(xpath = "//span[@id='select2-select-ward-container']")
    private WebElement wardDropdown;

    @FindBy(xpath = "//li[text()='12 - MEZHUVELI']")
    private WebElement wardMangaduVadakOption;

    @FindBy(xpath = "//input[@id='dateOfBirth']")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//span[@aria-label='May 1, 2020']")
    private WebElement dateOfBirthMay1Option;

    @FindBy(xpath = "//input[@id='gender1']")
    private WebElement genderMaleRadioButton;

    @FindBy(xpath = "//label[@for='dataConsent']")
    private WebElement dataConsentCheckbox;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    private WebElement submitRegistrationButton;

    /////////////////////Calf Registration Elements/////////////////////
    @FindBy(xpath = "//input[@id='searchCrit']")
    private WebElement searchOwner;

    @FindBy(xpath = "//button[@id='button-addon2']")
    private WebElement searchBtn;

    @FindBy(xpath = "//a[normalize-space()='View Profile']")
    private WebElement viewProfileBtn;

    @FindBy(xpath = "//a[normalize-space()='Register New Calf']")
    private WebElement registerNewCalfBtn;

    @FindBy(xpath = "//input[@id='damNotAvailable']")
    private WebElement damNotAvailableCheckbox;

    @FindBy(xpath = "//input[@id='earTagNo']")
    private WebElement earTagNumberField;

    @FindBy(xpath = "//input[@id='breedType1']")
    private WebElement breedTypeCrossbredRadioButton;

    @FindBy(xpath = "//div[@id='divPetName']//input[@id='petName']")
    private WebElement petNameField;

    @FindBy(xpath = "//span[@id='select2-select-breed-container']")
    private WebElement breedDropdown;

    @FindBy(xpath = "//li[normalize-space()='Holstein Fresian']")
    private WebElement holsteinFresianDropdown;

    @FindBy(xpath = "//input[@id='calfDateOfBirth']")
    private WebElement calfDateOfBirthField;

    @FindBy(xpath = "//span[@aria-label='May 7, 2026']")
    private WebElement calfDateOfBirthMay7Option;

    @FindBy(xpath = "//span[@id='select2-select-colors-container']")
    private WebElement colorDropdown;

    @FindBy(xpath = "//li[normalize-space()='Amber champagne']")
    private WebElement amberChampagneColorOption;

    @FindBy(xpath = "//input[@id='identificationMark']")
    private WebElement identificationMarkField;

    @FindBy(xpath = "//label[normalize-space()='Obtained informed consent.']")
    private WebElement calfDataConsentCheckbox;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    private WebElement submitCalfRegistrationButton;

    /// ///////////////////////////////////////
    /// Calf Enrollment Elements
    @FindBy(xpath = "//a[normalize-space()='Request Enrolment']")
    private WebElement requestEnrolmentBtn;

    @FindBy(xpath = "//button[@id='calvingDtlsButton']")
    private WebElement calvingDetailsButton;

    @FindBy(xpath = "//select[@id='calvingEase']")
    private WebElement calvingEaseRadioButton;

    @FindBy(xpath = "//select[@id='calvingEase']/option[normalize-space()='Normal']")
    private WebElement calvingEaseNormalOption;

    @FindBy(xpath = "//input[@id='calf1Length']")
    private WebElement calfLengthField;

    @FindBy(xpath = "//input[@id='calf1Girth']")
    private WebElement calfGirthField;

    @FindBy(xpath = "//button[@id='saveCalvingDtlsBtn']")
    private WebElement saveCalvingDetailsButton;

    @FindBy(xpath = "//select[@id='schemeSelect']")
    private WebElement schemeDropdown;

    @FindBy(xpath = "//select[@id='schemeSelect']/option[normalize-space()='Govardhini 2024-25']")
    private WebElement govardhiniSchemeDropdown;

    @FindBy(xpath = "//input[@id='visitChecksVOData0.checkBoxValue1']")
    private WebElement checksVOData0Checkbox;

    @FindBy(xpath = "//input[@id='visitChecksVOData1.checkBoxValue1']")
    private WebElement checksVOData1Checkbox;

    @FindBy(xpath = "//input[@id='visitChecksVOData2.checkBoxValue1']")
    private WebElement checksVOData2Checkbox;

    @FindBy(xpath = "//input[@id='visitChecksVOData3.checkBoxValue1']")
    private WebElement checksVOData3Checkbox;

    @FindBy(xpath = "//input[@id='girth']")
    private WebElement girthField;

    @FindBy(xpath = "//input[@id='length']")
    private WebElement lengthField;

    @FindBy(xpath = "//textarea[@id='requestRemarks']")
    private WebElement requestRemarksField;

    @FindBy(xpath = "//input[@id='requestConfirm']")
    private WebElement requestConfirmCheckbox;

    @FindBy(xpath = "//button[@id='submitRequest']")
    private WebElement submitRequestButton;

    @FindBy(xpath = "//h2[@class='text-success' and contains(text(),'Enrollment Request Submitted')]")
    private WebElement enrollmentSuccessMessage;

    @FindBy(xpath = "//span[@id='mobError']")
    private WebElement mobileNumberErrorMessage;

    private String registeredMobileNumber;

    public AHELP_LoginPage(WebDriver driver) {
        super(driver);
    }
    public void clickMainLoginButton() {
        click(loginMainButton);
    }
    public void selectAHELPRole() {
        click(ahelpRadioButton);
    }
    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }
    public void enterPassword(String password) throws InterruptedException {
        sendKeys(passwordField, password);
//        Thread.sleep(2000);
    }
    public void submitLogin() {
        click(loginSubmitButton);
    }
    public void loginAsAHELP(String username, String password) throws InterruptedException {
        clickMainLoginButton();
        selectAHELPRole();
        enterUsername(username);
        enterPassword(password);
        submitLogin();
        waitForPageLoad();
    }

    public void newSlbpProfile() throws InterruptedException {
        click(slbpLink);
        click(newFarmerAnimalRegistrationLink);
    }

    public void addFarmerDuplicateMobile() throws InterruptedException {
        registeredMobileNumber = getTestFarmerMobile();
        click(clickHereLink);
        sendKeys(mobileNumberField, registeredMobileNumber);
        click(firstNameField);
    }
    public String getMobileNumberError() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mobileNumberErrorMessage));
        return mobileNumberErrorMessage.getText();
    }

    public void addFarmer() throws InterruptedException {

        registeredMobileNumber = getTestFarmerMobile(); // Store the mobile number for later use in calf registration
        click(clickHereLink);
        sendKeys(mobileNumberField,registeredMobileNumber);
        sendKeys(firstNameField,"Sameer");
        sendKeys(lastNameField,"Saleem");
        sendKeys(addressField,"Anchal, Pathanamthitta");
        sendKeys(rationCardNumberField,"1234567897");
        sendKeys(pincodeField,"123456");
        click(reservationCategoryDropdown);
        click(reservationCategoryGeneralOption);
        click(districtDropdown);
        click(districtPathanamthittaOption);
        click(localBodyTypeDropdown);
        click(localBodyTypePanchayatOption);
        click(localBodyDropdown);
        click(localBodyEnadimangalamOption);
        click(wardDropdown);
        click(wardMangaduVadakOption);
        sendKeys(dateOfBirthField,"01/05/2020");
        click(dateOfBirthMay1Option);
        click(genderMaleRadioButton);
        click(dataConsentCheckbox);
        click(submitRegistrationButton);
        Thread.sleep(3000);
    }

    public void searchOwnerByMobile() throws InterruptedException {
        if (registeredMobileNumber != null) {
            sendKeys(searchOwner, registeredMobileNumber);
            click((searchBtn));
            Thread.sleep(2000);
        } else {
            throw new IllegalStateException("No mobile number stored. Please register a farmer first.");
        }
    }


    public String getTestFarmerMobile() {
        return ConfigReader.getProperty("test.farmer.mobile");
    }

    public void setRegisteredMobileNumber(String mobile) {
        this.registeredMobileNumber = mobile;
    }

    public void newCalfReg(){
        click(viewProfileBtn);
        click(registerNewCalfBtn);
        click(damNotAvailableCheckbox);
        waitForPageLoad();
        String uniqueTag = RandomStringUtils.randomNumeric(12);
        sendKeys(earTagNumberField, uniqueTag);

        waitForElementToBeClickable(breedTypeCrossbredRadioButton);
        scrollToElement(breedTypeCrossbredRadioButton);
        clickWithJS(breedTypeCrossbredRadioButton);

        sendKeys(petNameField,"Lucky");
        click(breedDropdown);
        click(holsteinFresianDropdown);
        sendKeys(calfDateOfBirthField,"07/05/2026");
        click(calfDateOfBirthMay7Option);
        click(colorDropdown);
        click(amberChampagneColorOption);
        sendKeys(identificationMarkField,"Small scar on left ear");
        click(calfDataConsentCheckbox);
        click(submitCalfRegistrationButton);
    }
    public String newCalfRegAndGetAlert() {
        newCalfReg();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        alert.accept();
        return msg;
    }

    public void requestCalfEnrollment() throws InterruptedException {
        click(viewProfileBtn);
        click(requestEnrolmentBtn);
        click(calvingDetailsButton);
        click(calvingEaseRadioButton);
        click(calvingEaseNormalOption);
        sendKeys(calfLengthField,"50");
        sendKeys(calfGirthField,"30");
        click(saveCalvingDetailsButton);
        try {
            click(schemeDropdown);
        } catch (ElementClickInterceptedException e) {

            scrollToElement(schemeDropdown);

            clickWithJS(schemeDropdown);
        }
        click(govardhiniSchemeDropdown);
        click(checksVOData0Checkbox);
        click(checksVOData1Checkbox);
        click(checksVOData2Checkbox);
        click(checksVOData3Checkbox);
        sendKeys(girthField,"30");
        sendKeys(lengthField,"50");
        sendKeys(requestRemarksField,"Requesting enrollment for the newly registered calf.");
        click(requestConfirmCheckbox);
        click(submitRequestButton);
    }

    public String getEnrollmentSuccessMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(enrollmentSuccessMessage));
        return enrollmentSuccessMessage.getText();
    }

    public void loginWithConfigCredentials() throws InterruptedException {
        String username = ConfigReader.getUsername("ahelp");
        String password = ConfigReader.getPassword("ahelp");
        loginAsAHELP(username, password);
    }
}