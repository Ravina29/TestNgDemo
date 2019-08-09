package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class CalenderPage extends Testbase{

	@FindBy(xpath="//a[contains(text(),'Calendar')]")
	WebElement Calenderlink;
	
	@FindBy(xpath="//div[@id=\"crmcalendar\"]/table/tbody/tr[1]/td/select[1]")
	WebElement monthDropdown;
	
	@FindBy(xpath="//div[@id=\"crmcalendar\"]/table/tbody/tr[1]/td/select[2]")
	WebElement yearDropdown;
	
	@FindBy(xpath="//*[@id=\"crmcalendar\"]/table/tbody/tr[2]/td/table")
	WebElement datepik;
	
	public CalenderPage() {
		PageFactory.initElements(driver,this);
	}
	public void selectDate(String month,String year) throws InterruptedException {
		Select selectMonth=new Select(monthDropdown);
		selectMonth.selectByVisibleText(month);
		Thread.sleep(2000);
	
		Select selectYear=new Select(yearDropdown);
		selectYear.selectByVisibleText(year);
		Thread.sleep(2000);
	}
		public void selectDate(String day) {
			datepik.click();
		
		
		
	}
	
}
