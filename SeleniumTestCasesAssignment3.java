package Assignment_Selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestCasesAssignment3 {
	WebDriver driver;
  @Test (enabled = true)
  public void readFromExcelFile() {
	  String excelFilePath = "C:\\Users\\nrvig\\Downloads\\BUSYQA\\Assignment\\MaturityValCalc.xlsx";
	  
	  try {
		  // Read from excel file
		  FileInputStream inputStream = new FileInputStream(excelFilePath);
		  XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		  
		  //Go to sheet to read from
		  //sheet sheet = workbook.getSheetAt(0);
		  XSSFSheet sheet = workbook.getSheet("maturityValCalculator");
		  
		  //Find the Number of Rows and Column
		  //Number of Rows and Column
		  int rownum = sheet.getLastRowNum();
		
		  //Integrate over Rows and column
		  for(int i = 1; i<= rownum; i++) {
			  XSSFRow row = sheet.getRow(i);
			  	int principal = (int) row.getCell(0).getNumericCellValue();
			  	String ROI = row.getCell(1).toString();
			  	int periodVal = (int) row.getCell(2).getNumericCellValue();
			  	String PeriodType = row.getCell(3).toString();
			  	String Frequency = row.getCell(4).toString();
			  	System.out.println("Value is: " +principal +", " +ROI +", " +periodVal +" " +PeriodType +", " +Frequency);
			  	
			  	String[] result = validateCalculate(String.valueOf(principal), ROI, String.valueOf(periodVal), PeriodType ,Frequency);
		//	  }
			  	XSSFCell MaturityValueCell=row.createCell(5);
			  	MaturityValueCell.setCellValue(result[0]);
			  	XSSFCell InterestEarnedCell=row.createCell(6);
			  	InterestEarnedCell.setCellValue(result[1]);
			  	
		  }
		  
		  FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		 //Close Stream
		  workbook.write(outputStream);
		  workbook.close();
	  } catch (IOException e) {
		  e.printStackTrace();  
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
  }
  
  @AfterTest
  public void afterTest() { 
	  if (driver != null) {
	       driver.quit();
	    }
  }
  
  public String[] validateCalculate(String principal, String ROI, String periodVal, String PeriodType, String Frequency ) {
	  
	    
	  
	  driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
	  driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal);
	  driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(ROI);
	  driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(periodVal);
	  WebElement tenurePeriodDropdown = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
	  tenurePeriodDropdown.sendKeys(PeriodType);
	  WebElement FrequencyDropdown= driver.findElement(By.xpath("//select[@id='frequency']"));
	  FrequencyDropdown.sendKeys(Frequency);
	  
	// Pop UP Management
	   try {
          WebElement popupClose = driver.findElement(By.xpath("//button[@id='wzrk-cancel']"));
          popupClose.click();         
	   }catch (Exception e) {
   	    System.out.println("Popup Not Found");
      }
	   
	 //Click calculate button 
	  driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[1]")).click();
	  
	  String MaturityValue = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]")).getText();
	  String InterestEarned = driver.findElement(By.xpath("//*[@id=\"resp_intval\"]")).getText();
	  System.out.println("MAturity Value is: " +MaturityValue);
	  System.out.println(InterestEarned);
	  System.out.println();
	  
	 String[] result = {MaturityValue, InterestEarned};
	  
	  return result;
}
}  
