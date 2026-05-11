package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    // Default explicit wait timeout in seconds – change here if needed
    private static final int EXPLICIT_WAIT_TIMEOUT = 20;

    // Optional: Later you can replace the line above with a value from ConfigReader:
    // private static final int EXPLICIT_WAIT_TIMEOUT = ConfigReader.getExplicitWait();
    // (You would need to add getExplicitWait() to ConfigReader first)

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // ---------- Element interaction with waits ----------

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected String getAttribute(WebElement element, String attribute) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getAttribute(attribute);
    }

    // ---------- Verification / state checks ----------

    protected boolean isDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isEnabled(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isSelected(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    // ---------- Explicit waiting helpers ----------

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForInvisibility(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    // Alternative name for the same
    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForPageLoad() {
        wait.until(webDriver ->
                js.executeScript("return document.readyState").equals("complete"));
    }

    // Short static sleep – use sparingly
    protected void waitForMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ---------- JavaScript utilities ----------

    protected void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0)");
    }

    protected void clickWithJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    protected void sendKeysWithJS(WebElement element, String text) {
        js.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    protected void highlightElement(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // ---------- Window / tab handling ----------

    protected void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    protected void switchToWindow(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        if (index < windows.size()) {
            driver.switchTo().window(windows.get(index));
        }
    }

    protected void closeCurrentWindowAndSwitchBack() {
        String currentWindow = driver.getWindowHandle();
        driver.close();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!currentWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    protected String getCurrentWindowHandle() {
        return driver.getWindowHandle();
    }

    protected List<String> getAllWindowHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    // ---------- Alert handling ----------

    protected void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    protected String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    protected void sendKeysToAlert(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
    }

    // ---------- Frame handling ----------

    protected void switchToFrame(WebElement frameElement) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    protected void switchToFrame(int index) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}