package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Baseclass {

	public static   WebDriver driver;
	String baseurl = "https://www.limeroad.com/?utm_source=google_paid&utm_medium=cpc_paid&utm_campaign=lr_s_brandname_Exact&utm_source=google&utm_medium=remarketing&utm_campaign=lr_s_brandname_Exact_dpa_NK_&gad_source=1&gclid=Cj0KCQjw6PGxBhCVARIsAIumnWbDmhM2nXqQBWtebZjt1HRqX-cBkiNiSj0qpnaTzakiwZWHzNgwljAaAmOHEALw_wcB";
	
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);
	}
	

	
}
