package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class RegistrationPage extends BasePage{

	public RegistrationPage() {
		super(BaseTest.getDriver());
	}
	
	private By btnregister=By.xpath("//a[text()='Register']");
	private By btnradio=By.cssSelector("#gender-male");
	private By txtfirstname=By.id("FirstName");
	private By txtlastname=By.id("LastName");
	private By txtemail=By.id("Email");
	private By txtpassword=By.id("Password");
	private By txtcnrmpassword=By.id("ConfirmPassword");
	private By btnsubmit=By.id("register-button");
	private By txtvalidation=By.xpath("//div[@class='validation-summary-errors']");
	
	
	public void Registration(String fname,String lname,String email,
			String password,
			String cnfpassword) {

		click(btnregister);
		click(btnradio);
		sendkeys(txtfirstname, fname);
		sendkeys(txtlastname, lname);
		sendkeys(txtemail, email);
		sendkeys(txtpassword,password);
		sendkeys(txtcnrmpassword, cnfpassword);
		click(btnsubmit);
	}
	public String validateErrorMessage() {
		
		return getText(txtvalidation);
	}
	
	
	

}
