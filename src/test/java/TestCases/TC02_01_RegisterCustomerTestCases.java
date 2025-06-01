package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.RegisterPage;

public class TC02_01_RegisterCustomerTestCases {
WebDriver driver;

/*Here we are validating the test cases just by putting one value respectively
 and clicking on register button
 */



@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://quickvee.com/register");
	
}

@Test(priority=1)
public void firstName_Validation() throws InterruptedException {
	RegisterPage register = new RegisterPage(driver);
	register.setFirstName("Vivek");
	String getfname = register.getFirstName();
	System.out.println("First Name: "+getfname);
    Assert.assertTrue(register.isFirstNameAlphabetic(), "First name must contain only alphabets.");

    
    register.clickRegister();
    
    Thread.sleep(3000);
    if (register.isEmptyField()) {
        System.out.println("Kindly fill mandatory field.");
        Assert.assertTrue(true, "Error messeage displayed as Expected.");
    } 
}

	





@AfterClass
public void tearDown() {
	driver.quit();
}


}
