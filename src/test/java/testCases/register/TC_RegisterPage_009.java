//Validate the register of account by providing Invalid first name input

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

public class TC_RegisterPage_009 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void invalidFirstName() throws InterruptedException {
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
		
		register.setFirstName("Vive@k");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("9876542313");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername(register.newEmail()+"@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     
	    
	    String firstNameError = "Name only contain alphabet";
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Name only contain alphabet']")).getText(), firstNameError);
	    String url = "https://quickvee.com/register";
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	    
	   Thread.sleep(2000);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
