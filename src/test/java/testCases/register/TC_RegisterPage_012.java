//"Validate whether the Quickvee image, Customer Register Text and Discover shopping delights! text visible or not"
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


public class TC_RegisterPage_012 {
	
WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void displayOtherText() throws InterruptedException {
		HomeFrontEndPage loginpage = new HomeFrontEndPage(driver);
		loginpage.loginPageDisplay();
		loginpage.notLogin();
		loginpage.loginBtn();
		System.out.println("");
		
		CustomerLogin homepage = new CustomerLogin(driver);
		homepage.isRegisterPage();
		homepage.RegisterBtnClick();
		System.out.println("");
		
		//RegisterPage register = new RegisterPage(driver);
		
		String textRegister = "Customer Register";
		String customerText = "Discover shopping delights!";
		
		boolean image = driver.findElement(By.xpath("//img[@alt='Quickvee']")).isDisplayed();
	    Assert.assertEquals(driver.findElement(By.xpath("//img[@alt='Quickvee']")).isDisplayed(), image);
		
	    Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Customer Register']")).getText(), textRegister);
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Discover shopping delights!' and @class='sub-heading-from']")).getText(), customerText);

	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
