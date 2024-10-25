package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.Tutorialsninja_Pgobjmdl_BaseClass;

public class Tutorialsninja_Pgobjmdl_Launchpage extends Tutorialsninja_Pgobjmdl_BaseClass{

//1)constructor method
	
	public Tutorialsninja_Pgobjmdl_Launchpage(WebDriver d2)
	{
		super(d2);
			
	}
	

//2)Locators

@FindBy(xpath="//i[@class='fa fa-user']") WebElement elkmyacc;

@FindBy(xpath="//a[normalize-space()='Register']") WebElement eleregister;

@FindBy(linkText="Login")WebElement eleLoginlink;
	

//3)Action Methods	
public void myaccclick()
{
	elkmyacc.click();	
}

public void registerclick()
{
	eleregister.click();	
}

public void loginclick()
{
	eleLoginlink.click();	
}
	
}
