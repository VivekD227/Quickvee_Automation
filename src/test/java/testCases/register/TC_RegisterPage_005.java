//Verify proper notification messages are displayed for the mandatory fields, when you don't provide any fields in the 'Register Account' page and submit

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

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

@Listeners(utilities.TestListener.class)

public class TC_RegisterPage_005 {

WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void properValidationMessage() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginPageDisplay();
		loginpage.notLogin();
		loginpage.loginBtn();
		System.out.println("");
		
		HomePage homepage = new HomePage(driver);
		homepage.isRegisterPage();
		homepage.RegisterBtnClick();
		System.out.println("");
		
		RegisterPage register = new RegisterPage(driver);
		
		register.setFirstName("");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		 register.setLastName("");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     
	    String firstNameErrorMessage = "Please enter First Name";
	    String phoneErrorMessage = "Please enter phone number";
	    String emailErrorMessage = "Please enter email";
	    String passwordErrorMessage = "Please enter password";
	    String confirmpasswordErrorMessage = "Please enter re-enter password";
	    String CaptchaErrorMessage = "Please check captcha";

	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter First Name']")).getText(), firstNameErrorMessage);
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter phone number']")).getText(), phoneErrorMessage);
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter email']")).getText(), emailErrorMessage);
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter password']")).getText(), passwordErrorMessage);
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter re-enter password']")).getText(), confirmpasswordErrorMessage);
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please check captcha']")).getText(), CaptchaErrorMessage);

	    
	   Thread.sleep(2000);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
