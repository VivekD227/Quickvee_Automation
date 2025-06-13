//Check whether "Don't have an account?Register Now" text is displayed or not?

package testCases.customerLogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_CustomerLogin_011 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.quickvee.com/");
	}
	
	@Test(priority = 1)
	public void checkRegisterCustomerText() throws InterruptedException {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		//CustomerLogin customerLogin = new CustomerLogin(driver);
		
		String registerCustomerText = "Don't have an account?Register Now";
		Assert.assertEquals(driver.findElement(By.xpath("//body/div[@id='root']/div[@class='main-authentication-component']/div[@class=' login-customer-form ']/form[@class='login-customer-form']/div[@class='login-customer-form']/p[1]")).getText(), registerCustomerText);

		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
