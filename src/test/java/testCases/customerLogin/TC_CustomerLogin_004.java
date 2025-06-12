//Validate logging into the Application using valid credentials

package testCases.customerLogin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_CustomerLogin_004 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.quickvee.com/");
	}
	
	@Test(priority = 1)
	public void validEmailPass() throws InterruptedException {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		customerLogin.setEmail("vivek22@gmail.com");
		String emailPut = customerLogin.getEmail();
		System.out.println("Email: "+emailPut);
		
		customerLogin.setPassword("Vivek@123");
		String passwordPut = customerLogin.getPassword();
		System.out.println("Password: "+passwordPut);

		customerLogin.loginBtnClick();
		Thread.sleep(1000);
	//	System.out.println(driver.getCurrentUrl());
		
		String expectedUrl = "https://www.quickvee.com/";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
		
		homePage.loggedIn();
		System.out.println("Customer Successfully Logged In");
		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
