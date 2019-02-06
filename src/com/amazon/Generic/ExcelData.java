package com.amazon.Generic;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData
{
	public static String getData(String f_path, String s_name,int rw,int cn)
	{
	
		try {
			FileInputStream file= new FileInputStream(new File(f_path));
			Workbook wb=WorkbookFactory.create(file);
			String data= wb.getSheet(s_name).getRow(rw).getCell(cn).toString();
			return data;
			
		} catch (Exception e) 
		{
			return null;
		}
		
	}
	
	public static  int getRowCount(String f_path,String s_name)
	{
		try {
			FileInputStream file= new FileInputStream(new File(f_path));
			int rc=WorkbookFactory.create(file).getSheet(s_name).getLastRowNum();
			return rc;
		}
		catch (Exception e) 
		{
			return 0;
			
		}
			
	}
	public static int getCellCount(String f_path,String s_name,int rw)
	{
		FileInputStream file;
		try {
			file = new FileInputStream(new File(f_path));
			int cc=WorkbookFactory.create(file).getSheet(s_name).getRow(rw).getLastCellNum();
			return cc;
		}
		catch (Exception e) 
		{
			return 0;
			
		}
		
	}

}
