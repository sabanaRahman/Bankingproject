package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

static WebDriver driver;
	
	@FindBy(how=How.NAME, using="uid")
	WebElement txtUsername;
	
	@FindBy(how=How.NAME,using="password")
	WebElement txtPassWord;
	
	@FindBy(how=How.NAME,using="btnLogin")
	WebElement btnLogIn;

	/***********************************************/
	
	public LoginPage(WebDriver driver) {
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
	
}





















