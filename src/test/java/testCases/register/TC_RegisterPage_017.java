//Check whether we skip one of any mandatory field and click on register then, the new customer is register or not?

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

public class TC_RegisterPage_017 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://quickvee.com");
		
	}
	
	@Test(priority = 1)
	public void firstNameBlank() throws InterruptedException {
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
		
		register.setFirstName("");
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
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     
	     String url = "https://quickvee.com/register";
	     String ExpectedError = "Please enter First Name";
	     
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	     Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter First Name']")).getText(), ExpectedError);

	     Thread.sleep(2000);
		
	}
	
	@Test(priority = 2)
	public void phoneBlank() throws InterruptedException {
		RegisterPage register = new RegisterPage(driver);
		
		register.setFirstName("Vivek");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	

	     register.setPhone("");
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
	     
	     String url = "https://quickvee.com/register";
	     String ExpectedError = "Please enter phone number";
	     
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	     Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter phone number']")).getText(), ExpectedError);

	     Thread.sleep(2000);
		
	}
	
	@Test(priority = 3)
	public void emailBlank() throws InterruptedException {
		RegisterPage register = new RegisterPage(driver);
		
		register.setFirstName("Vivek");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	

	     register.setPhone("78459621245");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     
	     String url = "https://quickvee.com/register";
	     String ExpectedError = "Please enter email";
	     
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	     Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter email']")).getText(), ExpectedError);

	     Thread.sleep(2000);
		
	}
	

	@Test(priority = 4)
	public void passwordBlank() throws InterruptedException {
		RegisterPage register = new RegisterPage(driver);
		
		register.setFirstName("Vivek");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	

	     register.setPhone("78459621245");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername(register.newEmail()+"@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     
	     String url = "https://quickvee.com/register";
	     String ExpectedError = "Please enter password";
	     
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	     Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Please enter password']")).getText(), ExpectedError);

	     Thread.sleep(2000);
		
	}
	@Test(priority = 5)
	public void confirmPasswordBlank() throws InterruptedException {
		RegisterPage register = new RegisterPage(driver);
		
		register.setFirstName("Vivek");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	

	     register.setPhone("78459621245");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername(register.newEmail()+"@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     
	     String url = "https://quickvee.com/register";
	     String ExpectedError = "Confirm Password not matching";
	     
	     Assert.assertEquals(driver.getCurrentUrl(), url);
	     Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Confirm Password not matching']")).getText(), ExpectedError);

	     Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
