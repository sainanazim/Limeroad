package testpkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import basepkg.Baseclass;
import pagepkg.Limepg;
import utilites.Excelutils;



public class Limetest extends  Baseclass {
	
	@Test(priority = 1)
	public void verifytest() throws IOException, InterruptedException
	{

		Limepg ob = new Limepg(driver);
		String xl = "G:\\lime.xlsx";
		String Sheet = "Sheet1";
		int rowcount = Excelutils.getRowCount(xl, Sheet);
		for(int i =1;i<= rowcount;i++)
		{
			String mobno =  Excelutils.getCellValue(xl, Sheet, i, 0);
			System.out.println("mobile no: "+mobno);
			ob.profile();
			driver.navigate().refresh();
		    ob.setvalues(mobno);
		    Thread.sleep(9000);
			
			
	     }
	}
	@Test(priority = 2)
	public void logo()
	{
		Limepg ob = new Limepg(driver);
	    ob.logo();
    
	}
	
	@Test(priority = 3)
	public void titleverify() throws InterruptedException 
	{
		Limepg ob = new Limepg(driver);
		ob.titleverfctn();
	  
	}
	
	@Test(priority = 4)
	public void menus()
	{
		Limepg ob = new Limepg(driver);
		ob.menus();
	}
	
	
	@Test(priority = 5)
	public void bagsearch()
	{
		
		Limepg ob = new Limepg(driver);
		ob.search();
	    
	    
	}
	
	
	
		
	@Test(priority = 6)
	public void kids() throws InterruptedException
	{
		Limepg ob = new Limepg(driver);
		ob.kids();
	}
	
	
	@Test(priority =  7)
	public void women()
	{
		Limepg ob = new Limepg(driver);
		ob.women();
		 
	}
	
	@Test(priority = 8)
	public void men()
	{
		
		Limepg ob = new Limepg(driver);
		ob.men();
        
	}
	
	@Test(priority = 9)
	public void scrnsht() throws IOException, InterruptedException
	{
		
		Limepg ob = new Limepg(driver);
		ob.screenshot();
	  
	    
	}
	
	
	
	
	
	
	
}
