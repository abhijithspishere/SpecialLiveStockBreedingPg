package PageObjects;

import Utils.ConfigReader;
import Utils.ExcelUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class AHELP_LoginPage extends BasePage {

    private static String farmerFirstName;
    private static String farmerLastName;
    private static String farmerAddress;
    private static String farmerRationCardNumber;
    private static String farmerPincode;
    private static String farmerDateOfBirth;
    private static String calfPetName;
    private static String calfDateOfBirth;
    private static String calfIdentificationMark;
    private static String calfLength;
    private static String calfGirth;
    private static String enrollmentGirth;
    private static String enrollmentLength;
    private static String enrollmentRemarks;


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

    public AHELP_LoginPage(WebDriver driver) throws IOException {
        super(driver);
        loadExcelData();
    }

    private void loadExcelData() throws IOException {
        String filePath = "src/test/resources/testdata/test-data.xlsx";
        System.out.println("Loading Excel from: " + filePath);

        Object[][] farmerData = ExcelUtils.getTestData(filePath, "FarmerData");
        if (farmerData.length > 0) {
            farmerFirstName = (String) farmerData[0][0];
            farmerLastName = (String) farmerData[0][1];
            farmerAddress = (String) farmerData[0][2];
            farmerRationCardNumber = (String) farmerData[0][3];
            farmerPincode = (String) farmerData[0][4];
            farmerDateOfBirth = (String) farmerData[0][5];
        }


        Object[][] calfData = ExcelUtils.getTestData(filePath, "CalfData");
        if (calfData.length > 0) {
            calfPetName = (String) calfData[0][0];
            calfDateOfBirth = (String) calfData[0][1];
            calfIdentificationMark = (String) calfData[0][2];
        }


        Object[][] enrollmentData = ExcelUtils.getTestData(filePath, "EnrollmentData");
        if (enrollmentData.length > 0) {
            calfLength = (String) enrollmentData[0][0];
            calfGirth = (String) enrollmentData[0][1];
            enrollmentGirth = (String) enrollmentData[0][2];
            enrollmentLength = (String) enrollmentData[0][3];
            enrollmentRemarks = (String) enrollmentData[0][4];
        }

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
        registeredMobileNumber = getTestFarmerMobile(); // Mobile from config.properties
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
        registeredMobileNumber = getTestFarmerMobile(); // Mobile from config.properties

        click(clickHereLink);
        sendKeys(mobileNumberField, registeredMobileNumber);
        sendKeys(firstNameField, farmerFirstName);           // From Excel
        sendKeys(lastNameField, farmerLastName);             // From Excel
        sendKeys(addressField, farmerAddress);               // From Excel
        sendKeys(rationCardNumberField, farmerRationCardNumber); // From Excel
        sendKeys(pincodeField, farmerPincode);               // From Excel

        // These remain as direct interactions (not from Excel)
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

        sendKeys(dateOfBirthField, farmerDateOfBirth);       // From Excel
        click(dateOfBirthMay1Option);
        click(genderMaleRadioButton);
        click(dataConsentCheckbox);
        click(submitRegistrationButton);
        Thread.sleep(3000);
    }

    public void searchOwnerByMobile() throws InterruptedException {
        if (registeredMobileNumber != null) {
            sendKeys(searchOwner, registeredMobileNumber);
            click(searchBtn);
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

    public void newCalfReg() {
        click(viewProfileBtn);
        click(registerNewCalfBtn);
        click(damNotAvailableCheckbox);
        waitForPageLoad();

        String uniqueTag = RandomStringUtils.randomNumeric(12);
        sendKeys(earTagNumberField, uniqueTag);

        waitForElementToBeClickable(breedTypeCrossbredRadioButton);
        scrollToElement(breedTypeCrossbredRadioButton);
        clickWithJS(breedTypeCrossbredRadioButton);

        sendKeys(petNameField, calfPetName);                 // From Excel
        click(breedDropdown);
        click(holsteinFresianDropdown);
        sendKeys(calfDateOfBirthField, calfDateOfBirth);     // From Excel
        click(calfDateOfBirthMay7Option);
        click(colorDropdown);
        click(amberChampagneColorOption);
        sendKeys(identificationMarkField, calfIdentificationMark); // From Excel
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

        sendKeys(calfLengthField, calfLength);               // From Excel
        sendKeys(calfGirthField, calfGirth);                 // From Excel
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

        sendKeys(girthField, enrollmentGirth);               // From Excel
        sendKeys(lengthField, enrollmentLength);             // From Excel
        sendKeys(requestRemarksField, enrollmentRemarks);    // From Excel
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