package Module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrataLoginPage {

	//Step1: declaration
	
	@FindBy(xpath="(//div[@class='right-content light-mode']//input[@name='email'])[1]") private WebElement UN;
	@FindBy(xpath="(//div[@class='right-content light-mode']//input[@name='password'])[1]") private WebElement PSW;
	@FindBy(xpath="//button[@data-text='login']") private WebElement LoginBTN;
	@FindBy(xpath="(//span[@class='error-message translate ng-binding'])[1]") private WebElement Errmsg;
	WebDriver driver;
		
		//step2: initialization
		public EntrataLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);   //className.methodName(WebDriverObject, this);
			this.driver=driver;
		}
		
		//step3: usage
		public void EntrataLoginPageUsername(String username) 
		{
			UN.sendKeys(username);            
		}
		
		public void EntrataLoginPagePassword(String password) 
		{
			PSW.sendKeys(password);
		}
		
		public void clickEntrataLoginPageLoginBtn()
		{
			LoginBTN.click();
		}
		
		
		public String getErrormessage()
		{
			String actText = Errmsg.getText();
			return actText;
		}
	
}
