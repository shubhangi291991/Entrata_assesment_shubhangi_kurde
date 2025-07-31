package Module1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntrataHomePage {
	WebDriver driver;

	WebDriverWait wait;

	// step1: declaration
	@FindBy(xpath = "//div[@class='nav_buttons']//a[text()=\"Sign in\"]")
	private WebElement signbtn;
	@FindBy(xpath = "//div[text()='Resident Login']")
	private WebElement Resident_login;
	
	@FindBy(xpath="//div[@class='nav_layout']//div[text()=\"Solutions\"]") private WebElement solutiontab;
	@FindBy(xpath = "//div[text()='Commercial']")
	private WebElement commericialbtn;

	// step2: initialization
	public EntrataHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clicksigninbtn() throws InterruptedException {
		signbtn.click();
		Thread.sleep(5000);

	}

	public void clickresident_loginbtn() {
		Resident_login.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void clickoncommericialbtn() {
		Actions action=new Actions(driver);
		action.moveToElement(solutiontab).perform();
		commericialbtn.click();
	}
}
