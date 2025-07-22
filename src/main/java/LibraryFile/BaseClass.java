package LibraryFile;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.*;

 
 

public class BaseClass {
    protected WebDriver driver;

    
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    
    
    @BeforeClass
    @Parameters("appUrl")
    public void setup(@Optional("https://www.entrata.com") String appUrl) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appUrl);
    }

   @AfterClass
    public void tearDown() {
    	if (driver != null) {
            driver.quit();
        }
    }
    

   @AfterSuite
   public void flushReport() {
       extent.flush();
   }
}
