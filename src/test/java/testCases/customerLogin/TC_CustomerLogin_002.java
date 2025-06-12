//Validate 'Forgotten Password' link is available in the Login page and is working and it is clickable
package testCases.customerLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_CustomerLogin_002 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.quickvee.com/");
	}
	
	@Test(priority = 1)
	public void forgotPasswordTextClass() {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		Assert.assertTrue(customerLogin.forgotPasswordDisplay(), "Forgot Password is not displayed");
	}
	
	@Test(priority = 2)
	public void forgotPasswordClickable() {
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		customerLogin.forgotPasswordClick();
		
		String expectedUrl = "https://www.quickvee.com/forgot-password";
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		Assert.assertTrue(customerLogin.isInForgotPasswordPage(), "Not in Forgot Password Page");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
