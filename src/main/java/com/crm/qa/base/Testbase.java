package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
 public static WebDriver driver;
 public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListner eventListener;
public static  Logger logger;
public Testbase() {
	try {
 prop=new Properties();

 

 FileInputStream fis = new FileInputStream("/project/Project workplace/workplace2S/PageObjectModel/src/main/java/com/crm/"+"qa/config/config.properties");
	prop.load(fis);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

//create initialization method
public static void initialization() {
 String browsername=prop.getProperty("browser")	;
 if(browsername.equals("chrome")) {
 WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
 }else
	 if(browsername.equals("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	 }
		 logger=Logger.getLogger("PageObjectModel");
			PropertyConfigurator.configure("log4j.properties");
			logger.info("initialization start");
	 
 e_driver=new EventFiringWebDriver(driver);
 eventListener=new WebEventListner() {
	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}
	
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}
}; 
	
	
 e_driver.register(eventListener);
 driver=e_driver;
 driver.manage().window().maximize();
 driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
	
}
}

