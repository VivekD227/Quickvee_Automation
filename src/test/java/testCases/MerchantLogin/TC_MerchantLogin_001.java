//validate whether the merchant is going in proper page after clicking on merchant login or not

package testCases.MerchantLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.*;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_MerchantLogin_001 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com/");
	}
	
	@Test
	public void validatingCorrectPage() {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		customerLogin.merchantLoginClick();
		String originalWindow = driver.getWindowHandle();

		for(String windowHandle : driver.getWindowHandles()) {
			if(!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		
		String expectedUrl = "https://www.quickvee.com/merchants/login";
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		System.out.println("We are in Merchant Login Page");
		
		}
		
		
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
