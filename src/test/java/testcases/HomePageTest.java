package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends Testbase {
LoginPage loginpage;
HomePage homepage;
TestUtil testutil;
ContactsPage contactspage;

public HomePageTest() {
	super();
}
@BeforeMethod
public void setUp() {
	initialization();
	testutil=new TestUtil();
	loginpage=new LoginPage();
   
	
	homepage=loginpage.LogIn(prop.getProperty("username"),prop.getProperty("password"));

}
@Test(priority=1)
public void verifyHomepageTitleTest() {
String homepagetitle=	homepage.verifyHomePageTitle();
	Assert.assertEquals(homepagetitle,"CRMPRO","title is not matched");
}
 
@Test(priority=2)
public void verify_username() {
	testutil.switchtoFrame();
	Assert.assertTrue(homepage.correctUsername());
}

@Test(priority=3)
public void click_on_ContactsTest() {
	testutil.switchtoFrame();
	contactspage=homepage.clickOnContactslink();
	
}

@AfterMethod
	public void tearDown() {
	driver.quit();

}
}
