//Validate logging into the Application using valid credentials


package testCases.MerchantLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;
import pageObjects.MerchantLogin;

@Listeners(utilities.TestListener.class)

public class TC_MerchantLogin_003 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com/");
	}
	
	@Test
	public void loginValidCredential() {
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
		MerchantLogin merchantLogin = new MerchantLogin(driver);

		String expectedUrl = "https://www.quickvee.com/merchants/login";
		
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		System.out.println("We are in Merchant Login Page");
		
		merchantLogin.setStoreName("superadmin");
		System.out.println("Store Name: "+merchantLogin.getStoreName());
		
		merchantLogin.setUserName("superadmin");
		System.out.println("User Name: "+merchantLogin.getUserName());
		
		merchantLogin.setPassword("S3CUrePaSsw@rd!25");
		System.out.println("Password: "+merchantLogin.getPassword());
		
		merchantLogin.loginBtnClick();
		
		String afterLoginUrl = "https://www.quickvee.com/merchants/users/unapprove";
		Assert.assertEquals(driver.getCurrentUrl(), afterLoginUrl);
		
		WebElement LoginText = driver.findElement(By.xpath("//p[@class='admin_medium']"));
		String afterLoginText = LoginText.getAttribute("value");
		if(afterLoginText.equals("Superadmin")) {
			Assert.assertTrue(true);
		}
	}
	
	
	
//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}
	
}
