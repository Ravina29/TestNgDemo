package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends Testbase 
{
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	

	public ContactsPageTest() {
		super();
	}
	
@BeforeMethod
public void setup() {
initialization();
testutil=new TestUtil();
contactspage=new ContactsPage();
loginpage=new LoginPage();

homepage=loginpage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
testutil.switchtoFrame();
contactspage=homepage.clickOnContactslink();
}  
/*@Test
public void verifyContactLabelTest() {
	Assert.assertTrue(contactspage.verifyContactsLabel(),"missing contacts label");
}*/
/*@Test
public void selectContactTest() {
	
	contactspage.selectContacts("test2 test2");
}*/
@DataProvider(name="getTestdata")
public Object[][] getTestdata() {
	Object data[][]=TestUtil.getTestData("Contacts");
return data;
}
@Test(dataProvider="getTestdata")
public void CreatenewContactsTest(String title,String Firstname,String Lastname,String Company)  {
	homepage.clickOnNewContactsLink();
	contactspage.createNewContacts(title,Firstname,Lastname,Company);
}
@AfterMethod
public void tearDown() {
	driver.close();
	

}

}
