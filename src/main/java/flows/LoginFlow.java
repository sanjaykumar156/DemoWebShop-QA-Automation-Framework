package flows;

import com.demoshop.utils.ConfigReader;
import org.apache.logging.log4j.Logger;

import com.demoshop.utils.ConfigReader;
import com.demoshop.utils.LoggerManager;

import pages.LoginPage;

public class LoginFlow {
	private static final Logger log= (Logger) LoggerManager.getLogger(LoginFlow.class);
	public void loginWithValidCredentials() {
			log.info("Login into application with valid credentials");
		    LoginPage loginPage = new LoginPage();
		    
		    loginPage.login(
		        ConfigReader.getProperty("email"),
		        ConfigReader.getProperty("password")
		    );
		    log.info("Login Successfull");
}
}

