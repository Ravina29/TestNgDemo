package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class ContactsPage extends Testbase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")

	WebElement contacslabel;
	
	
	@FindBy(id="first_name")
	WebElement Fname;
	
	@FindBy(id="surname")
	WebElement Lname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement savebtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contacslabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()=' "+name+" ']//parent::td[@class='datalistrow']//preceding-sibling::td[@class=\"datalistrow\"]//input[@name='contact_id']")).click();

	}
	public void createNewContacts(String title,String Firstname,String Lastname,String Company) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Miss");
		
		Fname.sendKeys(Firstname);
		Lname.sendKeys(Lastname);
		company.sendKeys(Company);
		savebtn.click();
		
	}
	
}
