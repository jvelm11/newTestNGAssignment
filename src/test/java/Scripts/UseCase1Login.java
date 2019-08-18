package Scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.TestUtilities;
import pomPages.HomePage;

public class UseCase1Login extends BaseTest{

	public HomePage homepage;
	
	@Test
	public void checkLoginHome() throws InterruptedException {
		
		homepage= new HomePage(driver);
		
		TestUtilities wish=new TestUtilities();
		
		String expected=wish.expectedWishText("Norma");
		
		String wishtext=homepage.getwishText();
		
		String usertext=homepage.getloginUser();
		
		String welcometext = wishtext +" "+usertext;
		
		assertEquals(welcometext, expected);
		
		
		Reporter.log("Welcome text from HomePage --> "+welcometext, true);
		
		homepage.clicktoggle();
		
		homepage.clicklogOut();
		
	}
	
}
