package com.crm.qa.pages;





import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.Testbase;

public class HomePage extends Testbase {
	
	@FindBy(xpath="//td[contains(text(), 'User: naveen k ')]")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactslink;
	
    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement dealslink;
    
    @FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;

    @FindBy(xpath="//a[contains(text(),'Cases')]")
	WebElement caseslink;
    
    @FindBy(xpath="//a[contains(text(),'Companies')]")
    WebElement companieslink ;
    
    @FindBy(xpath="//a[contains(text(),'Calendar')]")
    WebElement calendarlink ;

    public HomePage() {
    	PageFactory.initElements(driver, this);
    }
public String verifyHomePageTitle() {
return	driver.getTitle();

}
	public ContactsPage clickOnContactslink() {
		contactslink.click();
		return new ContactsPage();
		
	}
	public boolean correctUsername() {
		
	return username.isDisplayed();	
	}
	public DealsPage clickonDealsLink() {
		dealslink.click();
		return  new DealsPage();
	}
	public TaskPage clickonTasksLink() {
		taskslink.clear();
		return new TaskPage();
	}
	public void clickOnNewContactsLink() {
		Actions act=new Actions(driver);
		act.moveToElement(contactslink).build().perform();
		newcontactslink.click();
	}
	public CalenderPage clickOnCalenderLink() {
		calendarlink.click();
		return new CalenderPage();
	}
}
