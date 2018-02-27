package utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class Reporting extends TestListenerAdapter{


	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public void onStart(ITestContext testContext)
	{
		extent=	new ExtentReports (System.getProperty("user.dir")+"/test-output/MyOwnreport.html",true);
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("User name", "Sabana");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	public void onTestFailure(ITestResult result) {
		
		test=extent.startTest(result.getName());
		test.log(LogStatus.FAIL, result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test=extent.startTest(result.getName());
		test.log(LogStatus.SKIP, result.getName());
	}

	public void onTestSuccess(ITestResult result) {
	
	test=extent.startTest(result.getName());
	test.log(LogStatus.PASS, result.getName());
}
	
	/*
	public void getResult(ITestResult result) {
	
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		extent.endTest(test);
		
	}
	
	*/
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}













