package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AddCustomerPage {
	
	static WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using="New Customer")
	WebElement linkAddNewCustomer;

	@FindBy(how=How.NAME, using="name")
	WebElement CustomerName;
	
	@FindBy(how=How.NAME, using="dob")
	WebElement CustomerDOB;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement CustomerAdd;
	
	@FindBy(how=How.NAME, using="city")
	WebElement CustomerCITY;

	@FindBy(how=How.NAME, using="state")
	WebElement CustomerState;

	@FindBy(how=How.NAME, using="pinno")
	WebElement CustomerPIN;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement CustomerPhone;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement CustomerEmail;
	
	@FindBy(how=How.NAME, using="password")
	WebElement CustomerPWD;


	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME, using="rad1")
	WebElement radio;
	


	public AddCustomerPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	public void NewCustomer() {
		linkAddNewCustomer.click();
	}

	
	public void customerName(String uname) {
		CustomerName.sendKeys(uname);
	}

	
		public void CustomerDOB(String date) {
			CustomerDOB.sendKeys(date);
		}

		public void CustomerAdd(String add) {
			CustomerAdd.sendKeys(add);
		}
		
		public void CustomerCITY(String city) {
			CustomerCITY.sendKeys(city);
		}
		
		public void CustomerState(String uname) {
			CustomerState.sendKeys(uname);
		}
		
		public void CustomerPIN(String uname) {
			CustomerPIN.sendKeys(uname);
		}
		
		public void CustomerPhone(String uname) {
			CustomerPhone.sendKeys(uname);
		}
		
		public void CustomerPWD(String uname) {
			CustomerPWD.sendKeys(uname);
		}

		public void btnSubmit() {
			btnSubmit.click();;
		}
		
		public void CustomerEmail(String email) {
			CustomerEmail.sendKeys(email);
		}

		public void btnGender() {
			
			if(radio.isSelected()==true) 
			{
				//radio.clear();
				radio.click();
			}
			else {
				radio.click();
			}
			
		}
		
}







