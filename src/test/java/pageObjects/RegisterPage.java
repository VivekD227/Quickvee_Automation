package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.waitHelper;

public class RegisterPage extends waitHelper{
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
	
	By firstName = By.cssSelector("input[name = 'firstname']");
	
	By lastName = By.cssSelector("input[name = 'lastname']");
	
	By phoneNumber = By.cssSelector("input[name = 'phone']");
	
	By userName = By.cssSelector("input[name = 'username']");

	By passWord = By.cssSelector("input[name = 'password']");

	By confirmPassword = By.cssSelector("input[name = 'confirmpassword']");
	
	By registerBtn = By.xpath("//button[text()='Register']");
	
	//By error_message = By.xpath("//div[@class='MuiAlert-message css-1xsto0d']");
	public void clearInputField(By locator) {
	    WebElement element = driver.findElement(locator);
	    element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	
	public void setFirstName(String fname) {
		visiblityOfElement(firstName);
	    clearInputField(firstName);

	    driver.findElement(firstName).sendKeys(fname);

	}
	
	public String getFirstName() {
		return driver.findElement(firstName).getAttribute("value");
	}
	
	public boolean isFirstNameAlphabetic() {
	    String firstNameValue = getFirstName();
	    return firstNameValue != null && firstNameValue.matches("^[a-zA-Z]+$");
	}

	
	
	public void setLastName(String lname) {
		visiblityOfElement(lastName);
	    clearInputField(lastName);

	    driver.findElement(lastName).sendKeys(lname);

	}
	
	public String getLastName() {
		return driver.findElement(lastName).getAttribute("value");
	}
	
	public boolean isLastNameAlphabetic() {
	    String lastNameValue = getLastName();
	    return lastNameValue.matches("^[a-zA-Z]+$");
	}
	
	
	public void setPhone(String pnumber) {
		visiblityOfElement(phoneNumber);
	    clearInputField(phoneNumber);

	    driver.findElement(phoneNumber).sendKeys(pnumber);

	}
	
	public String getPhone() {
		return driver.findElement(phoneNumber).getAttribute("value");
	}
	
	public boolean isPhoneNumberValid() {
	    String phone = getPhone();
	    return phone != null && phone.matches("^\\d{10}$");
	}

	
	public void setUsername(String uname) {
		visiblityOfElement(userName);
	    clearInputField(userName);

	    driver.findElement(userName).sendKeys(uname);

	}
	
	public String getUsername() {
		return driver.findElement(userName).getAttribute("value");
	}
	public boolean isUsernameEmailValid() {
	    String email = getUsername();
	    return email != null && email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
	}

	
	public void setPassword(String pass) {
		visiblityOfElement(passWord);
	    clearInputField(passWord);

	    driver.findElement(passWord).sendKeys(pass);

	}
	
	public String getPassword() {
		return driver.findElement(passWord).getAttribute("value");
	}
	
	public void setConfirmPassword(String cpass) {
		visiblityOfElement(confirmPassword);
	    clearInputField(confirmPassword);

	    driver.findElement(confirmPassword).sendKeys(cpass);

	}
	
	public String getConfirPassword() {
		return driver.findElement(confirmPassword).getAttribute("value");
	}
	
	public void clickRegister() throws InterruptedException {
	    Thread.sleep(10000);
	    elementClick(registerBtn);
	    WebElement registerButtonElement = driver.findElement(registerBtn);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButtonElement);
	    Thread.sleep(1000); // Small pause to ensure scroll completes
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButtonElement);
	    System.out.println("The button is Clicked");
	
	}
	
	// RegisterPage.java
	public boolean isEmailExist() {
	    List<WebElement> errorElements = driver.findElements(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']"));
	    return !errorElements.isEmpty();
	}
	
	public boolean isEmptyField() {
		List<WebElement> errorMessage = driver.findElements(By.xpath("//span[@class=\"input-error\"]"));
		return !errorMessage.isEmpty();
	}
	
	public boolean isPasswordValid() {
	    String password = getPassword();
	    if (password == null) {
	        return false;
	    }
	    
	    // At least 8 characters, one digit, one lowercase, one uppercase, one special character
	    String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
	    return password.matches(passwordPattern);
	}


	
}

