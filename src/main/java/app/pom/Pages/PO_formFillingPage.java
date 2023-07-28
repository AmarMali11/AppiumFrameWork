package app.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.Android.androidActions;

public class PO_formFillingPage extends androidActions{
	
	public AndroidDriver driver;
	
	// Initialization using page Factory
		public PO_formFillingPage(AndroidDriver driver)
		{	super(driver);	
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		

	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement namefield;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement setFemaleBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement setMaleBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitAppFromBtn;
	

	
	
	// Action Methods
	
	public void enterName(String name)
	{
		namefield.sendKeys(name);
	}
	
	public void setGender(String genderName)
	{
		if(genderName.equalsIgnoreCase("female"))
			setFemaleBtn.click();
		else
			setMaleBtn.click();
	}
	
	public void slectCountry(String countryName)
	{
		countryDropDown.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	
	public PO_cartPage submitAppForm()
	{
		submitAppFromBtn.click();
		
		return new PO_cartPage(driver);  // to create page object of cart page and after submit form 
										// need to store this return object while calling submit form method
		
	}
	
	public void setBackAppToHome() throws InterruptedException
	{
		Thread.sleep(7000);
		Activity act = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
		driver.startActivity(act);
		//appPackageAndAppActivity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
	}
	
	
}
