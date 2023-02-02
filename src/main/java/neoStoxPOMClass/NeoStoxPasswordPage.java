package neoStoxPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPage {
	@FindBy(id = "txt_accesspin") private WebElement passwordField;
	@FindBy(id = "lnk_submitaccesspin") private WebElement submitButton;
	public NeoStoxPasswordPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this );
	}
	public void enterPassword(String password)
	{
	passwordField.sendKeys(password);
	Reporter.log("entering password", true);
	}
	public void clickOnSubmitButton() throws InterruptedException
	{
	Thread.sleep(500);
	submitButton.click();
	Reporter.log("clicking on submit button", true);
	}
}
