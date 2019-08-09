package com.crm.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.Testbase;

public class TestUtil extends Testbase {

static Workbook book;
static Sheet sheet;
	public static int PAGE_LOAD_TIMEOUT=50;
	public static long Implicit_WAIT=30;
public static String path="/project/Project workplace/workplace2S/PageObjectModel/src/main/java/com/crm/qa/testdata/Contacts.xlsx";

	public void switchtoFrame() {
		driver.switchTo().frame("mainpanel");
		
	}
	public static Object[][] getTestData(String SheetName){
	
		FileInputStream file=null;
		try {
			file = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
		try {
			book=new XSSFWorkbook(file);

		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	sheet=book.getSheet("Sheet1");
	Object[][]data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
	}
	public static void takeScreenShot() {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir=System.getProperty("user.dir");
		try {
			FileUtils.copyFile(srcFile, new File(currentdir+"/PageObjectModel/screenshot"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
