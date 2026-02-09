package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoshop.base.BasePage;
import com.demoshop.base.BaseTest;

public class LoginPage extends BasePage{

	public LoginPage() {
		super(BaseTest.getDriver());
	}
	private By btnlogin=By.xpath("//a[normalize-space()='Log in']");
	private By txtemail=By.cssSelector("#Email");
	private By txtpassword=By.id("Password");
	private By loginbtn=By.xpath("//input[@value='Log in']");
	
	public void login(String email,String password) {
		click(btnlogin);
		sendkeys(txtemail,email);
		sendkeys(txtpassword,password);
		click(loginbtn);
		
	}

}
