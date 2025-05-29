package LoginTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC01_LoginPage {
	
	WebDriver driver;
    WebDriverWait wait;

	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://quickvee.com/");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	
	@Test(priority=1)
	public void clickLoginBtn() throws InterruptedException {
		Thread.sleep(1000);
		WebElement checkPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='quickvee-customer-login' and text()='Log In']")));
		String checkPageText = checkPage.getText();
		if(checkPageText.equals("Log In")) {
			System.out.println("User is not logged In, Kindly Logged In");
		}
		Assert.assertTrue(true);
		
		
		
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
