package objectRepo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

public class loginPage {

	public WebDriver driver;

	@FindBy(id = "user-identifier-input")
	public WebElement emailId;

	@FindBy(id = "password-input")
	public WebElement password;

	@FindBy(xpath = "//span[contains(.,'Sign in')]")
	public WebElement signInButtonIcon;

	@FindBy(id = "submit-button")
	public WebElement signInBtn;

	public void loginToApplication() throws IOException {

		try {
			Thread.sleep(3000);
			signInButtonIcon.click();
			Thread.sleep(1000);
			emailId.sendKeys(Utils.getproperty("userName"));
			Thread.sleep(1000);
			password.sendKeys(Utils.getproperty("password"));
			signInBtn.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
