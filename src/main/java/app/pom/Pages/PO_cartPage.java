package app.pom.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Android.androidActions;

public class PO_cartPage extends androidActions{
	
	AndroidDriver driver;
	PO_inCartProductPagePrice productPrice;
	
	
	// Contructor for driver initilization
	public PO_cartPage(AndroidDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Web elements
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addProductBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartBtn;
	
	
	
	
	// Actiona Method

	public void addProdctsToCartOfIndex(int index)
	{
		addProductBtn.get(index).click();
	}
	
	public  PO_inCartProductPagePrice goToCardPage()
	{
		cartBtn.click();
		productPrice=new PO_inCartProductPagePrice(driver);
		return productPrice;
	}
	
	
}
