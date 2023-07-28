package app.FunctionalityTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Appium_java.Appium.baseClass;
import app.pom.Pages.PO_cartPage;
import app.pom.Pages.PO_inCartProductPagePrice;

public class VerifyProductPriceSum_PurchasePrice extends baseClass {
	
	@Test
	public void compareProductPrices()
	{
		
		appForm1.enterName("General App");
		appForm1.setGender("female");
		appForm1.slectCountry("Argentina");
		PO_cartPage	addProductToCart=appForm1.submitAppForm();
		addProductToCart.addProdctsToCartOfIndex(0);
		addProductToCart.addProdctsToCartOfIndex(0);
		PO_inCartProductPagePrice productPrice=	addProductToCart.goToCardPage();
		
		double totalProductPrice=productPrice.getTotalProductPriceSum();
		double totalPurchasePrice=productPrice.getTotalProductPrice();
		System.out.println(totalProductPrice);
		System.out.println(totalPurchasePrice);
		Assert.assertEquals(totalProductPrice, totalPurchasePrice);
		
		
	}
	
	
	
	
	

}
