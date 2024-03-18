package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static WebDriver chrome(String url)
	{
		
System.setProperty("webdriver.chromedriver","C:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get(url);
	return driver;	

}
}

