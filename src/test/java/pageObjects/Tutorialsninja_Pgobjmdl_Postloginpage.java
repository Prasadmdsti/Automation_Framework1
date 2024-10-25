package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.Tutorialsninja_Pgobjmdl_BaseClass;

public class Tutorialsninja_Pgobjmdl_Postloginpage extends Tutorialsninja_Pgobjmdl_BaseClass{

	//1)constructor method
	
		public Tutorialsninja_Pgobjmdl_Postloginpage(WebDriver d2)
		{
			super(d2);
				
		}
		

	//2)Locators

	@FindBy(xpath="//h2[text()='My Account']") WebElement headingmsg;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement elelogout;


	//3)Action Methods	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return(headingmsg.isDisplayed());	
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
		public void linklogout()
		{
			elelogout.click();
			
	    }

	
	
	
	
	
	
}
