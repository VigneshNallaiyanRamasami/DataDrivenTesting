package Assignment_Selenium;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class SeleniumTestCasesAssignment2 {
  WebDriver driver;
  @Test
  public void Test1() throws InterruptedException {
	  
	  //Identify the table
	  WebElement TableEle = driver.findElement(By.xpath("//*[@id=\"table2\"]"));
	  
	  //find all rows in the table
	  List<WebElement> rows = TableEle.findElements(By.tagName("tr"));
	  //print the number of rows in the table
	  System.out.println("Number of rows in the table is: "+rows.size());
	  
	  //finding columns for the each rows in the table 
	  for (WebElement row : rows) { //for each element(row) in the array 
		  List<WebElement> columns = row.findElements(By.tagName("td"));			  
	     //iterate through columns and print data  
		 for (WebElement column : columns) { 
				System.out.print(column.getText() + "\t" );
				  }	
		 System.out.println();
	  	}
	  }  
	
  @Test
  public void Test2() throws InterruptedException {
  	//Iterate through Column and print data
	  WebElement TableEle = driver.findElement(By.xpath("//*[@id=\"table2\"]"));
	  List<WebElement> rows = TableEle.findElements(By.tagName("tr"));
	  
	//Validate Last name
	  System.out.println(); // Move to the next line
	  String[] lastNames = {"Smith" ,"Bach" , "Doe", "Conway"};
	     for (int i=1; i <rows.size(); i++ ) {    // 1<5
		   WebElement row = rows.get(i);
		   List<WebElement> columns = row.findElements(By.tagName("td"));
		   WebElement Firstcolumn = columns.get(0);
			String FirstColumnName = Firstcolumn.getText();
			System.out.println("LastName from Array is " + lastNames[i-1] + ", LastName from table is " +FirstColumnName);
			Assert.assertEquals(lastNames[i-1], FirstColumnName);
	     }
	     
   //Validate First name   
	 System.out.println(); // Move to the next line 
	 String[] FirstNames = {"John" ,"Frank" , "Jason", "Tim"};
	 	for (int i=1; i <rows.size(); i++ ) {    // 1<5
		   WebElement row = rows.get(i);
		   List<WebElement> columns = row.findElements(By.tagName("td"));
	   	  	WebElement Secondcolumn = columns.get(1);
			String SecondcolumnName = Secondcolumn.getText();
			System.out.println("FirstName from Array is " + FirstNames[i-1] + ", FirstName from table is " +SecondcolumnName);
			Assert.assertEquals(FirstNames[i-1], SecondcolumnName);
	 	}
	 	
	///Validate Email   
	System.out.println(); // Move to the next line 
	String[] Emails = {"jsmith@gmail.com" ,"fbach@yahoo.com" , "jdoe@hotmail.com", "tconway@earthlink.net"};
		 for (int i=1; i <rows.size(); i++ ) {    // 1<5
			WebElement row = rows.get(i);
	        List<WebElement> columns = row.findElements(By.tagName("td"));	
			WebElement Thirdcolumn = columns.get(2);
			String ThirdcolumnName = Thirdcolumn.getText();
			System.out.println("Email from Array is " + Emails[i-1] + ", Email from table is " +ThirdcolumnName);
			Assert.assertEquals(Emails[i-1], ThirdcolumnName);
		 }
	
	//Validate Due 
	System.out.println(); // Move to the next line 
	String[] Dues = {"$50.00" ,"$51.00" , "$100.00", "$50.00"};
	       for (int i=1; i <rows.size(); i++ ) {    // 1<5
		   WebElement row = rows.get(i);
		   List<WebElement> columns = row.findElements(By.tagName("td"));			
		   WebElement Fourthcolumn = columns.get(3);
		   String FourthcolumnName = Fourthcolumn.getText();
		   System.out.println("Due from Array is " + Dues[i-1] + ", Due from table is " +FourthcolumnName);
		   Assert.assertEquals(Dues[i-1], FourthcolumnName);
	    }
	  System.out.println(); // Move to the next line
		
  }
  

  @Test
  public void Test3() throws InterruptedException {
  	//Iterate through Column and print data
	  WebElement TableEle = driver.findElement(By.xpath("//*[@id=\"table2\"]"));
	  List<WebElement> rows = TableEle.findElements(By.tagName("tr"));
	  WebElement row = rows.get(2);
	  List<WebElement> columns = row.findElements(By.tagName("td"));
	  WebElement Fifthcolumn = columns.get(4);
			String FifthColumnName = Fifthcolumn.getText();
			System.out.println(FifthColumnName);
			driver.get(FifthColumnName);
			Thread.sleep(4000);
			String PageTitle = driver.getTitle();
			System.out.println("Title of the Page is: " +PageTitle);
	     }
	     
  @BeforeClass
  public void beforeClass() throws InterruptedException {
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://the-internet.herokuapp.com/tables");
		  Thread.sleep(4000);
	   }

  @AfterClass
  public void afterClass() throws InterruptedException {
			 Thread.sleep(4000);
			 driver.close();	
	  
  }

}
