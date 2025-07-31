package Module1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntrataHomePage {
    WebDriver driver;


    WebDriverWait wait;

	

	//step1: declaration
	@FindBy(xpath="(//a[text()='Sign in'])[2]") private WebElement signbtn;
	@FindBy(xpath="//div[text()='Resident Login']") private WebElement Resident_login;
	@FindBy(xpath="//div[text()='Commercial']") private WebElement commericialbtn;
 	
	//step2: initialization
	public EntrataHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	 
	
	public void clicksigninbtn() throws InterruptedException 
	{
		signbtn.click();
		
		Thread.sleep(5000);
	
	}
	public void clickresident_loginbtn()
	{
		Resident_login.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	public void clickoncommericialbtn()
	
	
	{
		commericialbtn.click();
	}
}
                                                                                                                                          