package app.FunctionalityTestCases;

import org.testng.annotations.Test;

import Appium_java.Appium.baseClass;
import app.pom.Pages.PO_cartPage;
import app.pom.Pages.PO_formFillingPage;

public class VerifyAddProductToCart extends baseClass {

	
	@Test
	public void verifyAddProductToCart() throws InterruptedException
	{
		
		appForm1.enterName("General App");
		appForm1.setGender("female");
		appForm1.slectCountry("Argentina");
		// Skipping objection creation using return method with object
		PO_cartPage	addProductToCart=appForm1.submitAppForm();// store rturn object type of submitForm method in Object
		addProductToCart.addProdctsToCartOfIndex(0);
		addProductToCart.addProdctsToCartOfIndex(0);
		addProductToCart.goToCardPage();
		
		
	}
	
	
}
