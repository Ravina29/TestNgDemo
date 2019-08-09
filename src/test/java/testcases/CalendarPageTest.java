package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CalendarPageTest extends Testbase {

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
CalenderPage calender;
	public CalendarPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
	initialization();
	logger.info("initialization start");

	testutil=new TestUtil();
	calender=new CalenderPage();
	loginpage=new LoginPage();

	homepage=loginpage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
	testutil.switchtoFrame();
	calender=homepage.clickOnCalenderLink();
}
	@Test(priority=1)
	public void selectMonthTest() throws InterruptedException {
		logger.info("test started");
		calender.selectDate("July","2020");
		calender.selectDate("12");
	}
	@AfterMethod
	public void tearDown() {
		logger.info("browser close");

		driver.close();
		
}
}
