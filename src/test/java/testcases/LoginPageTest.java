package testcases;

import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {

	 
	LoginPage loginpage;
	
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
	}
@Test(priority=1)
	public void LoginPageTitleTest() { 
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginpage.crmLogoImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void LoginTest() {
		HomePage homepage=new HomePage();
		homepage=loginpage.LogIn(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	
@AfterMethod
public void tearDown() {
	driver.quit();
}
}