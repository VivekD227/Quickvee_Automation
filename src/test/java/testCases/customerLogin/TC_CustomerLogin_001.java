//Validate whether the Quickvee logo, Customer Login text and welcome text is visible or not?

package testCases.customerLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_CustomerLogin_001 {

	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com/");
	}
	
	@Test
	public void quickveeLogoAndTextDisplayed() {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		Assert.assertTrue(customerLogin.quickveeLogoDisplay(), "Quickvee logo is not displayed");
		Assert.assertTrue(customerLogin.customerLoginTextDisplay(), "Customer Login text is not displayed");
		Assert.assertTrue(customerLogin.welcomeTextDisplay(), "Welcome Text is not displayed");
	
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
