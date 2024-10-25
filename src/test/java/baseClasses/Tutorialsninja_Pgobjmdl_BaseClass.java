package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Tutorialsninja_Pgobjmdl_BaseClass {

		WebDriver d2;
		
		//constructor is common for all the page object models
		
		public Tutorialsninja_Pgobjmdl_BaseClass(WebDriver d2)
		{
			this.d2=d2;
			PageFactory.initElements(d2, this);
			
		}
	
}
