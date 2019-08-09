package com.qa.keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.Testbase;


public class KeyWords extends Testbase
{
public static Workbook book=null;
public static Sheet sheet;

String locatorName=null;
String locatorValue=null;

public final String PATH="D:\\project\\Project workplace\\workplace2S\\PageObjectModel\\src\\main\\java\\com\\crm\\qa\\testdata\\SignUpKeywords.xlsx";
public void startExecution(String sheetName) {
	File file =new File(PATH);
FileInputStream fis=null;
try {
	fis = new FileInputStream(file);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	try {
		book=new XSSFWorkbook(fis);
	} catch (EncryptedDocumentException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
sheet=book.getSheet(sheetName);
int k=0;
for (int i = 0; i < sheet.getLastRowNum(); i++) {
	try {
	
	String locatorColValue=sheet.getRow(i+1).getCell(k+1).toString().trim();
	if(!locatorColValue.equalsIgnoreCase("NA")) {
		locatorName = locatorColValue.split("=")[0].trim();

		locatorValue = locatorColValue.split("=")[1].trim();
	}
	String action=sheet.getRow(i+1).getCell(k+2).toString().trim();
	String value=sheet.getRow(i+1).getCell(k+3).toString().trim();
	
	switch (action) {
	


		case "enter url":
			if(value.isEmpty()||value.equals("NA")) {
				driver.get(prop.getProperty("url"));
		 	}else {
				driver.get(value);
			}
			
			break;
			
			case"quit":
				driver.quit();
				break;
				default:
					break;
	}
	switch (locatorName) {
	case "xpath":
		WebElement element=driver.findElement(By.xpath(locatorValue));
		if(action.equalsIgnoreCase("sendkeys")) {
			element.clear();
			element.sendKeys(value);
		}else {
			if(action.equalsIgnoreCase("click")) {
				element.click();
			}
		
		}
		break;
	case "id":
		element=driver.findElement(By.id(locatorValue));
		if(action.equalsIgnoreCase("sendkeys")) {
			element.clear();
			element.sendKeys(value);
		}else {
			if(action.equalsIgnoreCase("click")) {
				element.click();
			}
		
		}
		
	case "name":
		element=driver.findElement(By.name(locatorValue));
		if(action.equalsIgnoreCase("sendkeys")) {
			element.clear();
			element.sendKeys(value);
		}else {
			if(action.equalsIgnoreCase("click")) {
				element.click();
			}
		
		}
	case "LinkText":
		element=driver.findElement(By.linkText(locatorValue));
		element.click();
		locatorName=null;
		break;
		
		default:
			break;
		
	}	

	}
	catch(Exception e1) {
		
}
}
}

}

	