package utils.Android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class commonUtils 
{
	public AppiumDriverLocalService service;
	public AppiumDriver driver;
	
	public AppiumDriverLocalService startServer(String ipAddress, int portNumber)
	{
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\amar.dharmaraj\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")) 
				.withIPAddress(ipAddress).usingPort(portNumber).build();
		service.start();
		return service;
		
	}
	
	public Double DoubleproductPriceInText(String priceInString)
	{	
				
		Double ammount=Double.parseDouble(priceInString.substring(1));
		return ammount;
	}
	public <Appium> String getScreenShotPath(String testCaseName, Appium driver2) throws Throwable
	
	{
		File source=((AppiumDriver) driver2).getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"testCaseName"+".jpg";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
		
	}
	
	
}
