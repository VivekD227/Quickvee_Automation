//Check whether "Are you a Merchant? Login" text is displayed or not?

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

public class TC_CustomerLogin_012 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.quickvee.com/");
	}
	
	@Test(priority = 1)
	public void checkMerchantLoginText() throws InterruptedException {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		//CustomerLogin customerLogin = new CustomerLogin(driver);
		
		String merchantLoginText = "Are you a Merchant? Login";
		Assert.assertEquals(driver.findElement(By.xpath("//p[2]")).getText(), merchantLoginText);

		}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
