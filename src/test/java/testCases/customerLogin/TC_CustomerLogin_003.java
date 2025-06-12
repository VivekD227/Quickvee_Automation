//"Validate whether the ""Or Sign in with"" text is visible or not

package testCases.customerLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_CustomerLogin_003 {

	WebDriver driver;
	
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.quickvee.com/");
	}
	
	public void orSignInClass() {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		Assert.assertTrue(customerLogin.orSignInTextDisplay(), "Sign In text is not visible");
	}
	public void tearDown() {
		driver.quit();
	}
	
}
