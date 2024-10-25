package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.Tutorialsninja_Pgobjmdl_BaseClass;

public class Tutorialsninja_Pgobjmdl_Registrationpage extends Tutorialsninja_Pgobjmdl_BaseClass {
//constructor
	public Tutorialsninja_Pgobjmdl_Registrationpage(WebDriver d2)
	{
		super(d2);
	}
	
	//locators
	
	@FindBy(xpath="//input[@id='input-firstname']")WebElement elefname;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement elelname;
	@FindBy(xpath="//input[@id='input-email']")WebElement eleemail;
	@FindBy(xpath="//input[@id='input-telephone']")WebElement eletphone;
	@FindBy(xpath="//input[@id='input-password']")WebElement elepassword;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement elecpassword;
	@FindBy(xpath="//input[@name='agree']")WebElement eletconditions;
	@FindBy(xpath="//input[@value='Continue']")WebElement elecontinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement eleconfirmation;


//Action methods 
public void firstname(String fname)
{
	elefname.sendKeys(fname);	
}

public void lastname(String lname)
{
	elelname.sendKeys(lname);	
}

public void email(String mail)
{
	eleemail.sendKeys(mail);	
}
public void telephone(String tphone)
{
	eletphone.sendKeys(tphone);	
}
public void password(String passw)
{
	elepassword.sendKeys(passw);	
}
public void confpassword(String confpass)
{
	elecpassword.sendKeys(confpass);	
}
public void termsandconditions()
{
	eletconditions.click();	
}

public void continuebtn()
{
	elecontinue.click();	
}

//if continue button having issue try below solutions

//1)elecontinue.submit();

//2)Actions act=new Actions(d2);
//act.moveToElement(elecontinue).click().perform();

//3)JavascriptExecutor js=mew (JavascriptExecutor)d2
//js.executeScript("arguments[0].click();", elecontinue);

//5)elecontinue.sendKeys(Keys.RETURN);

//6)WebDriverWait mywait=new WebDriverWait(d2,Duration.ofSeconds(10));
//mywait.until(ExpectedConditions.elementToBeClickable(elecontinue)).click();


public String confirmationmsg()
{
try 
{
return(eleconfirmation.getText());	
}
catch(Exception e)
{
return(e.getMessage());	
}
}



}
