package utils.Android;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentsReportsUtils
{
	
	static ExtentReports extents;

	public static ExtentReports getReports()
	{

		//ExtentReport , 
		//ExtentSparkReport- reponsible to create new file and create some configuration 
		String path = System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter repoter= new ExtentSparkReporter(path);
		repoter.config().setReportName("Automation report");
		repoter.config().setDocumentTitle("Appium Test Cases Results");

		extents= new ExtentReports();
		extents.attachReporter(repoter);
		extents.setSystemInfo("Tester", "Amar Mali");
		return extents;

	}
	
}
