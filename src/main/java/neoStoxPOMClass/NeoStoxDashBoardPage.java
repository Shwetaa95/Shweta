package neoStoxPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxDashBoardPage {
	
		@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
		@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement 
		popUpCloseButton;
		@FindBy(id = "lbl_username") private WebElement userName;
		@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
		@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
		public NeoStoxDashBoardPage(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}
		public void handlePopUp(WebDriver driver) throws InterruptedException
		{
	
		if(popUpOkButton.isDisplayed())
		{
			Thread.sleep(5000);
		Utility.scrollIntoView(driver, popUpOkButton);
		popUpOkButton.click();
		Reporter.log("clicking on PopUp OK button", true);
		Thread.sleep(500);
		//Utility.scrollIntoView(driver, popUpCloseButton);
	//	popUpCloseButton.click();
	//	Reporter.log("clicking on PopUp close button", true);
		}
		else 
		{
			Reporter.log("There is pop up", true);	
		}
		}
		public void logOutFromNeoStox() throws InterruptedException
		{
		userName.click();
		Thread.sleep(1000);
		logOutButton.click();
		Reporter.log("Logging out from neoStox", true);
		Thread.sleep(1000);
		}
		public String getActualUserName()
		{
		String actualUserName = userName.getText();
		Reporter.log("getting actual user Name", true);
		Reporter.log("Actual user name is --> "+actualUserName, true);
		return actualUserName;
		}
		public String getAcBalance()
		{
		String balance=acBalance.getText();
		Reporter.log("getting ac balance",true);
		Reporter.log(" balance is"+balance,true);
		return balance;
		}
		}
//miko
//hi 
//hello
 //marshmellow

//ok