package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

static WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using="Delete Customer")
	WebElement deleteCustomer;

	@FindBy(how=How.NAME, using="cusid")
	WebElement CustomerID;
	
	@FindBy(how=How.NAME, using="AccSubmit")
	WebElement btnSubmitC;
	
	@FindBy(how=How.NAME, using="res")
	WebElement btnREST;
	
	/*
	@FindBy(how=How.NAME, using="addr")
	WebElement CustomerAdd;
	
	@FindBy(how=How.NAME, using="city")
	WebElement CustomerCITY;

	@FindBy(how=How.NAME, using="state")
	WebElement CustomerState;

	@FindBy(how=How.ID, using="message6")
	WebElement CustomerPIN;
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement CustomerPhone;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement CustomerEmail;
	
	@FindBy(how=How.NAME, using="password")
	WebElement CustomerPWD;


	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	@FindBy(how=How.NAME, using="rad1")
	WebElement radio;
	
*/

	public DeleteCustomerPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	public void deleteCustomer() {
		deleteCustomer.click();
		//btnREST.click();
	}

	
	public void customerID(String id) {
		CustomerID.sendKeys(id);
	}
	
	public void btnSubmitC() {
		//editCustomer.click();
		btnSubmitC.click();
	}

	public void ResetButton() {
		//editCustomer.click();
		btnREST.click();
	}
	
		
/*
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

		public void btnGender() {
			
			if(radio.isSelected()==true) 
			{
				radio.clear();
				radio.click();
			}
			else {
				radio.click();
			}
			
		}
		*/
		
}



























