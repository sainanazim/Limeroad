package pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	
   public Limepg(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements( driver,this);
}
	
	
	public void setvalues(String mobno) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		profile.click();
        login.click();
	    Actions act = new Actions(driver);
	    act.moveToElement(entermob).perform();
	    entermob.clear();
	    entermob.sendKeys(mobno);
	    
	    
	   
	    
	    
	  
	}
	
	public void login() 
	{
		next.click();
		
	}
	
	
	
	
	
	
	
	
}
