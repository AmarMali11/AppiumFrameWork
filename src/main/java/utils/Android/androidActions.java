package utils.Android;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class androidActions {

	AndroidDriver driver;

	public androidActions(AndroidDriver driver)
	{	
	this.driver=driver;
	}

	public void longClickGestureAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementID",((RemoteWebElement)ele).getId(),"duration",5000));
	}


	public void scrollStillEndAction()
	{
		boolean canScrollMore;
		do {		
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
					ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200,
							"direction", "down", "percent", 3.0 ));

		} while (canScrollMore);	

	}

	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
	}
	;


	public void dragAndDrop(WebElement element,int X_axis,int Y_axis)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"endX", X_axis,
				"endY", Y_axis
				));
	}



	public void swipeAction(WebElement element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
						"direction", direction,
						"percent", 0.75

						));

	}


	// commond to find Package and Activity in window
	//adb shell dumpsys window | find "mCurrentFocus"
	public void appPackageAndAppActivity(String appPackageName, String appActivityName)
	{
		Activity act= new Activity(appPackageName,appActivityName);
		driver.startActivity(act);
	}

	public void validateFirstToastErrorText(String expectedFirstToastErrorText)
	{
		WebElement toastError=driver.findElement(By.xpath("(//android.widget.Toast)[1]"));
		String errorText=toastError.getAttribute("name");
		Assert.assertEquals(errorText, expectedFirstToastErrorText);
	}



	public Double DoubleproductPrice(String priceInString)
	{	

		Double ammount=Double.parseDouble(priceInString.substring(1));
		return ammount;
	}

	public double getTotalPurchasePrice(WebElement totalPurchesePrice)
	{
		String priceText=totalPurchesePrice.getText();
		double totalProductPrice=DoubleproductPrice(priceText);
		return totalProductPrice;
	}

	public void ScreenRotate(int X_axis, int Y_axis, int Z_axis) throws InterruptedException
	{
		DeviceRotation landScape= new DeviceRotation(X_axis,Y_axis,Z_axis);
		driver.rotate(landScape);
		Thread.sleep(5000);
	}





}
