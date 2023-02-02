package neoStoxPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Neostoxx {
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private 
	WebElement mobileNumField;
	@FindBy(id = "lnk_signup1") private WebElement signInButton;
	//2.
//	public NeoStoxSignInPage(WebDriver driver)
//	{
//	PageFactory.initElements(driver, this);
//	}
//	//3.
	public void enterMobileNumber(String mobNum)
	{
	mobileNumField.sendKeys(mobNum);
	Reporter.log("Entering mobile number", true);
	}
	public void clickOnSignInButton()
	{
	signInButton.click();
	Reporter.log("Clicking on sign in button", false);
	}

}
