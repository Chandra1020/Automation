package objectRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


	public WebDriver driver;
	
	
	 @FindBy(xpath="//span[contains(.,'Sport')]/ancestor::a")
	 public WebElement btnSports;
	 
	 @FindBy(xpath="//span[contains(@class,'ssrcss-qgttmg-AccountText e1gviwgp4')]")
	 public WebElement logedInUser;
	
	
	 
	 @FindBy(xpath="//div[@type='article']//span[contains(@data-testid,'participate:comments')]/ancestor::div[@type='article']//a")
	 public List<WebElement> articlesWithComments;
	 
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
