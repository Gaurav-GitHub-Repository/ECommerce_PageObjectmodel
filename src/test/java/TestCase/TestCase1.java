package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.Logout;

//Test Case1: Verify login button with valid credentials
public class TestCase1 {

	WebDriver driver;
	
	@BeforeTest
	public void initialize()
	{
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\V120\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test(dataProvider="Login")
	public void login(String username, String password)
	{
	  driver.get("https://www.saucedemo.com/v1/index.html");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  WebElement Username = driver.findElement(By.xpath("//input[@id='user-name' and @name='user-name']"));
	  Username.sendKeys(username);
	  WebElement Password = driver.findElement(By.xpath("//input[@id='password' and @name='password']"));
	  Password.sendKeys(password);
	  WebElement Login = driver.findElement(By.xpath("//input[@id='login-button']"));
	  Login.click();
	}
	@DataProvider(name="Login")
	String[][] getData()
	{
		String[][] data = {{"standard_user","secret_sauce"}};
		return data;	
	}
	@Test(priority=1)
	public void verifyLoginPage()
	{
	  String ActualCurrentURL = "https://www.saucedemo.com/v1/index.html";
	  String ActualPageTitle = "Swag Labs";
	  Assert.assertEquals(ActualCurrentURL, "https://www.saucedemo.com/v1/index.html");
	  Assert.assertEquals(ActualPageTitle, "Swag Labs");
	  Logout logout = new Logout(driver);
	  logout.clickOnLogoutButton();
	  logout.logout(); 
	}
		
}
