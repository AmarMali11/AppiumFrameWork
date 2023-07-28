package app.pom.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Android.androidActions;

public class PO_inCartProductPagePrice extends androidActions {

	AndroidDriver driver;
	// contrcutor page factory
	public	PO_inCartProductPagePrice(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}



	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productsPrices;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchesePrice;





	public double  getTotalProductPriceSum()
	{
		int productIsze=productsPrices.size();
		double totalPriceSum=0; 
		for(int i=0;i<productIsze;i++)
		{ 
			String priceText=productsPrices.get(i).getText();
			String priceWithoutSpecialChar=priceText.substring(1); // Double.parseDouble(priceText.substring(1)) to remove dollar sign from string $140.45 form zero index 
			Double price=Double.parseDouble(priceWithoutSpecialChar); 

			totalPriceSum=totalPriceSum+price;

		}

		return	totalPriceSum;
	}


	public double getTotalProductPrice()
	{
		double totalCartPrice=getTotalPurchasePrice(totalPurchesePrice);
		return totalCartPrice;

	}


}
