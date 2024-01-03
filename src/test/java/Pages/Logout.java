package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

	WebDriver driver;
	
	public Logout(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator to click on logout option
	By LogoutOption = By.xpath("//div[@id='page_wrapper']/div/div/div[3]/div/button");
	//Locator to click on logout
	By Logout = By.xpath("//a[text()='Logout']");
	
	//Method to click on logout option
	public void clickOnLogoutButton()
	{
		driver.findElement(LogoutOption).click();
	}
	//Method to click on logout
	public void logout()
	{
		driver.findElement(Logout).click();
	}
}
