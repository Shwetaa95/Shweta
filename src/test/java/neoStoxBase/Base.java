package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClass.Utility;
public class Base {
	protected static WebDriver driver;
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	//driver.get("https://neostox.com/");
	driver.get(Utility.readDataFromPropertyFile("url"));

	Utility.implicitWait(1000, driver);
	Reporter.log("launching browser", true);
	}
}
