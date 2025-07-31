package Module1_Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import LibraryFile.BaseClass;
import LibraryFile.UtilityClass;
import Module1.EntrataHomePage;
import Module1.EntrataLoginPage;


 

public class EntrataHomeTestPage extends BaseClass {

	int TCID;
	//WebDriver driver;
	
	
	 EntrataHomePage Home;
	 EntrataLoginPage login;
	 

	 @Test(priority = 1)
	    public void verifyHomePageTitle() {
		 String expectedTitle = "Property Management Software | Entrata®";
	        String actualTitle = driver.getTitle();
	        System.out.println(actualTitle);
	        Assert.assertEquals(actualTitle, expectedTitle);
		
	    }
	 
	 @Test(priority = 2)
		public void navigate_to_signup() throws InterruptedException
		{
		 Home=new EntrataHomePage(driver);
		 Home.clicksigninbtn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

			Home.clickresident_loginbtn();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	 
		}
	 
	 @Test(priority = 3)
	 public void logintoapp() throws IOException 
	 {
		 login=new EntrataLoginPage(driver);
		 login.EntrataLoginPageUsername(UtilityClass.getPFData("UN"));
			login.EntrataLoginPagePassword(UtilityClass.getPFData("PSW"));
			login.clickEntrataLoginPageLoginBtn();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));
			
	 }
	 
	 @Test(priority = 4)
	 public void verifyerrormessage() throws EncryptedDocumentException, IOException
	 {
			String actualerrorText=login.getErrormessage();
			String expeerrorText=UtilityClass.getTD(0,0);
			Assert.assertEquals(actualerrorText, expeerrorText,"Failed: - both results are diff:   ");
	 }
	 
	 @Test(priority=5)
	 public void verifycommertest()
	 
	 {
		 
		Home.clickoncommericialbtn();
	 }
	 
		@AfterMethod
	 public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException
		{
			 TCID=101;

			if (s1.getStatus()==ITestResult.FAILURE) 
			{
				UtilityClass.captureSS(driver, TCID);
			}
			
			 
		}
	 
	 
		}
	 
	 
