package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

	public static void scrollToElement(WebElement ele, WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(500);

	}

	public static String getproperty(String key) throws IOException {

		String baseurl = System.getProperty("user.dir");
		String filepath = "\\src\\test\\resources\\propertiesFiles\\prod.properties";
		FileReader reader = new FileReader(baseurl + filepath);

		Properties p = new Properties();
		p.load(reader);

		return p.getProperty(key);

	}

}
