package com.tutorialsNinja.TestData;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProvider_ExcelCode {

	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellType celltype;
	
    public static Object[][] readFromExcelSheetRegisterTN(String sheetName) throws Exception {
    	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
    	workbook = new XSSFWorkbook(ip);
    	sheet = workbook.getSheet(sheetName);
    	int rows = sheet.getLastRowNum();
    	int cols = sheet.getRow(0).getLastCellNum();
    	
    	Object[][] data = new Object[rows][cols];
    	
    	for(int i=0 ; i<rows ; i++) {
    		row = sheet.getRow(i+1);
    		
    		for(int j=0 ; j<cols ; j++) {
    			cell = row.getCell(j);
    			 celltype = cell.getCellType();
    			 
    			 switch(celltype) {
    			 case STRING:
    				 data[i][j] = cell.getStringCellValue(); //I do not need to change
    				 break;
    				 
    			 case NUMERIC:
    				  data[i][j] = Integer.toString((int)cell.getNumericCellValue()); //I want to change it to String
    				  break;
    				  
    			 case BOOLEAN:
    				 data[i][j] = cell.getBooleanCellValue();
    				 break;
    			 }
    		}
    	}
    	return data;
    	}
    
    
    @DataProvider
	public Object[][] registerData() throws Exception {
    	Object[][] data = DataProvider_ExcelCode.readFromExcelSheetRegisterTN("RegisterTN");
	    return data;
	}
    
    /***************************************LoginTN*******************************************************************/
    
    public static Object[][] readFromExcelSheetLoginTN(String sheetName) throws Exception {
    	ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\ExcelData.xlsx");
    	workbook = new XSSFWorkbook(ip);
    	sheet = workbook.getSheet(sheetName);
    	int rows = sheet.getLastRowNum();
    	int cols = sheet.getRow(0).getLastCellNum();
    	
    	Object[][] data = new Object[rows][cols];
    	
    	for(int i=0 ; i<rows ; i++) {
    		row = sheet.getRow(i+1);
    		
    		for(int j=0 ; j<cols ; j++) {
    			cell = row.getCell(j);
    			 celltype = cell.getCellType();
    			 
    			 switch(celltype) {
    			 case STRING:
    				 data[i][j] = cell.getStringCellValue(); //I do not need to change
    				 break;
    				 
    			 case NUMERIC:
    				  data[i][j] = Integer.toString((int)cell.getNumericCellValue()); //I want to change it to String
    				  break;
    				  
    			 case BOOLEAN:
    				 data[i][j] = cell.getBooleanCellValue();
    				 break;
    			 }
    		}
    	}
    	return data;
	}
	
	
	@DataProvider
	public Object[][] loginData() throws Exception {
		Object[][] data = DataProvider_ExcelCode.readFromExcelSheetLoginTN("LoginTN");
	    return data;
	}
	
	
	

}