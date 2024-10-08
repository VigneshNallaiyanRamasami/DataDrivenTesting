package Assignment_Selenium;

import org.testng.annotations.Test;

public class SeleniumTestCasesAssignment1Main {
  @Test
  public void TestCasesExecution() throws InterruptedException {
	  SeleniumTestCasesAssignment1 TestCases = new SeleniumTestCasesAssignment1();
	  TestCases.beforeClass();
	  
	  //TestCases.TC1(); 
	  //TestCases.TC2(); 
	  //TestCases.TC3(); 
	  TestCases.TC4(); 
	  
	  TestCases.afterClass();
	    	 
  }
}
