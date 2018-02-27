package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

static WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT, using="Edit Customer")
	WebElement editCustomer;

	@FindBy(how=How.NAME, using="cusid")
	WebElement CustomerID;
	
	@FindBy(how=How.NAME, using="AccSubmit")
	WebElement btnSubmitC;
	
	@FindBy(how=How.NAME, using="res")
	WebElement btnREST;
	
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
	


	public EditCustomerPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	public void NewCustomer() {
		editCustomer.click();
		//btnREST.click();
	}

	
	public void CustomeID(String id) {
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
	
		

		public void CustomerAdd(String add) {
			CustomerAdd.clear();
			CustomerAdd.sendKeys(add);
		}
		
		public void CustomerCITY(String city) {
			CustomerCITY.clear();
			CustomerCITY.sendKeys(city);
		}
		
		public void CustomerState(String uname) {
			CustomerState.clear();
			CustomerState.sendKeys(uname);
		}
		
		public void CustomerPIN(String uname) {
			CustomerPIN.clear();
			CustomerPIN.sendKeys(uname);
		}
		
		public void CustomerPhone(String uname) {
			CustomerPhone.clear();
			CustomerPhone.sendKeys(uname);
		}
		
		public void CustomereEmail(String email) {
			CustomerEmail.sendKeys(email);
		}
		
		public void CustomerPWD(String uname) {
			CustomerPWD.clear();
			CustomerPWD.sendKeys(uname);
		}

		public void btnSubmit() {
			
			btnSubmit.click();;
		}

		
		
}


























