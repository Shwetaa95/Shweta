package neoStoxPOMClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility {
	//excel
	//wait
	//screenShot
	//scrolIntoView
	//read data from property file
	public static String readDataFromPropertyFile(String key) throws IOException
	{
	//1. create an object of properties file
	Properties prop= new Properties();
	//2. create object of fileInputStream
	FileInputStream myFile= new
	FileInputStream("C:\\Users\\ASHISH\\eclipse-workspace\\Selenium_MVN\\prop.properties");
	//3. load file 
	prop.load(myFile);
	//4.read data from file
	String value = prop.getProperty(key);
	Reporter.log("Reading data from peroperty file", true);
	Reporter.log("data is "+value, true);
	return value;
	}
	public static String readDataFromExcel(int row, int cell) throws 
	EncryptedDocumentException, IOException
	{
		File myFile= new File("C:\\Users\\ASHISH\\OneDrive\\Documents\\shweta.xlsx");
	Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet9");
	String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
	Reporter.log("Reading data from excel row is "+row+" cell is "+cell, true);
	Reporter.log("data is "+value, true);
	return value;
	}
	public static void implicitWait(int time, WebDriver driver)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	Reporter.log("waiting for "+time+"ms", true);
	}
	public static void takeScreenshot(WebDriver driver,String fileName) throws 
	IOException
	{
		String s = RandomString.make(4);
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File dest= new File("C:\\Users\\screenshot\\"+fileName+s+".png");
	FileHandler.copy(src, dest);
	Reporter.log("taking screenshot ", true);
	Reporter.log("screenShot taken and saved at "+dest, true);
	}
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	Reporter.log("scrolling into view to "+element.getText(), true);
	}
	}

