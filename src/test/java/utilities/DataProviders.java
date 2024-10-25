package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//Data Provider 1
@DataProvider(name="LoginData")
public String [][] getData() throws IOException 
{
	
		//String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";  //taking xl file from testDate
		//or
		String path=".\\testData\\Login_ProperTestData.xlsx";  //taking xl file from testDate
		AllExcelPredefinedMethods xlutil=new AllExcelPredefinedMethods(path);  //creating an object for AllExcelPredefinedMethods
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
	
		String logindata[][]=new String[totalrows][totalcols];   //create for two dimentions array which can store
		 
		for(int i=1;i<=totalrows;i++)//1 //read the data from xl storing in two dimentional array
		{
			for (int j=0;j<totalcols;j++)//0    i is rows j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);    //1,0
				
			}
			
		}
	
	return logindata;    //returning two dimension array 	
}

	
	//Data Provider 2
	
	
	
	//Data Provider 3
	
	
	
	
	
	//Data Provider 4
	

		
	
}
