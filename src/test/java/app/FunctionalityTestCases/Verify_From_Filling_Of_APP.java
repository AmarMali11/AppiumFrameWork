package app.FunctionalityTestCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Appium_java.Appium.baseClass;
import app.pom.Pages.PO_formFillingPage;

public class Verify_From_Filling_Of_APP extends baseClass {

	//PO_formFillingPage appForm;

	@Test(dataProvider = "getData" , groups= {"Smoke"})
	public void appFromFilling(String name,String Gender, String Country) {


		PO_formFillingPage appForm= new PO_formFillingPage(driver);
		appForm.enterName(name);
		appForm.setGender(Gender);
		appForm.slectCountry(Country);
		appForm.submitAppForm();


	}

	
	/*
	 * @BeforeMethod 
	 * public void setActivityToAppHomePage() throws InterruptedException 
	 * {
	 *  PO_formFillingPage appForm1= new PO_formFillingPage(driver); 
	 *  appForm1.setBackAppToHome();
	 * 
	 * }
	 */
	 



	@DataProvider
	public  Object getData()
	{
		return new Object[][] {{"General App","female","Argentina"} };

	}

}
