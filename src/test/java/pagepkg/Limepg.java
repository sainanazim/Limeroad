package pagepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Limepg {

	WebDriver driver;

    
    @FindBy(id = "desktop_profile")
    WebElement profile;
    
    @FindBy(xpath = "//*[@id=\"desktop_profile_expand\"]/div[1]/div[3]/a/span")
    WebElement login;
    
    @FindBy(xpath = "//*[@id=\"emph\"]")
    WebElement entermob;
    
    @FindBy(xpath = "//*[@id=\"signinnewForm\"]/div[3]/input")
   WebElement next;
	
    @FindBy(xpath = "//*[@id=\"DeskLogo\"]")
     WebElement logo;
    
    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[2]/div/a")
    List<WebElement> menuli;   
    
    @FindBy(xpath = "//*[@id=\"deskSearch\"]")
    WebElement searchicon;
    
    @FindBy(xpath = "//*[@id=\"srcInpu\"]")
    WebElement searchentr;
    
    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div[2]/div[2]/a/img")
    WebElement bag;
    
    @FindBy(xpath = "/html/body/div[2]/main/div/div/div[3]/div[1]/div[4]/div[4]/div[2]/div[2]")
    WebElement bagcart;
    
    @FindBy(xpath ="//*[@id=\"kids_category\"]")
    WebElement kidscatgry;
    
    @FindBy(xpath = "//*[@id=\"filtrD\"]/div/div[4]/div[2]/label")
    WebElement kidsnew;
    
    @FindBy(xpath = "//*[@id=\"women_category\"]")
    WebElement women;
    
    @FindBy(xpath = "//*[@id=\"women_category_expand\"]/div/div[1]/div[3]/a")
    WebElement saree;
    
    @FindBy(xpath = "//*[@id=\"filtrD\"]/div/div[5]/div[1]")
    WebElement colordrop;
    
    @FindBy(xpath = "//*[@id=\"filtrD\"]/div/div[5]/div[2]/div[2]/label")
    WebElement green;
    
    @FindBy(xpath = "//*[@id=\"men_category\"]")
    WebElement men;
    
    @FindBy(xpath = "//*[@id=\"men_category_expand\"]/div/div[3]/div[10]/div/a")
    WebElement mensungls;
    
    @FindBy(xpath = "//*[@id=\"filtrD\"]/div/div[4]/div[3]/label/div")
    WebElement discount;
    
    @FindBy(xpath = "//*[@id=\"newDeskOffers\"]/a")
    WebElement offers;
    
    @FindBy(xpath = "//*[@id=\"zero_result\"]/div[2]") 
    WebElement offerspg;
    
    @FindBy(xpath = "/html/body/div[2]/div[4]/div/div[5]/div/div/div[4]/div[1]/div/div[1]/div[2]/a")
    WebElement logout;
    
   public Limepg(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements( driver,this);
}
	
	
	public void profile() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		profile.click();
        login.click();
	    Actions act = new Actions(driver);
	    act.moveToElement(entermob).perform();
	    	
	    
	  
	}
	public void setvalues(String mobno) throws InterruptedException
	{
		entermob.clear();
		entermob.sendKeys(mobno);
		next.click();
	}
	
	
	public void logo()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
	
	public void menus()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		logo.click();
	   for(WebElement ele: menuli)
	   {
		  System.out.println(ele.getText());
	   }
	}
	
	public void search()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		searchicon.click();    
	    searchentr.sendKeys("bags",Keys.ENTER);
	    bag.click();
	    bagcart.click();
	}
	
	public void titleverfctn() throws InterruptedException
	{
		
		logo.click();	
		Thread.sleep(6000);
	   String actual =  driver.getTitle();
	   System.out.print("actual tile: "+actual);
	   String exp = "Limeroad";
	   Assert.assertEquals(actual, exp);
	}
	
	public void kids() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		logo.click();	
		String parentwindow = driver.getWindowHandle();
		kidscatgry.click();
		Set<String> allwindowshandles     =  driver.getWindowHandles();
		for(String handle: allwindowshandles)
		{
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
			    kidsnew.click();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
	}
	
	public void women()
	{
		
        Actions act = new Actions(driver);
        act.moveToElement(women).perform();
        saree.click();
	    colordrop.click();
	    green .click();
	}
	
	public void men()
	{
		
	        Actions act = new Actions(driver);
	        act.moveToElement(men).perform();
	        mensungls.click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.visibilityOf(discount)).click();
	}
	
	public void screenshot() throws IOException, InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	   logo.click();
	   offers.click();
	   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File offrscrn = 	offerspg.getScreenshotAs(OutputType.FILE);
	   FileHandler.copy(offrscrn,new File("./Screenshot/offr.png"));
	    
	}
	
	public void logout()
	{
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 logo.click();
		 profile.click();
		 logout.click();
	}
}
