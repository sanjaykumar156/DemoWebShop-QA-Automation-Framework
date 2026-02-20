package flows;

import com.demoshop.utils.ConfigReader;

import pages.LoginPage;

public class LoginFlow {
	public void loginWithValidCredentials() {
		    LoginPage loginPage = new LoginPage();
		    
		    loginPage.login(
		        ConfigReader.getProperty("email"),
		        ConfigReader.getProperty("password")
		    );
}
}

