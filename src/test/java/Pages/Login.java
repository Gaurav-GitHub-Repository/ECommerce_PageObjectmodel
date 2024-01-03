package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for username
	By Username = By.xpath("//div[@class='login-box']/form/input[@id='user-name']");
	//Locator for password
	By Password = By.xpath("//div[@class='login-box']/form/input[2]");
	//Locator for login
	By Submit = By.xpath("//input[@id='login-button' and @type='submit']");
	
	
	//Method to enter username
	public void enterUsername(String un)
	{
		driver.findElement(Username).sendKeys(un);
	}
	//Method to enter password
	public void enterPassword(String pwd)
	{
		driver.findElement(Password).sendKeys(pwd);
	}
	//Method to click on login button
	public void submit()
	{
		driver.findElement(Submit).click();
	}
}
