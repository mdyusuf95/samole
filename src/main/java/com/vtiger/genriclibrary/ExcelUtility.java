package com.vtiger.genriclibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;



public class ExcelUtility {
  @DataProvider
	public Object[][]  exeleData(String sheet) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fls= new FileInputStream(IPathConstants.ExcelPath);
	    Workbook wb = WorkbookFactory.create(fls);
	    Sheet sh = wb.getSheet(sheet);
	    int  lastRownum=sh.getLastRowNum()+1;
	     short col = sh.getRow(0).getLastCellNum();
	 
	     
	    
	    Object a[][]= new Object [lastRownum][col];
	    for(int i=0;i<lastRownum;i++)
	    {
	    	for(int j=0;j<col;j++)
	    	{
	    		a[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	    	}
	    		}
		return a;
	    
	    }
  
	  @DataProvider
		public Object[][]  exeleData2() throws  Exception 
		{
			
			FileInputStream fls= new FileInputStream(IPathConstants.ExcelPath);
		    Workbook wb = WorkbookFactory.create(fls);
		    Sheet sh = wb.getSheet("Sheet1");
		    int  lastRownum=sh.getLastRowNum()+1;
		     short col = sh.getRow(0).getLastCellNum();
		 
		     
		    
		    Object a[][]= new Object [lastRownum][col];
		    for(int i=0;i<lastRownum;i++)
		    {
		    	for(int j=0;j<col;j++)
		    	{
		    		a[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		    	}
		    		}
			return a;
		    
		    }
	  public String writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo,String Date)  throws Throwable
		{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro=sh.getRow(RowNo);
	    Cell cell = ro.createCell(ColumnNo);
	    cell.setCellValue(Date);
	    FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
	     wb.write(fos);	
	     return Date;
	}
	  public Map<String, String> getList(String sheetName) throws Throwable
		{
			FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheetName);	
			int count =sh.getLastRowNum();
			Map<String,String> map=new HashMap<String,String>();
			JavaUtility JavaUtility = new JavaUtility();
			for(int i=0; i<=count; i++)
			{
				String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key,value);
			if(key.equals("docemail"))
			{
			value=value+"_"+JavaUtility.getRanDomNum();
			}
			
		}
			return map;
		}
	  /**This is used to get last row count
		 * @author kavya
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public int getLastRowNum(String sheetName) throws Throwable{
			FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sh = wb.getSheet(sheetName);	
			int count =sh.getLastRowNum();
			return count;
		}
		public String getDataFromExcel(String SheetName, int RowNo, int Cellnum) throws EncryptedDocumentException, IOException 
		{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		String date=wb.getSheet(SheetName).getRow(RowNo).getCell(Cellnum).getStringCellValue();
		return date;
	    }

	  
}
