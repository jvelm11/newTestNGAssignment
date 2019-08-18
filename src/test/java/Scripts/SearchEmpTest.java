package Scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pomPages.SearchUser;

public class SearchEmpTest extends BaseTest{

	String empName= "Heather Ford";
	String srchstr = "heather";
	WebDriverWait wait;
	
	@Test
	public void searchEmployee() throws InterruptedException {
		
		SearchUser srch = new SearchUser(driver);
		
		srch.clickEmployee();
		
		List<WebElement> empList1= srch.getEmpList();
		
		int emplistSize1=empList1.size();
		
		Reporter.log("Records Before Filter --> "+emplistSize1, true);
		
		srch.searchUser(srchstr);
		
		String empl=srch.getEmployeeName();
		
		assertEquals(empl, empName);
		
		List<WebElement> empList= srch.getEmpList();
		
		int emplistSize=empList.size();
		
		assertTrue(emplistSize==1);
		
//		System.out.println(emplistSize);
		
		Reporter.log("Records after Filter --> "+emplistSize, true);
		
//		Thread.sleep(1000);
		
		home.clicktoggle();
		
		home.clicklogOut();
		
	}
}
