package UW_UPDATE_360Value_Automate;


import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import com.ths.actiondriver.Action;
import com.bdd.variables.API_Constant_Values;
import pageObjects.WebDriverManager;
import utilities.ExcelUtils;

public class UW_Automation_UPDate360Value extends ExcelUtils {
    private static WebDriver driver;
    private static final String CHROME_DRIVER_PATH = "C:\\Users\\vdaru\\eclipse-workspace\\chromedriver.exe";
    private static final String URL = "https://oasis.red.thig.com";
    
    public static void main(String[] args) {
        try {
            initializeDriver();
            loginToWebsite();
            
            processPolicies();

            cleanup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private static void loginToWebsite() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(1000);
        
        // Login
        safeSendKeys(By.id("inputGroupID"), "THIG");
        safeSendKeys(By.id("inputUserName"), "Vdaru");
        safeSendKeys(By.id("inputPassword"), "1Password");
        
        safeClick(By.id("authSubmit"));
        
        handleOptionalElements(By.xpath("//*[@id='application-container']/div[2]/div/div/div/form/button"));
        handleOptionalElements(By.xpath("//*[@id='submit']"));
        handleOptionalElements(By.id("motd-dialog-close"));
    }

    private static void processPolicies() {
        // ... [Rest of the policy processing logic goes here]
    }
    
    private static void cleanup() {
        if (driver != null) {
            driver.close();
        }
    }
    
    private static void handleOptionalElements(By by) throws InterruptedException {
        List<WebElement> elements = driver.findElements(by);
        if (!elements.isEmpty()) {
            elements.get(0).click();
            Thread.sleep(1000);
        }
    }

    private static void safeSendKeys(By by, String text) throws InterruptedException {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
        Thread.sleep(1000);
    }

    private static void safeClick(By by) throws InterruptedException {
        driver.findElement(by).click();
        Thread.sleep(1000);
    }
    
    // ... [Rest of the helper methods and classes]
}
