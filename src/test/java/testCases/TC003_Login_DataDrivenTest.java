package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.Tutorialsninja_TestCases_BaseClass;
import pageObjects.Tutorialsninja_Pgobjmdl_Launchpage;
import pageObjects.Tutorialsninja_Pgobjmdl_Loginpage;
import pageObjects.Tutorialsninja_Pgobjmdl_Postloginpage;
import utilities.DataProviders;


public class TC003_Login_DataDrivenTest extends Tutorialsninja_TestCases_BaseClass {

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups={"DataDriven","Master"})  //calling Data Provider class from utilities folder in this way as our class already extended
	public void Login_DataDrivenTest(String email,String pwd, String exspected)
	{
	
		try
		{
		logger.info("******starting TC003_Login_DataDrivenTest**********");	
		
		//launchpage
		Tutorialsninja_Pgobjmdl_Launchpage launchobj=new Tutorialsninja_Pgobjmdl_Launchpage(d2);
		 
		      launchobj.myaccclick();
		      launchobj.loginclick();
		 //loginpage     
	 Tutorialsninja_Pgobjmdl_Loginpage loginpageobj=new Tutorialsninja_Pgobjmdl_Loginpage(d2);
		      loginpageobj.emailAddress(email);
		      loginpageobj.loginpassword(pwd);
		      loginpageobj.loginbtnclick();
	//postloginpage
	  Tutorialsninja_Pgobjmdl_Postloginpage pstloginpgobj=new Tutorialsninja_Pgobjmdl_Postloginpage(d2);	      
	             boolean targetpage=pstloginpgobj.isMyAccountPageExists();
	               
	               /*Data is valid  -  login sucess  -  test pass----logout
	               Data is valid  -  login failed  -  test fail */

	                    
	          if(exspected.equalsIgnoreCase("Valid"))
	          {
	        	 if(targetpage==true)
	        	 {
	        		 pstloginpgobj.linklogout();
	        		 Assert.assertTrue(true);
	        	 }
	        	 else
	        	 {
	        		 Assert.assertTrue(false);
	        	 }     	 
	          }
	          
	          
	          
	           /*Data is invalid  -  login sucess  -  test fail----logout
	               Data is invalid  -  login fail  -  test pass
	               */              
	              

	          if(exspected.equalsIgnoreCase("Invalid"))
	          {
	        	 if(targetpage==true)
	        	 {
	        		 pstloginpgobj.linklogout();
	        		 Assert.assertTrue(false);
	        	 }
	        	 else
	        	 {
	        		 Assert.assertTrue(true);
	        	 }     	 
	          }
	     
	          
		}
		catch(Exception e)
		{
		Assert.fail();	
			
		}
		
		
	logger.info("******finish TC003_Login_DataDrivenTest**********");
		
	}
		
				
	}
	
	

