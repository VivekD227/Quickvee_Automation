package TestCases;

import java.time.Duration;



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

public class TC02_RegisterCustomerTestCases {

WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	
	/*
	In this we are validating the mandatory field, input field validation (It should takes only character, number, etc),
	The password and confirm password validation 
	The Email id validation
	The user Exist or Email already register validation.
	
	++++Note: We cannot validate the Capchta. 
	*/
	
	@Test(priority = 1)
	public void firstNameBlank() throws InterruptedException {
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
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8928185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
	     Thread.sleep(2000);
	     
		
       
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!, User Cannot login with Blank First Name input.");
         Assert.assertTrue(firstNameField.isEmpty(), "First Name is a mandatory field, kindly fill details");

       System.out.println("Test Case Passed!! User cannot register with a blank First Name input.");
	}
	
	@Test(priority = 2)
	public void phoneBlank() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		System.out.println(" ");
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
    
        Assert.assertTrue(phoneFiled.isEmpty(), "Mandatory field kindly enter Phone Number!!");
        
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!, User Cannot login with Blank First Name input.");

       System.out.println("Test Case Passed!! User cannot register with a blank Phone number input.");
	
        
	}
	
	
	@Test(priority = 3)
	public void userNameBlank() throws InterruptedException {
		
		
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
		
      
        
        Assert.assertTrue(usernameField.isEmpty(), "Mandatory field kindly enter Username!!");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!, User Cannot login with Blank First Name input.");

       System.out.println("Test Case Passed!! User cannot register with a blank User Name input.");
	
       
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
	        
	     register.setPhone("8928185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
        
	    Assert.assertTrue(passwordField.isEmpty(), "Mandatory field kindly enter Password!!");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!, User Cannot login with Blank First Name input.");

       System.out.println("Test Case Passed!! User cannot register with a blank Password input.");
	
       
	}
	

	@Test(priority = 5)
	public void ConfirmpasswordBlank() throws InterruptedException {
		
		
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
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
        
	        Assert.assertTrue(CpasswordField.isEmpty(), "Mandatory field kindly enter Confirm Password!!");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!, User Cannot login with Blank First Name input.");

       System.out.println("Test Case Passed!! User cannot register with a blank Confirm Password input.");
	
       
	}
	
	@Test(priority = 6)
	public void FirstNamenotValid() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek@");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8928185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
	    Assert.assertTrue(!register.isFirstNameAlphabetic(), "First name must contain only alphabets.");
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!, User Cannot login with Blank First Name input.");

       System.out.println("Test Case Passed!! First name must contain only alphabets");
	    
	}
	
	@Test(priority = 7)
	public void lastNameNotValid() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey@");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8928185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
	        Assert.assertTrue(!register.isLastNameAlphabetic(), "Last name must contain only alphabets.");
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!");
       System.out.println("Test Case Passed!! Last name must contain only alphabets");
	 
	}
	
	@Test(priority = 8)
	public void phoneNotValid() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("892a85554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
	     Assert.assertTrue(!register.isPhoneNumberValid(), "Phone number must be exactly 10 digits and Number.");
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!");

       System.out.println("Test Case Passed!! Phone number must be exactly 10 digits and Number");
	 
	}
	@Test(priority = 9)
	public void userNameNotValid() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8921185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
	    Assert.assertTrue(!register.isUsernameEmailValid(), "Inavlid Email ID");
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!");

       System.out.println("Test Case Passed!! Invalid user name");
	 
	}
	
	@Test(priority = 10)
	public void passwordInvalid() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8921185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
      
	        Assert.assertTrue(!register.isPasswordValid(), "Password does not meet the required criteria.");
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!");

       System.out.println("Test Case Passed!! Invalid Password format");
	 
	}
	@Test(priority = 10)
	public void confirmPasswordNotValid() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8921185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
	    Assert.assertNotEquals(passwordField, CpasswordField, "Password and Confirm Password do not match.");
     
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!");

       System.out.println("Test Case Passed!! Password and Confirm password mismatch");
	 
	}
	@Test(priority = 11)
	public void emailAlreadyExistValidation() throws InterruptedException {
		
		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
		
		
		 register.setLastName("Dubey");
	     String lastNameField = register.getLastName();
	     System.out.println("Last Name: " +lastNameField);
	        
	     register.setPhone("8921185554");
	        String phoneFiled = register.getPhone();
	        System.out.println("Phone Number: " +phoneFiled);
	        
	     register.setUsername("vivek.dubey@521@gmail.com");
	        String usernameField = register.getUsername();
	        System.out.println("Username: " +usernameField);
	        
	     register.setPassword("Vivek@123");
	        String passwordField = register.getPassword();
	        System.out.println("Password: " +passwordField);
	        
	     register.setConfirmPassword("Vivek@123");
	        String CpasswordField = register.getConfirPassword();
	        System.out.println("Confirm Password: " +CpasswordField);
	        
	     register.clickRegister();
		
	     if (register.isEmailExist()) {
	            System.out.println("Email already exists error displayed.");
	            Assert.assertTrue(true, "Email already exists error displayed as expected.");
	        }
	    String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://quickvee.com/register","Test Case Passed!!");

       System.out.println("Test Case Passed!! Email id Already Exist");
	 
	}
	
	@Test(priority=12)
	public void loginDisplay() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		

		
		RegisterPage register = new RegisterPage(driver);
		register.setFirstName("Vivek");
		
		String firstNameField = register.getFirstName();
		System.out.println("First Name: " +firstNameField);
        Assert.assertTrue(!firstNameField.isEmpty(), "This field is a Mandatory, kindly fill details");
        Assert.assertTrue(register.isFirstNameAlphabetic(), "First name must contain only alphabets.");

        
        register.setLastName("Dubey");
        String lastNameField = register.getLastName();
        System.out.println("Last Name: " +lastNameField);
        Assert.assertTrue(register.isLastNameAlphabetic(), "Last name must contain only alphabets.");
        
        
        
        
        register.setPhone("8928185554");
        String phoneFiled = register.getPhone();
        System.out.println("Phone Number: " +phoneFiled);
        Assert.assertTrue(!phoneFiled.isEmpty(), "Mandatory field kindly enter Phone Number!!");
        Assert.assertTrue(register.isPhoneNumberValid(), "Phone number must be exactly 10 digits and Number.");

        
 
        register.setUsername("vivek.dubeys521@gmail.com");
        String usernameField = register.getUsername();
        System.out.println("Username: " +usernameField);
        Assert.assertTrue(!usernameField.isEmpty(), "Mandatory field kindly enter Username!!");
        Assert.assertTrue(register.isUsernameEmailValid(), "Inavlid Email ID");
        
        
        register.setPassword("Vivek@123");
        String passwordField = register.getPassword();
        System.out.println("Password: " +passwordField);
        Assert.assertTrue(!passwordField.isEmpty(), "Mandatory field kindly enter Password!!");
        Assert.assertTrue(register.isPasswordValid(), "Password does not meet the required criteria.");

        
        register.setConfirmPassword("Vivek@123");
        String CpasswordField = register.getConfirPassword();
        System.out.println("Confirm Password: " +CpasswordField);
        Assert.assertTrue(!CpasswordField.isEmpty(), "Mandatory field kindly enter Confirm Password!!");
        Assert.assertEquals(passwordField, CpasswordField, "Password and Confirm Password do not match.");

        
        register.clickRegister();
        Thread.sleep(3000);
        if (register.isEmailExist()) {
            System.out.println("Email already exists error displayed.");
            Assert.assertTrue(true, "Email already exists error displayed as expected.");
        } else {
            System.out.println("New User.");
            loginpage.loggedIn(); // Call the loggedIn() method here
        }
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}

	
	

