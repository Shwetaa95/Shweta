package validateErrorMessage;

import java.io.IOException;

import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPOMClass.NeoStoxHomePage;
import neoStoxPOMClass.NeoStoxSignInPage;
import neoStoxPOMClass.Utility;

public class ValidateNeostoxErrorMessage extends Base
{
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;	
  @Test
  public void ValidateErrorMsg() throws IOException 
  {
	  home.clickOnSignInButton();
		Utility.implicitWait(1000, driver);
		signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobNum"));
  }
}
