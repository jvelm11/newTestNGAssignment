package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	@FindBy(css=".greeting")
	private WebElement wishText; 
		
	@FindBy(css=".person-name")
	private WebElement personName;
	
	@CacheLookup
	@FindBy(xpath="//div[@class='x-icon-el x-font-icon x-fa fa-bars']/../../following-sibling::button") //Toggle Button
	private WebElement toggle;
	
	@FindBy(xpath="//div[text()='Log out']/ancestor::div[contains(@class,'x-layout-box-item x-layout-vbox-item')]/button")
	private WebElement logOut;
	
	@FindBy(xpath="//span[text()='Home']/..")
	private WebElement homeBTN;
	
	@FindBy(xpath="//div[text()='Edit']/../../following-sibling::button")
	private WebElement editButton;
	
	@FindBy(xpath="//span[text()='First Name']/../following-sibling::div//input")
	private WebElement firstNameTB;
	
	@FindBy(xpath = "//div[text()='Save']")
	private WebElement saveBTN;
	
	@FindBy(xpath="//div[text()='Read-only session, data not updated']")
	private WebElement readOnlyText;
		
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}
	
	public String getwishText() {
		
		return wishText.getText();
	}
	
	public String getloginUser() {
		
		return personName.getText();
	}
	
	public void clicktoggle() {
		toggle.click();
		
	}
	
	public void clicklogOut() {
		
		logOut.click();
	}
	
	public void findaUserandClick(String user) {
		
		String xp="//div[text()='"+user+"']";
		
		By findUser= By.xpath(xp);
		
		driver.findElement(findUser).click();
		
	}
	
	public void clickEditButton() {
		
		editButton.click();
		
	}
	
	public void editFirstName(String fname) {
		
		firstNameTB.sendKeys(fname);
		
	}
	
	public void clickSaveButton() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(saveBTN).click().perform();
		
	}
	
	public String getReadOnlyText() {
		
		waitforTextRead();
		
		return readOnlyText.getText();
	}
	
	public void clickHomeButton() {
		
		homeBTN.click();
	}
	
	public void waitforTextRead() {
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Read-only session, data not updated']")));
		
	}
	
	public void moveTotoggleandClick() {
		
		Actions action = new Actions(driver);
		
		action.moveToElement(toggle).pause(1000).click(toggle).perform();
				
		
	}
	
	
}
