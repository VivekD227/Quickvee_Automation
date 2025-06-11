//check whether when we click on login button of "Are you a Merchant?" then it allows customer login or not

package testCases.register;

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
import pageObjects.RegisterPage;

@Listeners(utilities.TestListener.class)

public class TC_RegisterPage_016 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void merchantLoginButtonCheck() throws InterruptedException {
		HomeFrontEndPage loginpage = new HomeFrontEndPage(driver);
		loginpage.loginPageDisplay();
		loginpage.notLogin();
		loginpage.loginBtn();
		System.out.println("");
		
		CustomerLogin homepage = new CustomerLogin(driver);
		homepage.isRegisterPage();
		homepage.RegisterBtnClick();
		System.out.println("");
		
		String originalWindow = driver.getWindowHandle();
		RegisterPage register = new RegisterPage(driver);
		register.merchantLoginButton();
		
		for(String windowHandle : driver.getWindowHandles()) {
			if(!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
		
		String url = "https://www.quickvee.com/merchants/login";
		
		Assert.assertEquals(driver.getCurrentUrl(), url, "Merchant login tab URL validation failed");
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
