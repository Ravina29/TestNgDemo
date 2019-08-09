package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.keywords.*;

public class SignUpPageTest extends Testbase {
public LoginPage loginpage;
public HomePage homepage;
	public KeyWords keyword;
	public  SignUpPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		
		   
		

	}
	@Test
	public void signupTest() {
	 keyword=new KeyWords();
	keyword.startExecution("Sheet1");
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();

	}
}

