package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC01_LoginTestCases {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://quickvee.com");
		
	}
	// We are testing whether the login page open or not
	@Test(priority=1)
	public void loginDisplay() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginPageDisplay();
		loginpage.notLogin();
	}
	
	//We are testing whether the login button is clicked or not
	@Test(priority=2)
	public void testLoginNavigation() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginBtn();
		
		HomePage HomePage = new HomePage(driver);
		HomePage.isRegisterPage();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
}
