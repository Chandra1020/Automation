package bbcTest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Utils;

public class viewingCommentsTest extends BaseClass {

	@Test(enabled = true, priority = 0, description = "Verify Comments can be viewed but comments cannot be posted when user is not signed in ")
	public void verifyCommentsDisplayed() {
		try {
			homepg.btnSports.click();

			// Find Article with Comments
			List<WebElement> articles = homepg.articlesWithComments;
			WebElement ele = articles.get(0);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);

			Utils.scrollToElement(mediacontentpg.btnComments, driver);
			mediacontentpg.btnComments.click();

			boolean signInPrompt = mediacontentpg.signInPrompt.isDisplayed();
			Assert.assertTrue(signInPrompt, "Verify signin prompt is displayed");

			boolean signedInText = mediacontentpg.textSignedIn.isDisplayed();
			Assert.assertFalse(signedInText);

			String displayedName = mediacontentpg.textDisplayName.getAttribute("innerText");
			Assert.assertFalse(displayedName.equals(Utils.getproperty("displayName")), "Display Name is dispolayed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(enabled = true, priority = 1, description = "Verify Comments can be viewed and can be posted when user is signed in ")
	public void VerifyPostingofComments() throws IOException, InterruptedException {
		try {
			loginpg.loginToApplication();
		
			String logedinUser = homepg.logedInUser.getAttribute("innerText");
			Assert.assertTrue(logedinUser.equals(Utils.getproperty("displayName")), "User is Loged in");

			homepg.btnSports.click();

			
			List<WebElement> articles = homepg.articlesWithComments;
			WebElement ele = articles.get(0);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);

			Utils.scrollToElement(mediacontentpg.btnComments, driver);
			mediacontentpg.btnComments.click();

			WebDriverWait ws = new WebDriverWait(driver, 5000);
			ws.until(ExpectedConditions.textToBePresentInElement(mediacontentpg.textDisplayName,
					Utils.getproperty("displayName")));

			boolean signedInText = mediacontentpg.textSignedIn.isDisplayed();
			Assert.assertTrue(signedInText);
			String displayedName = mediacontentpg.textDisplayName.getAttribute("innerText");
			Assert.assertTrue(displayedName.equals(Utils.getproperty("displayName")));

			boolean commentSection = mediacontentpg.commentsSection.isEnabled();
			Assert.assertTrue(commentSection);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
