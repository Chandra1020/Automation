package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MediaContentPages {

	public WebDriver driver;

	@FindBy(xpath = "//button[@class='view-comments-button']")
	public WebElement btnComments;

	@FindBy(xpath = "//div[@class='comments__user-interactions-container']//span[contains(.,'You’re signed in')]")
	public WebElement textSignedIn;
	
	@FindBy(xpath = "//div[@class='comments__user-interactions-container']//a[@class='comments__display-name']")
	public WebElement textDisplayName;

	
	@FindBy(xpath = "//div[@class='comments__user-interactions-container']//textarea[@placeholder='Add your comment…']")
	public WebElement commentsSection;
	
	
	@FindBy(xpath = "//p[@class='comments__signin--prompt']")
	public WebElement signInPrompt;
	
	
	public MediaContentPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
