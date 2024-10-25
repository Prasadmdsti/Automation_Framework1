package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClasses.Tutorialsninja_Pgobjmdl_BaseClass;

public class Tutorialsninja_Pgobjmdl_Loginpage extends Tutorialsninja_Pgobjmdl_BaseClass{

	
//constructor	
	
public 	Tutorialsninja_Pgobjmdl_Loginpage(WebDriver d2)
{
	super(d2);
	
}
	
//locators
@FindBy(xpath="//input[@id='input-email']")WebElement txtemailaddr ;

@FindBy(xpath="//input[@id='input-password']")WebElement txtpassword;

@FindBy(xpath="//input[@value='Login']")WebElement btnlogin;

//if Login button having issue try below solutions

//1)elecontinue.submit();

//2)Actions act=new Actions(d2);
//act.moveToElement(elecontinue).click().perform();

//3)JavascriptExecutor js=mew (JavascriptExecutor)d2
//js.executeScript("arguments[0].click();", elecontinue);

//5)elecontinue.sendKeys(Keys.RETURN);

//6)WebDriverWait mywait=new WebDriverWait(d2,Duration.ofSeconds(10));
//mywait.until(ExpectedConditions.elementToBeClickable(elecontinue)).click();



//3)Action Methods	
public void emailAddress(String emailid)
{
	txtemailaddr.sendKeys(emailid);	
}

public void loginpassword(String lpassword)
{
	txtpassword.sendKeys(lpassword);	
}

public void loginbtnclick()
{
	btnlogin.click();	
}

	
}
