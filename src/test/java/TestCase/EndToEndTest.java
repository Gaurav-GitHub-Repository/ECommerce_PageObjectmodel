package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.Login;

 //Test Case1: Verify product is placed successfully

public class EndToEndTest {

	WebDriver driver;
	
	@Test(priority=1)
	public void initialize()
	{
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\V120\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void verifyLoginPage()
	{
	  String ActualCurrentURL = "https://www.saucedemo.com/v1/index.html";
	  String ActualPageTitle = "Swag Labs";
	  Assert.assertEquals(ActualCurrentURL, "https://www.saucedemo.com/v1/index.html");
	  Assert.assertEquals(ActualPageTitle, "Swag Labs");
	}
	@Test(priority=3)
	public void login()
	{
		Login loginpage = new Login(driver);
		loginpage.enterUsername("standard_user");
		loginpage.enterPassword("secret_sauce");
		loginpage.submit();
	}
	@Test(priority=4)
	public void selectProduct() throws InterruptedException
	{
		Dashboard dashboardpage = new Dashboard(driver);
		dashboardpage.selectFilter();
		Thread.sleep(1000);
		dashboardpage.selectProduct();
		dashboardpage.clickOnCart();
		Thread.sleep(1000);
		dashboardpage.clickOnCheckout();
	}
	@Test(priority=5)
	public void CheckoutInformation()
	{
		String ActualCurrentUrl = "https://www.saucedemo.com/v1/checkout-step-one.html";
		String ActualPageTitle = "Swag Labs";
		Assert.assertEquals(ActualCurrentUrl, "https://www.saucedemo.com/v1/checkout-step-one.html");
		Assert.assertEquals(ActualPageTitle, "Swag Labs");
		Dashboard dashboard = new Dashboard(driver);
		dashboard.enterCheckoutDetails("Pathange", "Gaurav", "500100");
		dashboard.continueButton();
	}
	@Test(priority=6)
	public void ShippingInformation() throws InterruptedException
	{
		Dashboard dashboard = new Dashboard(driver);
		dashboard.getShippingDetails();
		dashboard.scrolldown();
		Thread.sleep(1000);
		dashboard.FinishButton();
	}
	@Test(priority=7)
	public void verifyPlacedProduct()
	{
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyPlacedOrder();
	}
}
