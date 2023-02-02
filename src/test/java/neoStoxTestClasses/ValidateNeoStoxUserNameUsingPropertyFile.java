package neoStoxTestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPOMClass.NeoStoxDashBoardPage;
import neoStoxPOMClass.NeoStoxHomePage;
import neoStoxPOMClass.NeoStoxPasswordPage;
import neoStoxPOMClass.NeoStoxSignInPage;
import neoStoxPOMClass.Utility;

public class ValidateNeoStoxUserNameUsingPropertyFile extends Base {
	NeoStoxDashBoardPage dash;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage pass;
	@BeforeClass
	 public void launchNeoStoxApp() throws IOException 
	{
	launchBrowser();
	home= new NeoStoxHomePage(driver);
	signIn= new NeoStoxSignInPage(driver);
	pass= new NeoStoxPasswordPage(driver);
	dash= new NeoStoxDashBoardPage(driver);
	}
	@BeforeMethod
	 public void loginToNeoStox() throws EncryptedDocumentException, 
	IOException, InterruptedException
	{
	home.clickOnSignInButton();
	Utility.implicitWait(1000, driver);
	signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobNum"));
	Thread.sleep(1000);
	signIn.clickOnSignInButton();
	Utility.implicitWait(1000, driver);
	pass.enterPassword(Utility.readDataFromPropertyFile("pass"));
	pass.clickOnSubmitButton();
	Utility.implicitWait(1000, driver);
	dash.handlePopUp(driver);
	 }
	@Test
	 public void validateUserName() throws EncryptedDocumentException, IOException
	{
	// Assert.fail();
	Assert.assertEquals(dash.getActualUserName(), 
	Utility.readDataFromPropertyFile("userName"),"Actual and Expected user Names are not matching TC is failed");
	Utility.takeScreenshot(driver, 
	Utility.readDataFromPropertyFile("TCID1"));
	}
	@Test
	public void validateACBalance() throws IOException
	{
	Assert.assertNotNull(dash.getAcBalance(),"AC Balance is null TC failed");
	Utility.takeScreenshot(driver, 
	Utility.readDataFromPropertyFile("TCID2"));
	}
	 @AfterMethod
	 public void logOutFromNeoStox() throws InterruptedException 
	 {
	 dash.logOutFromNeoStox();
	 }
	 
	 @AfterClass
	 public void closeNeoStoxApp() throws InterruptedException
	 {
	 driver.close();
	 Reporter.log("Closing application", true);
	 Thread.sleep(1000);
	 }
}
