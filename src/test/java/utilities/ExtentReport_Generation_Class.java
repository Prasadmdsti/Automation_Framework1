package utilities;

import java.awt.Desktop;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import baseClasses.Tutorialsninja_TestCases_BaseClass;

//ExtentReport----->it used to report generation in TestNG(it works like Listeners but most preferred compared with listeners)

//Step1)create test case
//step2)create ExtentReport class
//step3)create xml file and include both test case & ExtentReport class

//there are 2- ways to create ExtentReport class

//1)

/* Class ExtentReport extends TestListenerAdapter
{

}
*/


//2)

/* Class ExtentReport implements ITestListener
{

}
*/



public class ExtentReport_Generation_Class implements ITestListener
//ITestListener----it is a interface so we implemented here, so interface methods access modifier is default, when interface implemented that access modifier need to change from default to public
{

	public ExtentSparkReporter sparkReporter;    //UI of the report
	public ExtentReports extent;  //Populate common info on the report
	public ExtentTest test;   //creating testcase entries in the report and update status of the test methods
	String  repName;
	
	 public void onStart(ITestContext testcontext){
		 
			/* SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 Date dt=new Date();
		 String timestamp =sdf.format(dt); */
		//or 
		 String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); //time stamp generation
		 
		 repName ="Test-Report-"+timestamp+".html"; //file formating
		 //sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\"+repName);  //reports generation path
		 //or
		 sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);  //reports generation path
		 
		 sparkReporter.config().setDocumentTitle("Tutorialsninja Automation Report");//Title of the report
		 sparkReporter.config().setReportName("Tutorialsninja Functional Testing"); //name of the report
		 sparkReporter.config().setTheme(Theme.STANDARD);
		 
		 extent=new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("Application", "Tutorialsninja");
		 extent.setSystemInfo("Module", "Admin");
		 extent.setSystemInfo("Sub Module", "Customers");
		 extent.setSystemInfo("User Name", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 
		 String os =testcontext.getCurrentXmlTest().getParameter("os");  //getting os name from xml file parameters
		 extent.setSystemInfo("Operating System", os);
		 
		 String browser=testcontext.getCurrentXmlTest().getParameter("browser");  //getting browser name from xml file parameters
		 extent.setSystemInfo("Browser", browser);
		 
		 List<String> includedGroups=testcontext.getCurrentXmlTest().getIncludedGroups();  //getting groups names from xml file which are included
		 if(!includedGroups.isEmpty()) {
		 extent.setSystemInfo("Groups", includedGroups.toString());
		 }
		 
}
	 
	/* public void onTestStart(ITestResult result) {
		    System.out.println("This will trigger whenever each single test method start.....................");
		  }  */
	
	 public void onTestSuccess(ITestResult result) {
		 
		 test=extent.createTest(result.getTestClass().getName());  //create new entry in the report
		 test.assignCategory(result.getMethod().getGroups());//to display groups in report
		 test.log(Status.PASS,result.getName()+"got Successfully excuted");  //update status Sucessfull
		 
		  }
	 
	 public void onTestFailure(ITestResult result) {

		 test=extent.createTest(result.getTestClass().getName());  //create new entry in the report
		 test.assignCategory(result.getMethod().getGroups());//to display groups in report
		 
		 test.log(Status.FAIL,result.getName()+"got Failed");  //update status pass/fail/skip
		 
		 test.log(Status.INFO,result.getThrowable().getMessage());// to know the error
			 
	 try
	 {
		String imgPath=new Tutorialsninja_TestCases_BaseClass().captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(imgPath);
	 }
catch(Exception e)
	 {
	e.printStackTrace();
	 }
	 
	 }
	 
	 
	 public void onTestSkipped(ITestResult result) {

		 test=extent.createTest(result.getTestClass().getName());  //create new entry in the report
		 test.assignCategory(result.getMethod().getGroups());//to display groups in report
		 test.log(Status.SKIP,result.getName()+"got skipped");  //update status pass/fail/skip
		 test.log(Status.INFO,result.getThrowable().getMessage());// to know the error
		 
		  }
	 
	 
	 public void onFinish(ITestContext context) {
		 
		 extent.flush();   // it is mandatory otherwise report wont be generated
		 
     //for to open the generated report in browser--working fine
		 
	/*String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		 //or
	//String pathOfExtentReport=".\\reports\\"+repName; //not working this type of path here  need to check
	File extentReport=new File(pathOfExtentReport);
	
	try
	{
		Desktop.getDesktop().browse(extentReport.toURI());
	}
	catch(Exception e)
	{
		
	e.printStackTrace();	
	} */
	
	//for sending email automatically---not working as of now need to check
	
/*try {
		
	URL url=new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
	ImageHtmlEmail email=new ImageHtmlEmail();
	email.setDataSourceResolver(new DataSourceUrlResolver(url));
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("prasadmdsti@gmail.com","Swati4747@cse"));
	email.setSSLOnConnect(true);
	email.setFrom("prasadmdsti@gmail.com");//sender
	email.setSubject("Test Results");
	email.setMsg("Please find the attached test report");
	email.addTo("prasadmdstiab@gmail.com");//receiver
	email.attach(url,"extendt report","please check report");
	email.send();
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}  */
	
	
		  }

	
	
}
