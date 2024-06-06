package utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
    
	public static int getRowCount(String xl,String Sheet) throws IOException
	{
		try {
			FileInputStream f = new FileInputStream(xl);
			XSSFWorkbook wb = new XSSFWorkbook(f);
		    return 	wb.getSheet(Sheet).getLastRowNum();
			
			
		}
		
		catch (FileNotFoundException e) {
			
			
			return 0;
		}
		
		
	}
	
	public static String getCellValue(String xl,String Sheet,int r,int c) throws IOException
	{
		
		try {
			FileInputStream f = new FileInputStream(xl);
			XSSFWorkbook wb = new XSSFWorkbook(f);
			XSSFCell cell =    wb.getSheet(Sheet).getRow(r).getCell(c);
			if(cell.getCellType() == CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				return cell.getRawValue();
			}
			
		} 
		
		catch (FileNotFoundException e) {
			
			return "";
		}
		
	}	
		

	
}
