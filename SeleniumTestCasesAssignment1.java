package Assignment_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTestCasesAssignment1 {
	WebDriver driver;
  @Test 
  public void TC1 () throws InterruptedException {
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(4000);
	
	//Retrieving Error Message 
	WebElement ErrorField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
	String RetreivedErrorMessage = ErrorField.getText();
	System.out.println("Retreived Error Message is: " + RetreivedErrorMessage);
	
	//Verification
	String ExpectedErrorMessage = "Invalid credentials";
	System.out.println("Expected Error Message is: " + ExpectedErrorMessage);
	
	if (RetreivedErrorMessage.equals(ExpectedErrorMessage))
		{
		System.out.println("Retreived Error Message is present and matches exactly with the Expected Error Message");
		}else {
		System.out.println("Retreived Error Message is present and doesn't match with the Expected Error Message");
		}
  }
  
  @Test
  public void TC2 () throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("user123");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(4000);
	  
	//Retrieving Error Message 
	  WebElement ErrorField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
	  String RetreivedErrorMessage = ErrorField.getText();
	  System.out.println("Retreived Error Message is: " + RetreivedErrorMessage);
		
	//Verification
	  String ExpectedErrorMessage = "Invalid credentials";
	  System.out.println("Expected Error Message is: " + ExpectedErrorMessage);
		
		if (RetreivedErrorMessage.equals(ExpectedErrorMessage))
			{
			System.out.println("Retreived Error Message is present and matches exactly with the Expected Error Message");
			}else {
			System.out.println("Retreived Error Message is present and doesn't match with the Expected Error Message");
			}
  }
  
  @Test
  public void TC3 () throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("user");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(4000);
	  
	//Retrieving Error Message 
		WebElement ErrorField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
		String RetreivedErrorMessage = ErrorField.getText();
		System.out.println("Retreived Error Message is: " + RetreivedErrorMessage);
		
	//Verification
		String ExpectedErrorMessage = "Invalid credentials";
		System.out.println("Expected Error Message is: " + ExpectedErrorMessage);
		
		if (RetreivedErrorMessage.equals(ExpectedErrorMessage))
			{
			System.out.println("Retreived Error Message is present and matches exactly with the Expected Error Message");
			}else {
			System.out.println("Retreived Error Message is present and doesn't match with the Expected Error Message");
			}
  }
		
  @Test
  public void TC4 () throws InterruptedException {
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(4000);
			  
	//Retrieving Dashboard Page Title and Verify
	  WebElement DashBoardPageTitleField = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
	  String RetreivedDashBoardPageTitle = DashBoardPageTitleField.getText();
	  System.out.println("Dashboard Page Title is: " + RetreivedDashBoardPageTitle);
				
	//Verification
	  String ExpectedDashboardPageTitle = "Dashboard";
	  System.out.println("Retreived Expected Dashboard Title is: " + ExpectedDashboardPageTitle);
				
	  if (RetreivedDashBoardPageTitle.equals(ExpectedDashboardPageTitle))
	  	{
		System.out.println("Retreived DashBoard Page Title matches exactly with the Expected Dashboard Page Title ");
		  }else {
		System.out.println("Retreived DashBoard Page Title doesn't match with the Expected Dashboard Page Title ");
		}
	  
	//Logout
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")).click();
	 	  
  }
  
 @BeforeClass
  public void beforeClass() throws InterruptedException {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Thread.sleep(4000);
  }
  
 @AfterClass
 public void afterClass() throws InterruptedException {
	 Thread.sleep(4000);
	 driver.close();	 
 }
}
