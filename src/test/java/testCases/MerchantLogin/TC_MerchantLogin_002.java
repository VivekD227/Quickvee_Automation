//Validate whether the quickvee logo is displayed or not

package testCases.MerchantLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;
import pageObjects.MerchantLogin;

@Listeners(utilities.TestListener.class)

public class TC_MerchantLogin_002 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com/");

	}
	@Test
	public void quickveeLogoDisplay() {
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
		MerchantLogin merchantLogin = new MerchantLogin(driver);

		merchantLogin.quickveeLogoDisplay();
		Assert.assertTrue(merchantLogin.quickveeLogoDisplay(), "Quickvee logo is not displayed");

	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
