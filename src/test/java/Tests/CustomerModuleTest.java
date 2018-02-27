package Tests;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import Library.Randomstring;
import PageObjects.AddCustomerPage;
import PageObjects.DeleteCustomerPage;
import PageObjects.EditCustomerPage;
import PageObjects.LoginPage;
import utilities.CaptureLogs;

public class CustomerModuleTest{
	
	
	
static final Logger log=Logger.getLogger(CustomerModuleTest.class.getName());
	
	
	
	
public static WebDriver driver;
public static String custID;
public String baseurl="http://www.demo.guru99.com/v4/";
public String username="mngr120047";
public String password="gyhanAs";

@BeforeMethod
public void openBrowser() {

PropertyConfigurator.configure("Log4j.properties");
	
System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get(baseurl);

log.info("==============Opening the browser====================");
}



@Test(enabled=false,priority=1)
public void loginTest() throws Exception {
	
	
	LoginPage lp=new LoginPage(driver);
	lp.userName(username);
	lp.userPassword(password);
	lp.loginButton();
	Thread.sleep(5000);
	
	log.info("=========Opening the Home Page after login button click==========");
	
	String Title=driver.getTitle();
	System.out.println("Home page Title:=========== "+Title);
	log.info("=============Home Page Title================");
	
	if(Title.equals("Guru99 Bank Manager HomePage"))
	{
		log.info("======verify the Title=========");
		
		Assert.assertTrue(true);
	
	}
	
	else {
		log.warning("===============Title fail==============");
		Assert.fail();
		 
		
	}
	
}


@Test(enabled=false,priority=2)
public void linkCountTest() throws Exception {
	
	log.info("======login page and counted total test verify=========");
	LoginPage lp=new LoginPage(driver);
	lp.userName(username);
	lp.userPassword(password);
	lp.loginButton();
	Thread.sleep(500);
	
	List<WebElement> totalLinks=driver.findElements(By.tagName("a"));
	System.out.println("Total links:===== "+totalLinks.size());
	
	
	if(totalLinks.size()==15)
	{
		log.info("=========links are counted and it is verifyed by assert method===========");
		Assert.assertTrue(true);
		log.info("Verified=====================");
	
	}
	
	else {
		log.warning("======links are counted and it is verifyed by assert method and it is not given right answer=======");
		Assert.fail();
		log.warning("===========failed ===============");
	}
	
}

@Test(enabled=false,priority=3)

public void addCustomer() throws Exception {
	
	log.info("============login page to add customer==========");
	LoginPage lp=new LoginPage(driver);
	lp.userName(username);
	lp.userPassword(password);
	lp.loginButton();
	Thread.sleep(3000);	
	log.info("===========open new customer page to add new page ===============");
	
	AddCustomerPage addCust=new AddCustomerPage(driver);
	
	addCust.NewCustomer();
	addCust.customerName("Michel John");
	Thread.sleep(3000);
	addCust.btnGender();
	Thread.sleep(3000);
	addCust.CustomerDOB("12/12/1990");
	Thread.sleep(3000);
	addCust.CustomerAdd("New england wood");
	Thread.sleep(3000);
	addCust.CustomerCITY("Burke");
	Thread.sleep(3000);
	addCust.CustomerState("VA");
	Thread.sleep(3000);
	addCust.CustomerPIN(String.valueOf(123454));
	Thread.sleep(3000);
	addCust.CustomerPhone(String.valueOf(432345673));
	Thread.sleep(3000);
	
	//Randomstring rand=new Randomstring();
	String emailValue=Randomstring.generaterandomString();
	String email=emailValue+"@gmail.com";
	addCust.CustomerEmail(email);
	
	String PWD=Randomstring.generaterandomString();
	addCust.CustomerPWD(PWD);
	
	addCust.btnSubmit();
	Thread.sleep(5000);
	
	
	String message="Customer Registered Successfully!!!";
	String xpMessage="//table[contains(@id,'customer')]//tbody//tr[1]//td//p";
	String xpCustomerID="//table[contains(@id,'customer')]//tbody//tr[4]//td[2]";

	boolean succesMessage=driver.getPageSource().contains(message);

	//DatabaseTable1  tb= new DatabaseTable1();
	
	if(succesMessage==true)
	{
		Assert.assertTrue(true);
		custID=driver.findElement(By.xpath(xpCustomerID)).getText();
		System.out.println("Customer id:   "+custID);
		Thread.sleep(3000);
		//int id=Integer.parseInt(custID);
		Thread.sleep(3000);
		//tb.insert(id);
		//Thread.sleep(3000);
	}

	else {
		
		System.out.print("Fail no customer ID");
	}

}

@Test(enabled=true,priority=4)
public void editCustomer() throws Exception {

	EditCustomerPage editCustomer=new EditCustomerPage(driver);
	
	LoginPage lp=new LoginPage(driver);
	lp.userName(username);
	lp.userPassword(password);
	lp.loginButton();
	Thread.sleep(5000);
	
AddCustomerPage addCust=new AddCustomerPage(driver);
	
	addCust.NewCustomer();
	addCust.customerName("Michel John");
	addCust.btnGender();
	addCust.CustomerDOB("12/12/1990");
	addCust.CustomerAdd("New england wood");
	addCust.CustomerCITY("Burke");
	addCust.CustomerState("VA");
	addCust.CustomerPIN(String.valueOf("123456"));
	addCust.CustomerPhone(String.valueOf("432345674"));
	
	//Randomstring rand=new Randomstring();
	String emailValue=Randomstring.generaterandomString();
	String email=emailValue+"@gmail.com";
	addCust.CustomerEmail(email);
	
	String PWD=Randomstring.generaterandomString();
	addCust.CustomerPWD(PWD);
	
	addCust.btnSubmit();
	Thread.sleep(5000);
	
	
	String message="Customer Registered Successfully!!!";
	String xpMessage="//table[contains(@id,'customer')]//tbody//tr[1]//td//p";
	String xpCustomerID="//table[contains(@id,'customer')]//tbody//tr[4]//td[2]";

	boolean succesMessage=driver.getPageSource().contains(message);

	if(succesMessage==true)
	{
		//Assert.assertTrue(true);
		custID=driver.findElement(By.xpath(xpCustomerID)).getText();
		System.out.println("Customer id:   "+custID);
	}

	else {
		
		System.out.print("Fail no customer ID");
	}
	
	editCustomer.NewCustomer();
	editCustomer.CustomeID(custID);
	editCustomer.btnSubmitC();
	
	editCustomer.ResetButton();
	editCustomer.CustomerAdd("wood");
	editCustomer.CustomerCITY("york");
	editCustomer.CustomerState("bu");
	editCustomer.CustomerPIN(String.valueOf("50007"));
	//editCustomer.CustomerPWD(uname);
	
	String editValue=Randomstring.generaterandomString();
	String editEmail=emailValue+"@gmail.com";
	
	editCustomer.CustomereEmail(editEmail);
	editCustomer.btnSubmit();
	
	Thread.sleep(5000);
	
	int id=Integer.parseInt(custID);
	
	//register userID insert in the database 
	
	Class.forName("oracle.jdbc.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:hr@//localhost:1521/xe", "hr", "hr");
	Statement st=con.createStatement();
	int update=st.executeUpdate("insert into customer values ("+id+")");
	System.out.println(update+" row inserted");

}

@Test(enabled=false,priority=5)

public void deleteCustomer() throws Exception {
	
	log.info("============login page to add customer==========");
	LoginPage lp=new LoginPage(driver);
	lp.userName(username);
	lp.userPassword(password);
	lp.loginButton();
	Thread.sleep(3000);	
	log.info("===========open new customer page to add new page ===============");
	
	AddCustomerPage addCust=new AddCustomerPage(driver);
	
	addCust.NewCustomer();
	addCust.customerName("Michel John");
	Thread.sleep(3000);
	addCust.btnGender();
	Thread.sleep(3000);
	addCust.CustomerDOB("12/12/1990");
	Thread.sleep(3000);
	addCust.CustomerAdd("New england wood");
	Thread.sleep(3000);
	addCust.CustomerCITY("Burke");
	Thread.sleep(3000);
	addCust.CustomerState("VA");
	Thread.sleep(3000);
	addCust.CustomerPIN(String.valueOf(123454));
	Thread.sleep(3000);
	addCust.CustomerPhone(String.valueOf(432345673));
	Thread.sleep(3000);
	
	Randomstring rand=new Randomstring();
	String emailValue=Randomstring.generaterandomString();
	String email=emailValue+"@gmail.com";
	addCust.CustomerEmail(email);
	
	String PWD=Randomstring.generaterandomString();
	addCust.CustomerPWD(PWD);
	
	addCust.btnSubmit();
	Thread.sleep(5000);
	
	
	String message="Customer Registered Successfully!!!";
	String xpMessage="//table[contains(@id,'customer')]//tbody//tr[1]//td//p";
	String xpCustomerID="//table[contains(@id,'customer')]//tbody//tr[4]//td[2]";

	boolean succesMessage=driver.getPageSource().contains(message);

	//DatabaseTable1  tb= new DatabaseTable1();
	
	if(succesMessage==true)
	{
		Assert.assertTrue(true);
		custID=driver.findElement(By.xpath(xpCustomerID)).getText();
		System.out.println("Customer id:   "+custID);
		Thread.sleep(3000);
		//int id=Integer.parseInt(custID);
		Thread.sleep(3000);
		//tb.insert(id);
		//Thread.sleep(3000);
	}

	else {
		
		System.out.print("Fail no customer ID");
	}

	
	DeleteCustomerPage deleteCustomer=new DeleteCustomerPage( driver);
	
	deleteCustomer.deleteCustomer();
	deleteCustomer.customerID (custID);
	deleteCustomer.btnSubmitC();
	Thread.sleep(3000);
	
	Alert alert=driver.switchTo().alert();
	alert.accept();
	Thread.sleep(300);
	Alert alert1=driver.switchTo().alert();
	String message1=alert1.getText();
	System.out.println(message1);
	alert1.accept();
	Thread.sleep(300);
}

@AfterMethod
public void teardowm() throws IOException {
	//if(result.getStatus()==ITestResult.FAILURE) {
	//	TakesScreenshot src=(TakesScreenshot)driver;
	//	File source=src.getScreenshotAs(OutputType.FILE);
		//Files.copy(source, new File("./Screenshots/"+Randomstring.generaterandomString()+".png"));
		
	//}
	driver.quit();
	
}
/*
@AfterMethod
public void captureScreen(ITestResult result) throws IOException {
	
	if(result.getStatus()==ITestResult.FAILURE) {
		TakesScreenshot src=(TakesScreenshot)driver;
		File source=src.getScreenshotAs(OutputType.FILE);
		Files.copy(source, new File("./Screenshots/"+Randomstring.generaterandomString()+".png"));
		
	}
	//driver.quit();
}

*/














}
