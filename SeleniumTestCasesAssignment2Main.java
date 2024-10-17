package Assignment_Selenium;

import org.testng.annotations.Test;

public class SeleniumTestCasesAssignment2Main {
  @Test
  public void f() throws InterruptedException {
	  SeleniumTestCasesAssignment2 Test = new SeleniumTestCasesAssignment2();
	  Test.beforeClass();
	  
	  Test.Test1();
	  Test.Test2();
	  Test.Test3();	  
	  
	  Test.afterClass();
	  
  }
}
