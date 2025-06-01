package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Customer Login']")
	WebElement isRegisterDisplay;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now']")
	WebElement storeLoginBtn;
	
	public void isRegisterPage() {
		boolean isDisplayedRegister = isRegisterDisplay.isDisplayed();
		if(isDisplayedRegister) {
			System.out.println("We Clicked on Login Button");

			System.out.println("We are in Home Register Page");
			Assert.assertTrue(isDisplayedRegister);
		}
		else {
			Assert.assertTrue(false);

		}
	}
	
	
	public void RegisterBtnClick() {
		storeLoginBtn.click();
		System.out.println("User is click on Register button to create a New user");
	}
	
}
