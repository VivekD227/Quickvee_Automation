//check whether when we click on login button of "Already have an account?Login" then it allows customer login or not

package testCases.register;

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
import pageObjects.RegisterPage;

@Listeners(utilities.TestListener.class)

public class TC_RegisterPage_015 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void customerLoginButtonCheck() throws InterruptedException {
		HomeFrontEndPage loginpage = new HomeFrontEndPage(driver);
		loginpage.loginPageDisplay();
		loginpage.notLogin();
		loginpage.loginBtn();
		System.out.println("");
		
		CustomerLogin homepage = new CustomerLogin(driver);
		homepage.isRegisterPage();
		homepage.RegisterBtnClick();
		System.out.println("");
		
		RegisterPage register = new RegisterPage(driver);
		register.customerLoginButton();
		String url = "https://quickvee.com/customer-login";
		String customerLoginText = "Customer Login";
		String welcomeText = "Welcome Back, Login to Shop";
		
		Assert.assertEquals(driver.getCurrentUrl(), url);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Customer Login']")).getText(), customerLoginText);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@class='sub-heading-from']")).getText(), welcomeText);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
