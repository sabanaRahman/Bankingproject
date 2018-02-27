package PageObjectAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {
	
	
private static final String HOW = null;

static WebDriver driver;
	
	@FindBy(how=How.NAME, using="uid")
	WebElement txtUsername;
	
	@FindBy(how=How.NAME,using="password")
	WebElement txtPassWord;
	
	@FindBy(how=How.NAME,using="btnLogin")
	WebElement btnLogIn;
	
	
	public NewAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		public void userName(String uname) {
			txtUsername.sendKeys(uname);
		}
		
		public void userPassword(String pwd) {
			
			txtPassWord.sendKeys(pwd);
		}
		
		public void loginButton() {
			btnLogIn.click();
			
		}
		
		/***********************Login end***********************************/
		
	
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
			
	/************************Add Customer end************************************/		
	
			
			@FindBy(how=How.LINK_TEXT,using="New Account")
			WebElement newAccount;
			
			@FindBy(how=How.NAME,using="cusid")
			WebElement customerAccID;
			
			@FindBy(how=How.NAME, using="selaccount")
			WebElement accountType;
			
			@FindBy(how=How.NAME,using="inideposit")
			WebElement initDeposit;
			
			@FindBy(how=How.NAME,using="button2")
			WebElement submitAccount;
			
			@FindBy(how=How.LINK_TEXT, using="Continue")
			WebElement continueBTN;
			
			String message="Account Generated Successfully!!!";
			
			public void newAccount() {
				newAccount.click();
			}

			public void customerAccID(String id) {
				customerAccID.sendKeys(id);
			}
			
			public void accountType() {
				Select type=new Select(accountType);
				type.selectByIndex(0); 
			}
			
			
			public void initDeposit(String depo) {
				initDeposit.sendKeys(depo);; 
			}
			
			public void submitAccount() {
				submitAccount.click(); 
			}
			
			public void continueBTN() {
				continueBTN.click(); 
			}

/****************************************************************/			










}	
	
	
	
	
	
	
	
	
	
	
	

