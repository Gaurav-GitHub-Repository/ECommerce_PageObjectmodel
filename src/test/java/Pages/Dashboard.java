package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dashboard {

	WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator to verify product name
	By VerifyProduct1 = By.xpath("//div[text()='Sauce Labs Onesie']");
	//Locator add product to cart1
	By Product1 = By.xpath("//div[@id='inventory_container']/div/div[2]/div/div/div[3]/button[text()='ADD TO CART']");
	//Locator to add product to cart
	By addCart = By.xpath("//div[@id='shopping_cart_container']/a[@class='shopping_cart_link fa-layers fa-fw']");
	//Locator to add product3 to cart button 
	By addCart3 = By.xpath("//div[@id='inventory_container']/div/div[2]/div/div[3]/div[3]/button");
	//Locator to click on cart
	By Cart = By.xpath("//div[@id='header_container']/div/a");
	//Locator to click on checkout
	By Checkout = By.xpath("//a[text()='CHECKOUT']");
	//Locator to enter first name
	By FirstName = By.xpath("//input[@id='first-name' and @placeholder='First Name']");
	//Locator to enter last name
	By LastName = By.xpath("//input[@id='last-name' and @placeholder='Last Name']");
	//Locator to enter postal code
	By PostalCode = By.xpath("//input[@id='postal-code' and @placeholder='Zip/Postal Code']");
	//Locator to click on continue button
	By ContinueButton = By.xpath("//input[@class='btn_primary cart_button' and @value='CONTINUE']");
	//Locator to retrieve shipping details
	By ShippingDetails = By.xpath("//div[@class='summary_info']");
	//Locator to click on finish button
	By FinishButton = By.xpath("//div[@class='cart_footer']/a[2]");
	//Locator to verify placed order
	By PlacedOrder = By.xpath("//div[@id='checkout_complete_container']/h2");
	//Locator to click on continue button
	By ContinueShoppingButton = By.xpath("//a[text()='Continue Shopping']");
	//Locator to click on remove button
	By RemoveButton = By.xpath("//div[@class='cart_list']/div[3]/div[2]/div/button");
	//Locator to click on cancel button
	By CancelButton = By.xpath("//a[text()='CANCEL']");
	//Locator to verify error message
	By Error = By.xpath("//div[@class='checkout_info_wrapper']/form/h3");
	
	//Method to select filter
	public void selectFilter()
	{
		Select filter = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		filter.selectByVisibleText("Price (low to high)");
		List<WebElement> variable = filter.getOptions();
		for(WebElement options: variable)
		{
			if(options.equals("Price (low to high)"))
			{
				System.out.println("Prouct filter is verified");
				break;
			}
		}
	}
	//Method to select product
	public void selectProduct()
	{
		String ProductName = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
		String ProductName3 = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getText();
		if(ProductName.contains("Sauce Labs Onesie"))
		{
			driver.findElement(Product1).click();
		}
		else if(ProductName3.contains("Test.allTheThings() T-Shirt (Red)"))
		{
			driver.findElement(addCart3).click();
		}
	}
	//Method to add product to cart
	public void addToCartButton()
	{
		driver.findElement(Product1).click();
	}
	//Method to click on cart button
	public void addProductToCart()
	{
		driver.findElement(addCart).click();
	}
	//Method to click on cart
	public void clickOnCart()
	{
		driver.findElement(Cart).click();
	}
	//Method to click on checkout
	public void clickOnCheckout()
	{
		driver.findElement(Checkout).click();
		System.out.println("Clicked on checkout button");
	}
	//Method to enter first name, last name and postal code 
	public void enterCheckoutDetails(String name1, String name2, String Postal)
	{
		driver.findElement(FirstName).sendKeys(name1);
		driver.findElement(LastName).sendKeys(name2);
		driver.findElement(PostalCode).sendKeys(Postal);
		System.out.println("Entered checkout details");
	}
	//Method to click on continue button
	public void continueButton()
	{
		driver.findElement(ContinueButton).click();
		System.out.println("Clicked on continue button");
	}
	//Method to get shipping details
	public void getShippingDetails()
	{
		String ShippingDetails = driver.findElement(By.xpath("//div[@class='summary_info']")).getText();			
		System.out.println(ShippingDetails);
		String PaymentInformation = driver.findElement(By.xpath("//div[@class='summary_info']/div[text()='Payment Information:']")).getText();
		String ShippingInformation = driver.findElement(By.xpath("//div[@class='summary_info']/div[3]")).getText();
		if(ShippingDetails.contains(PaymentInformation))
		{
			System.out.println("PaymentInformation is verified");
		}
		if(ShippingDetails.contains(ShippingInformation))
		{	
			System.out.println("ShippingInformation is verified");
		}
	}
	//Method to scroll down
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}
	//Method to click on finish button
	public void FinishButton()
	{
		driver.findElement(FinishButton).click();
		System.out.println("Successfully clicked on finish button");
	}
	//Method to verify placed order
	public void verifyPlacedOrder()
	{
		driver.findElement(PlacedOrder).getText();
		String VerifyProduct = driver.findElement(PlacedOrder).getText();
		if(VerifyProduct.contains("THANK YOU FOR YOUR ORDER"))
		{
			System.out.println("Product is  verified");
		}
		else
		{
			System.out.println("Product is  not verified");
		}
	}
	//Method to click on continue shopping button
	public void clickOnContinueShoppingButton()
	{
		driver.findElement(ContinueShoppingButton).click();
	}
	//Method to click on remove button
	public void clickOnRemoveButton()
	{
		driver.findElement(RemoveButton).click();
	}
	//Method to click on cancel button
	public void clickOnCancelButton()
	{
		driver.findElement(CancelButton).click();
		System.out.println("Successfully clicked on cancel button");
	}
	//Method to verify error message
	public void verifyErrorDetails()
	{
		String ErrorDetails = driver.findElement(Error).getText();
		if(ErrorDetails.contains("Error: "))
		{
			System.out.println("Error message is verified");
		}
		else
		{
			System.out.println("Error message is not verified");
		}
	}
}
