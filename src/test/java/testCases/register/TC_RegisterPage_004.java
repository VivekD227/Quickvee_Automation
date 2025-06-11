//Validate Registering an Account by entering different passwords into 'Password' and 'Password Confirm' fields

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

public class TC_RegisterPage_004 {

WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void differentPasswordAndConfirmPassword() throws InterruptedException {
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
		
		register.setFirstName("Vivek");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	
	        
	     register.setPhone("8928185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername(register.newEmail()+"@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     String url = "https://quickvee.com/register";
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	     String errorMessage = "Confirm Password not matching";
	    
	  

	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Confirm Password not matching']")).getText(), errorMessage);
	     
	     Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
