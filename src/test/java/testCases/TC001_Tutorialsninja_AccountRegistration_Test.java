package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClasses.Tutorialsninja_TestCases_BaseClass;
import pageObjects.Tutorialsninja_Pgobjmdl_Launchpage;
import pageObjects.Tutorialsninja_Pgobjmdl_Registrationpage;

public class TC001_Tutorialsninja_AccountRegistration_Test extends Tutorialsninja_TestCases_BaseClass {

	
@Test(groups={"Regression","Master"})
public void Test_Account_Registration()
{
logger.info("******starting TC001_AccountRegistrationTest**********");
	
try
{
	Tutorialsninja_Pgobjmdl_Launchpage launchobj=new Tutorialsninja_Pgobjmdl_Launchpage(d2);
	launchobj.myaccclick();
logger.info("******starting TC001_AccountRegistrationTest**********");
	launchobj.registerclick();
logger.info("********* myaccclick**********");
	
	Tutorialsninja_Pgobjmdl_Registrationpage registrationobj=new Tutorialsninja_Pgobjmdl_Registrationpage(d2);
	/*//hardcoded input values
	registrationobj.firstname("John1");
	registrationobj.lastname("David2");
	registrationobj.email("john1211David1@gmail.com");
	registrationobj.telephone("23234345");
	registrationobj.password("xyz1232");
	registrationobj.confpassword("xyz1232");
	registrationobj.termsandconditions();
	registrationobj.continuebtn();*/
	
	//Randomly providing input values
logger.info("******Registration fields filling**********");
		registrationobj.firstname(randomString().toUpperCase());
		registrationobj.lastname(randomString().toUpperCase());
		registrationobj.email(randomString()+"@gmail.com");
		registrationobj.telephone(randomnumber());
		
		String compassword=randomalphnumeric();//if directly given every time new randomalphnumeric string will get generates
		
		registrationobj.password(compassword);
		registrationobj.confpassword(compassword);
		registrationobj.termsandconditions();
		registrationobj.continuebtn();
logger.info("******Assertion checking**********");

String confirtext=registrationobj.confirmationmsg();

if(confirtext.equals("Your Account Has Been Created!"))
{
Assert.assertTrue(true);

}
else
{
	logger.error("Test failed....");
	logger.debug("Test failed....");
	Assert.assertTrue(false);
}

}
catch(Exception e)
{

Assert.fail();
}
logger.info("******Finished TC001_AccountRegistrationTest**********");

}
	





}
