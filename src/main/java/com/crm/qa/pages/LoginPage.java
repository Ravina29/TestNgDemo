package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	
@FindBy(name="username")
WebElement username;

@FindBy(name="password")
WebElement password;

@FindBy(xpath="//input[@value='Login']")
WebElement Login;



@FindBy(xpath="/html/body/div[2]/div/div[1]/a")
WebElement crmLogo;

public LoginPage() {
	PageFactory.initElements(driver, this);
	
}
public String  validateLoginPageTitle() {
	 return driver.getTitle();
}
public boolean crmLogoImage() {
	return crmLogo.isDisplayed();
	
}
public HomePage LogIn(String un,String pass) {
	username.sendKeys("naveenk");
	password.sendKeys("test123");
	Login.submit();
	
	
	return  new HomePage();

}
}
