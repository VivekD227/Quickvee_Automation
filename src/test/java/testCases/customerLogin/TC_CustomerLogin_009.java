//Validate logging into the Application without providing any credentials

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

import pageObjects.CustomerLogin;
import pageObjects.HomeFrontEndPage;

@Listeners(utilities.TestListener.class)

public class TC_CustomerLogin_009 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.quickvee.com/");
	}
	
	@Test(priority = 1)
	public void blankEmailPass() throws InterruptedException {
		HomeFrontEndPage homePage = new HomeFrontEndPage(driver);
		homePage.loginBtn();
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		customerLogin.setEmail("");
		String emailPut = customerLogin.getEmail();
		System.out.println("Email: "+emailPut);
		
		customerLogin.setPassword("");
		String passwordPut = customerLogin.getPassword();
		System.out.println("Password: "+passwordPut);

		customerLogin.loginBtnClick();
		Thread.sleep(1000);
		
		String emailError = "Please enter email";
		String passError = "Please enter password";

		
		Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter email']")).getText(), emailError);
		Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter password']")).getText(), passError);
		
		}
	@Test(priority = 2)
	public void putEmailBlankPass() throws InterruptedException {
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		customerLogin.setEmail("vivek.dubey22@gmail.com");
		String emailPut = customerLogin.getEmail();
		System.out.println("Email: "+emailPut);
		
		customerLogin.setPassword("");
		String passwordPut = customerLogin.getPassword();
		System.out.println("Password: "+passwordPut);

		customerLogin.loginBtnClick();
		Thread.sleep(1000);
		
		String passError = "Please enter password";

		
		Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter password']")).getText(), passError);
		
		}
	
	@Test(priority = 3)
	public void blankEmailPutPass() throws InterruptedException {
		
		CustomerLogin customerLogin = new CustomerLogin(driver);
		
		customerLogin.setEmail("");
		String emailPut = customerLogin.getEmail();
		System.out.println("Email: "+emailPut);
		
		customerLogin.setPassword("Vivek@123");
		String passwordPut = customerLogin.getPassword();
		System.out.println("Password: "+passwordPut);

		customerLogin.loginBtnClick();
		Thread.sleep(1000);
		
		String emailError = "Please enter email";

		
		Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter email']")).getText(), emailError);
		
		}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
