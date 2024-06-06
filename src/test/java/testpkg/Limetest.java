package testpkg;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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



public class Limetest  extends Baseclass{
   
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
			ob.setvalues(mobno);
			ob.login();
			Thread.sleep(8000);
			
			
	     }
   }
	
	@Test(priority = 2)
	public void logo()
	{
	WebElement logo =	driver.findElement(By.xpath("//*[@id=\"DeskLogo\"]"));
    boolean boo = 	logo.isDisplayed();
    if(boo)
    {
    	System.out.println("logo is displayed");
    }
    else
    {
    	System.out.println("not displayed");
    }
    
	}
	
	@Test(priority = 3)
	public void menus()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//*[@id=\"DeskLogo\"]")).click();
	  List<WebElement>	li = driver.findElements(By.xpath("/html/body/div[2]/div[4]/div/div[2]/div/a"));
	  for(WebElement ele: li)
	  {
		  System.out.println(ele.getText());
	  }
	}
	
	
	@Test(priority = 4)
	public void bags()
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//*[@id=\"deskSearch\"]")).click();    
	    driver.findElement(By.xpath("//*[@id=\"srcInpu\"]")).sendKeys("bags",Keys.ENTER);
	    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/a/img")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/main/div/div/div[3]/div[1]/div[4]/div[4]/div[2]/div[2]")).click();
	    
	    
	}
	
	
	
	@Test(priority = 5)
	public void txtverify()
	{
		driver.findElement(By.xpath("//*[@id=\"DeskLogo\"]")).click();	
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/div[5]/div/div/div[1]/a/div/div[2]"))).getText();
	  String exp = "SCRAPBOOK";
	  Assert.assertEquals(actual, exp);
	  
	}
	
		
	@Test(priority = 6)
	public void kids() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(By.xpath("//*[@id=\"DeskLogo\"]")).click();	
		String parentwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"kids_category\"]")).click();
		Set<String> allwindowshandles     =  driver.getWindowHandles();
		for(String handle: allwindowshandles)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("//*[@id=\"filtrD\"]/div/div[4]/div[2]/label")).click();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
	}
	
	
	@Test(priority =  7)
	public void women()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		 WebElement women =   driver.findElement(By.xpath("//*[@id=\"women_category\"]"));
         Actions act = new Actions(driver);
         act.moveToElement(women).perform();
         driver.findElement(By.xpath("//*[@id=\"women_category_expand\"]/div/div[1]/div[3]/a")).click();
		 driver.findElement(By.xpath("//*[@id=\"filtrD\"]/div/div[5]/div[1]")).click();
		 driver.findElement(By.xpath("//*[@id=\"filtrD\"]/div/div[5]/div[2]/div[2]/label")).click();
		 
	}
	
	@Test(priority = 8)
	public void men()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		 WebElement men =   driver.findElement(By.xpath("//*[@id=\"men_category\"]"));
        Actions act = new Actions(driver);
        act.moveToElement(men).perform();
        driver.findElement(By.xpath("//*[@id=\"men_category_expand\"]/div/div[3]/div[9]/div/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/a/img")).click();
        driver.findElement(By.xpath("//html/body/div[2]/main/div/div/div[3]/div[1]/div[4]/div[6]/div[2]/div[2]")).click();
	}
	
	@Test(priority = 9)
	public void scrnsht() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(By.xpath("//*[@id=\"DeskLogo\"]")).click();	
		driver.findElement(By.xpath("//*[@id=\"newDeskVmart\"]/a")).click();
	    File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    WebElement vmartpg = driver.findElement(By.xpath("//*[@id=\"views\"]/div"));
	    File vmartscrn =   vmartpg.getScreenshotAs(OutputType.FILE);
	    FileHandler.copy(vmartscrn, new File("./Screenshot/vmartpage.png"));
	    
	}
	
	
	
	@Test(priority = 10)
	public void logout()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 driver.findElement(By.xpath("//*[@id=\"DeskLogo\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"desktop_profile\"]/div[2]/div/div[2]")).click();
		 driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div[5]/div/div/div[4]/div[1]/div/div[1]/div[2]/a")).click();
		 
	}
	
	
}


