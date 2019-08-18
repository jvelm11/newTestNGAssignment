package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

@FindBy(xpath="//form[@novalidate='novalidate']//button")
private WebElement LoginButton;


public LoginPage(WebDriver driver) {
	
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
}

public HomePage clickLoginButton()
{
	LoginButton.click();
	
	return new HomePage(driver);
	
}

}
