package ths_Book_roll_out;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class MH {
    public static void main(String[] args) {
        // Use WebDriverManager to automatically download and manage the ChromeDriver executable
        WebDriverManager.chromedriver().setup();

        // Create a Chrome WebDriver instance
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Load Excel spreadsheet
        String excelFilePath = "path/to/api_data.xlsx";
        try (FileInputStream fis = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            // Rest of your code remains the same
            // ...
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver instance when done
            driver.quit();
        }
    }
}
