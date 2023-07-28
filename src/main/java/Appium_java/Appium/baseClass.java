package Appium_java.Appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import app.pom.Pages.PO_formFillingPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.Android.commonUtils;

/**
 * Hello world!
 *
 */
public class baseClass extends commonUtils

{	

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public PO_formFillingPage appForm1;

	@BeforeClass(alwaysRun=true)// it always execute and not depends on any group runing test case
	public void appiumBasicConfiguration() throws InterruptedException, MalformedURLException, Throwable
	{ 
		Properties prop= new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\utils\\Android\\propData.properties");
		prop.load(file);
		
		service=startServer(prop.getProperty("ipAddress"),Integer.parseInt(prop.getProperty("portNumber")));
		
		Thread.sleep(9000);
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("deviceName"));
		Thread.sleep(9000);
		options.setApp(System.getProperty("user.dir")+"\\src\\main\\java\\utils\\driver\\General-Store.apk");
		options.setChromedriverExecutable(System.getProperty("user.dir")+"\\src\\main\\java\\utils\\chromedriver.exe");	
		driver = new AndroidDriver(service.getUrl(), options);
		Thread.sleep(9000);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		appForm1 =new PO_formFillingPage(driver);
		

	}




	@AfterClass(alwaysRun=true)
	public void tearDown()
	{


		/*
		 * driver.quit(); service.stop();
		 */

	}


}
