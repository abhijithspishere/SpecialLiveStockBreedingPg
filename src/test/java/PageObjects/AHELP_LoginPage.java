package PageObjects;

import Utils.ConfigReader;
import Utils.ExcelUtils;
import Utils.FileConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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

    @FindBy(xpath = "//li[contains(@class,'select2-results__option') and text()='Palakkad']")
    private WebElement districtPathanamthittaOption;

    @FindBy(xpath = "//span[@id='select2-select-lgdType-container']")
    private WebElement localBodyTypeDropdown;

    @FindBy(xpath = "//li[normalize-space()='Panchayat']")
    private WebElement localBodyTypePanchayatOption;

    @FindBy(xpath = "//span[@id='select2-select-lgd-container']")
    private WebElement localBodyDropdown;

    @FindBy(xpath = "//li[contains(@class,'select2-results__option') and text()='Tarur']")
    private WebElement localBodyEnadimangalamOption;

    @FindBy(xpath = "//span[@id='select2-select-ward-container']")
    private WebElement wardDropdown;

    @FindBy(xpath = "//li[contains(@class,'select2-results__option') and text()='13 - TARUR']")
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

    @FindBy(xpath = "//a[normalize-space()='View']")
    private WebElement viewNewBtn;

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

    @FindBy(xpath = "//span[@aria-label='May 9, 2026']")
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

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addBank;

    @FindBy(xpath = "//input[@id='bankName']")
    private WebElement bankNameField;

    @FindBy(xpath = "//input[@id='accountNumber']")
    private WebElement accountNumberField;

    @FindBy(xpath = "//input[@id='ifscCode']")
    private WebElement ifscCodeField;

    @FindBy(xpath = "//input[@id='frmImages']")
    private WebElement passbookUploadField;

    @FindBy(xpath = "//button[@id='submitBankDetails']")
    private WebElement submitBankDetailsButton;

    @FindBy(xpath = "//button[@data-target='#agreementUploadModal']")
    private WebElement uploadSlbpbtn;

    @FindBy(xpath = "//input[@id='agreementFile']")
    private WebElement agreementUploadField;

    @FindBy(xpath = "//button[contains(text(),'Upload')]")
    private WebElement uploadAgreementButton;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    private WebElement updateApcosBtn;

    @FindBy(xpath = "//select[@id='apcosSelect']")
    private WebElement apcosDropdown;


    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveApcosBtn;

    @FindBy(xpath = "//a[normalize-space()='Update Activities']")
    private WebElement updateActivitiesBtn;

    @FindBy(xpath = "//input[@id='visitChecksVOData0.checkBoxValue1']")
    private WebElement secondVisitchk1;

    @FindBy(xpath = "//input[@id='visitChecksVOData1.checkBoxValue1']")
    private WebElement secondVisitchk2;

    @FindBy(xpath = "//input[@id='visitChecksVOData2.checkBoxValue1']")
    private WebElement secondVisitchk3;

    @FindBy(xpath = "//input[@id='visitChecksVOData3.checkBoxValue1']")
    private WebElement secondVisitchk4;

    @FindBy(xpath = "//input[@id='animalPhotoLeft']")
    private WebElement animalPhotoLeft;

    @FindBy(xpath = "//input[@id='animalPhotoFront']")
    private WebElement animalPhotoFront;

    @FindBy(xpath = "//input[@id='animalPhotoRight']")
    private WebElement animalPhotoRight;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submit2ndVisitBtn;

    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    private WebElement updateActivityErrorMessage;

    @FindBy(xpath = "//input[@id='pubYes22']")
    private WebElement pubertyYesBtn;

    @FindBy(xpath = "//span[contains(@class,'flatpickr-day today')]")
    private WebElement todayDate;

    @FindBy(xpath = "//input[@id='pubertyDate']")
    private WebElement pubertyDateField;


    private String registeredMobileNumber;

    public AHELP_LoginPage(WebDriver driver) throws IOException {
        super(driver);
        loadExcelData();
    }

    private void loadExcelData() throws IOException {

    String filePath = "src/test/resources/testdata/test-data.xlsx";

    // ================= FARMER DATA =================

    Object[][] farmerData = ExcelUtils.getTestData(filePath, "FarmerData");
    if (farmerData.length > 0) {
        farmerFirstName = String.valueOf(farmerData[0][0]);
        farmerLastName = String.valueOf(farmerData[0][1]);
        farmerAddress = String.valueOf(farmerData[0][2]);
        farmerRationCardNumber = String.valueOf(farmerData[0][3]);
        farmerPincode = String.valueOf(farmerData[0][4]);

        // DATE FORMAT FIX
        Object dobObj = farmerData[0][5];
        if (dobObj instanceof java.util.Date) {
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("dd-MM-yyyy");
            farmerDateOfBirth = sdf.format((java.util.Date) dobObj);
        } else {

            farmerDateOfBirth = dobObj.toString();
        }
    }

    // ================= CALF DATA =================

    Object[][] calfData = ExcelUtils.getTestData(filePath, "CalfData");
    if (calfData.length > 0) {
        calfPetName = String.valueOf(calfData[0][0]);

        // DATE FORMAT FIX
        Object calfDobObj = calfData[0][1];
        if (calfDobObj instanceof java.util.Date) {
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("dd-MM-yyyy");
            calfDateOfBirth = sdf.format((java.util.Date) calfDobObj);

        } else {
            calfDateOfBirth = calfDobObj.toString();

        }
        calfIdentificationMark = String.valueOf(calfData[0][2]);
    }


    Object[][] enrollmentData =
            ExcelUtils.getTestData(filePath, "EnrollmentData");

    if (enrollmentData.length > 0) {
        calfLength = String.valueOf(enrollmentData[0][0]);
        calfGirth = String.valueOf(enrollmentData[0][1]);
        enrollmentGirth = String.valueOf(enrollmentData[0][2]);
        enrollmentLength = String.valueOf(enrollmentData[0][3]);
        enrollmentRemarks = String.valueOf(enrollmentData[0][4]);
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

    public void showLogin(String username, String password) throws InterruptedException {

        selectAHELPRole();
        enterUsername(username);
        enterPassword(password);
        submitLogin();
        waitForPageLoad();
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

        registeredMobileNumber = getTestFarmerMobile();

        click(clickHereLink);

        // Farmer Details
        sendKeys(mobileNumberField, registeredMobileNumber);
        sendKeys(firstNameField, farmerFirstName);
        sendKeys(lastNameField, farmerLastName);
        sendKeys(addressField, farmerAddress);
        sendKeys(rationCardNumberField, farmerRationCardNumber);
        sendKeys(pincodeField, farmerPincode);

        // Reservation Category
        click(reservationCategoryDropdown);
        click(reservationCategoryGeneralOption);

        // District
        click(districtDropdown);
        click(districtPathanamthittaOption);

        // Local Body Type
        click(localBodyTypeDropdown);
        click(localBodyTypePanchayatOption);

        // Local Body
        click(localBodyDropdown);
        click(localBodyEnadimangalamOption);

        // Ward
        click(wardDropdown);
        click(wardMangaduVadakOption);


        JavascriptExecutor js = (JavascriptExecutor) driver;
        String formattedDOB = farmerDateOfBirth.trim();

        click(dateOfBirthField);

        Thread.sleep(1000);

        // Set Flatpickr date properly
        js.executeScript(
                "arguments[0]._flatpickr.setDate(arguments[1], true, 'd-m-Y')",
                dateOfBirthField,
                formattedDOB
        );

        Thread.sleep(1000);
        click(genderMaleRadioButton);
        click(dataConsentCheckbox);
        click(submitRegistrationButton);
        Thread.sleep(3000);
    }

    private WebDriverWait wait;

    public void addBankDetails() {
        click(addBank);

        sendKeys(bankNameField, "State Bank of India");
        sendKeys(accountNumberField, RandomStringUtils.randomNumeric(16));
        sendKeys(ifscCodeField, "SBIN0001234");
        sendKeys(passbookUploadField, FileConstants.MAXRES_PDF);

        click(submitBankDetailsButton);
        acceptAlert();
    }

    public void SecondVisitUpdate() throws InterruptedException {
        loginAndOpensecond();
        addBankDetails();
        uploadAgreement();
        updateApcos();
        Thread.sleep(2000);
        updateActivities("65", "85");
    }

    public void thirdVisitUpdate() throws InterruptedException {
        loginAndOpenProfile();
        click(viewNewBtn);
        updateActivities("90", "110");
    }
    public void fifthVisitUpdate() throws InterruptedException {
        loginAndOpenProfile();
        click(viewNewBtn);
        List<WebElement> fifthVisitCheckboxes = Arrays.asList(
                secondVisitchk1,
                secondVisitchk2
        );
        updateActivitiesNew("120", "140", fifthVisitCheckboxes);
    }

    public void sixthVisitUpdate() throws InterruptedException {
        loginAndOpenProfile();
        click(viewNewBtn);
        List<WebElement> sixthVisitCheckboxes = Arrays.asList(
                secondVisitchk1
        );
        updateActivitiesNew("140", "160", sixthVisitCheckboxes);
    }

    public void eighthVisitUpdate() throws InterruptedException {
        loginAndOpenProfile();
        click(viewNewBtn);
        List<WebElement> sixthVisitCheckboxes = Arrays.asList(
                secondVisitchk1
        );
        updateActivitiesPuberty("200", "250", sixthVisitCheckboxes);
    }

    public boolean fourthVisitRestrict() throws InterruptedException {

        loginAndOpensecond();


        scrollToElement(viewNewBtn);
        clickWithJS(viewNewBtn);
        if(updateActivityErrorMessage.isDisplayed()) {
            System.out.println("Ahelp user is restricted from updating 4th visit activities as expected: " + updateActivityErrorMessage.getText());
            return true;
        } else {
            System.out.println("Error message not displayed when it should be.");
            return false;
        }
    }

    private void updateFourthvisit(String girth, String length)
            throws InterruptedException {
        click(secondVisitchk1);
        click(secondVisitchk2);
        click(secondVisitchk3);
        sendKeys(girthField, girth);
        sendKeys(lengthField, length);
        waitForMilliseconds(2000);
        sendKeys(animalPhotoLeft, FileConstants.cowLeftpng);
        sendKeys(animalPhotoFront, FileConstants.cowFrontpng);
        sendKeys(animalPhotoRight, FileConstants.cowRightpng);
        click(submit2ndVisitBtn);
    }

    public void FourthVisitUpdate() throws InterruptedException {

        updateFourthvisit("95", "120");
    }

    public void verifyUpdateActivity() throws InterruptedException {
        if(updateActivityErrorMessage.isDisplayed()) {
            System.out.println("Error message displayed as expected: " + updateActivityErrorMessage.getText());
        } else {
            System.out.println("Error message not displayed when it should be.");
        }
    }

    private void updateActivities(String girth, String length)
            throws InterruptedException {
        click(updateActivitiesBtn);
        click(secondVisitchk1);
        click(secondVisitchk2);
        click(secondVisitchk3);
        click(secondVisitchk4);
        sendKeys(girthField, girth);
        sendKeys(lengthField, length);
        waitForMilliseconds(2000);
        sendKeys(animalPhotoLeft, FileConstants.cowLeftpng);
        sendKeys(animalPhotoFront, FileConstants.cowFrontpng);
        sendKeys(animalPhotoRight, FileConstants.cowRightpng);
        Thread.sleep(2000);
        clickWithJS(submit2ndVisitBtn);
        verifyUpdateActivity();
    }


   /* private void updateActivitiesPuberty(String girth,
                                     String length,
                                     List<WebElement> checkboxes)
            throws InterruptedException {

        click(updateActivitiesBtn);

        for (WebElement checkbox : checkboxes) {
            click(checkbox);
        }

        sendKeys(girthField, girth);
        sendKeys(lengthField, length);

        waitForMilliseconds(2000);

        sendKeys(animalPhotoLeft, FileConstants.cowLeftpng);
        sendKeys(animalPhotoFront, FileConstants.cowFrontpng);
        sendKeys(animalPhotoRight, FileConstants.cowRightpng);

        Thread.sleep(2000);
        click(pubertyYesBtn);
        click(pubertyDateField);
        click(todayDate);
        clickWithJS(submit2ndVisitBtn);
        verifyUpdateActivity();

    }*/

    private void updateActivitiesPuberty(String girth,
                                         String length,
                                         List<WebElement> checkboxes)
            throws InterruptedException {

        click(updateActivitiesBtn);

        for (WebElement checkbox : checkboxes) {
            click(checkbox);
        }

        sendKeys(girthField, girth);
        sendKeys(lengthField, length);

        waitForMilliseconds(2000);

        sendKeys(animalPhotoLeft, FileConstants.cowLeftpng);
        sendKeys(animalPhotoFront, FileConstants.cowFrontpng);
        sendKeys(animalPhotoRight, FileConstants.cowRightpng);

        Thread.sleep(2000);

        click(pubertyYesBtn);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String pubertyDate = "10-02-2026";

        click(pubertyDateField);

        js.executeScript(
                "arguments[0]._flatpickr.setDate(arguments[1], true, 'd-m-Y')",
                pubertyDateField,
                pubertyDate
        );

        clickWithJS(submit2ndVisitBtn);

        verifyUpdateActivity();
    }


    private void updateActivitiesNew(String girth,
                                     String length,
                                     List<WebElement> checkboxes)
            throws InterruptedException {

        click(updateActivitiesBtn);

        for (WebElement checkbox : checkboxes) {
            click(checkbox);
        }

        sendKeys(girthField, girth);
        sendKeys(lengthField, length);

        waitForMilliseconds(2000);

        sendKeys(animalPhotoLeft, FileConstants.cowLeftpng);
        sendKeys(animalPhotoFront, FileConstants.cowFrontpng);
        sendKeys(animalPhotoRight, FileConstants.cowRightpng);

        Thread.sleep(2000);

        clickWithJS(submit2ndVisitBtn);

        verifyUpdateActivity();
    }






    private void loginAndOpensecond() throws InterruptedException {
        loginAsAHELP(
                ConfigReader.getUsername("ahelp"),
                ConfigReader.getPassword("ahelp")
        );
        newSlbpProfile();
        click(searchOwner);
        registeredMobileNumber = getTestFarmerMobile();
        searchOwnerByMobile();
        click(viewProfileBtn);
    }

    private void loginAndOpenProfile() throws InterruptedException {
        showLogin(
                ConfigReader.getUsername("ahelp"),
                ConfigReader.getPassword("ahelp")
        );
        newSlbpProfile();
        click(searchOwner);
        registeredMobileNumber = getTestFarmerMobile();
        searchOwnerByMobile();
        click(viewProfileBtn);
    }

    private void uploadAgreement() throws InterruptedException {
        click(viewNewBtn);
        Thread.sleep(2000);
        click(uploadSlbpbtn);
        sendKeys(agreementUploadField, FileConstants.sampleSLBPDF);
        click(uploadAgreementButton);
        acceptAlert();
    }

    private void updateApcos() {
        click(updateApcosBtn);
        Select select = new Select(apcosDropdown);
        select.selectByIndex(1);

        click(saveApcosBtn);
        acceptAlert();
    }

    protected void acceptAlert() {

        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();
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

    public void newCalfReg() throws InterruptedException {

        click(viewProfileBtn);

        click(registerNewCalfBtn);

        click(damNotAvailableCheckbox);

        waitForPageLoad();

        String uniqueTag = RandomStringUtils.randomNumeric(12);

        sendKeys(earTagNumberField, uniqueTag);

        waitForElementToBeClickable(breedTypeCrossbredRadioButton);

        scrollToElement(breedTypeCrossbredRadioButton);

        clickWithJS(breedTypeCrossbredRadioButton);

        sendKeys(petNameField, calfPetName);

        click(breedDropdown);

        click(holsteinFresianDropdown);

        // ================= CALF DATE OF BIRTH =================

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String formattedCalfDOB = calfDateOfBirth.trim();

        click(calfDateOfBirthField);

        Thread.sleep(1000);

        // Set Flatpickr date properly
        js.executeScript(
                "arguments[0]._flatpickr.setDate(arguments[1], true, 'd-m-Y')",
                calfDateOfBirthField,
                formattedCalfDOB
        );
        js.executeScript(
                "arguments[0]._flatpickr.close()",
                calfDateOfBirthField
        );
        Thread.sleep(1000);

        click(colorDropdown);

        click(amberChampagneColorOption);

        sendKeys(identificationMarkField, calfIdentificationMark);

        click(calfDataConsentCheckbox);

        click(submitCalfRegistrationButton);
    }

    // Add this method to your AHELP_LoginPage class
    public String getCalfDateOfBirth() {
        return calfDateOfBirth;  // This is already loaded from Excel
    }

    public String newCalfRegAndGetAlert() throws InterruptedException {
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