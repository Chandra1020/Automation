package bbcTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepo.HomePage;
import objectRepo.MediaContentPages;
import objectRepo.loginPage;
import utilities.Utils;

public class BaseClass {

	public loginPage loginpg;
	public HomePage homepg;
	public MediaContentPages mediacontentpg;
	String baseurl;
	public static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() throws IOException {

		try {
			WebDriverManager.chromedriver().setup();
			baseurl = Utils.getproperty("url");
			driver = new ChromeDriver();
			driver.navigate().to(baseurl);
			driver.manage().window().maximize();
			loginpg = new loginPage(driver);
			homepg = new HomePage(driver);
			mediacontentpg = new MediaContentPages(driver);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
