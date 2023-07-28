package app.FunctionalityTestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Appium_java.Appium.baseClass;
import app.pom.Pages.PO_formFillingPage;

public class formFillingWithJSONDataProvider extends baseClass
{

	@Test(dataProvider = "getData" )
	public void appFromFilling(String name,String Gender, String Country) {


		PO_formFillingPage appForm= new PO_formFillingPage(driver);
		appForm.enterName(name);
		appForm.setGender(Gender);
		appForm.slectCountry(Country);
		appForm.submitAppForm();


	}

	



	@DataProvider
	public  Object getData()
	{
		return new Object[][] {{"General App","female","Argentina"} };

	}
	
	
	
}
