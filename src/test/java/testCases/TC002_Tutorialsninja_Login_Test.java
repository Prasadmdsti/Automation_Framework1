package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.Tutorialsninja_TestCases_BaseClass;
import pageObjects.Tutorialsninja_Pgobjmdl_Launchpage;
import pageObjects.Tutorialsninja_Pgobjmdl_Loginpage;
import pageObjects.Tutorialsninja_Pgobjmdl_Postloginpage;

public class TC002_Tutorialsninja_Login_Test extends Tutorialsninja_TestCases_BaseClass{

@Test(groups={"Sanity","Master"})
public void Login_Test()
{

	
	try
	{
	logger.info("******starting TC002_Tutorialsninja_Login_Test**********");	
	
	//launchpage
	Tutorialsninja_Pgobjmdl_Launchpage launchobj=new Tutorialsninja_Pgobjmdl_Launchpage(d2);
	 
	      launchobj.myaccclick();
	      launchobj.loginclick();
	 //loginpage     
 Tutorialsninja_Pgobjmdl_Loginpage loginpageobj=new Tutorialsninja_Pgobjmdl_Loginpage(d2);
	      loginpageobj.emailAddress(prt.getProperty("email"));
	      loginpageobj.loginpassword(prt.getProperty("password"));
	      loginpageobj.loginbtnclick();
//postloginpage
  Tutorialsninja_Pgobjmdl_Postloginpage pstloginpgobj=new Tutorialsninja_Pgobjmdl_Postloginpage(d2);	      
               boolean targetpage=pstloginpgobj.isMyAccountPageExists();
               
  Assert.assertEquals(targetpage, true,"login failed"); //if it fails then only it gives "login failed" msg, if it pass it will not give that msg
  //Assert.assertTrue(targetpage);
  
	}
	catch(Exception e)
	{
	Assert.fail();	
		
	}
	
logger.info("******finish TC002_Tutorialsninja_Login_Test**********");
	
}
	
	
}
