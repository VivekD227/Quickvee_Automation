//Chek whether we uncheck the capcta checkbox then customer can register the account of not

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

public class TC_RegisterPage_018 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	
	@Test
	public void uncheckCheckBox() throws InterruptedException {
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
		
		register.setFirstName("Vivek");
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
	     
	    
	    String firstNameError = "Please check captcha";
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please check captcha']")).getText(), firstNameError);
	    String url = "https://quickvee.com/register";
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	    
	   Thread.sleep(2000);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
