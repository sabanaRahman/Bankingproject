package Test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.Randomstring;
import PageObjectAccount.NewAccount;
import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import Tests.CustomerModuleTest;

public class AccountModuleTest {

	static final Logger log=Logger.getLogger(CustomerModuleTest.class.getName());
	public static WebDriver driver;
	
	public static String custID;
	public static String acctID;
	public static String mail;
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

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(enabled=true, priority=1)
	public void newCreateAccount() throws Exception {
		
		NewAccount newCust=new NewAccount(driver);
		
		//LoginPage lp=new LoginPage(driver);
		
		newCust.userName(username);
		newCust.userPassword(password);
		newCust.loginButton();
		Thread.sleep(5000);
		
	//AddCustomerPage addCust=new AddCustomerPage(driver);
		
		newCust.NewCustomer();
		newCust.customerName("Michel John");
		newCust.btnGender();
		newCust.CustomerDOB("12/12/1990");
		newCust.CustomerAdd("New england wood");
		newCust.CustomerCITY("Burke");
		newCust.CustomerState("VA");
		newCust.CustomerPIN(String.valueOf("123456"));
		newCust.CustomerPhone(String.valueOf("432345674"));
		
		//Randomstring rand=new Randomstring();
		String emailValue=Randomstring.generaterandomString();
		String email=emailValue+"@gmail.com";
		
		 mail=email;
		 System.out.println(mail);
		newCust.CustomerEmail(email);
		
		String PWD=Randomstring.generaterandomString();
		newCust.CustomerPWD(PWD);
		
		newCust.btnSubmit();
		Thread.sleep(5000);
		
		String message="Customer Registered Successfully!!!";
		String xpMessage="//table[contains(@id,'customer')]//tbody//tr[1]//td//p";
		String xpCustomerID="//table[contains(@id,'customer')]//tbody//tr[4]//td[2]";

		boolean succesAddCust=driver.getPageSource().contains(message);

		if(succesAddCust==true)
		{
			//Assert.assertTrue(true);
			custID=driver.findElement(By.xpath(xpCustomerID)).getText();
			System.out.println("Customer id:   "+custID);
		}

		else {
			
			System.out.print("Fail no customer ID");
		}
	
		Thread.sleep(2000);
		
		newCust.newAccount();
		newCust.customerAccID(custID);
		newCust.accountType() ;
		newCust.initDeposit("600");
		newCust.submitAccount();
		Thread.sleep(2000);
		
		String newAccountMess="Account Generated Successfully!!!";
		
		boolean succesNewAcc=driver.getPageSource().contains(newAccountMess);
		Thread.sleep(2000);
		
		if(succesNewAcc==true) {
		
			String xpNewAcc=".//*[@id='account']/tbody/tr[4]/td[2]";
			acctID=driver.findElement(By.xpath(xpNewAcc)).getText();
			Thread.sleep(2000);
			System.out.println("Customer ID"+custID);
			System.out.println("Customer Account ID"+acctID);
			
			
		
		}
		
		Thread.sleep(2000);
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:hr@//localhost:1521/xe", "hr", "hr");
		Statement st=con.createStatement();
		int update=st.executeUpdate("insert into customerAccount values ('"+mail+"',"+custID+","+acctID+")");
		System.out.println(update+" row inserted");
	
	
	
	}










}
