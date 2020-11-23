package producthunt;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetUrlFromSite {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(new FirefoxProfile());
		options.addPreference("dom.webnotifications.enabled", false);
		WebDriver driver = new FirefoxDriver(options);
		String Mainurl = "https://www.producthunt.com/";
		driver.get(Mainurl);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1300)");
		driver.findElement(By.xpath("//span[@class='font_55322 xSmall_088b0 normal_688f6 showHiddenPosts_a74b2 lineHeight_95a63 underline_1c26c uppercase_56449']")).click();
		Thread.sleep(4000);
		List<WebElement> Main = driver.findElements(By.xpath(
		"/html[1]/body[1]/div[1]/div[1]/div[2]/main[1]/div[1]/div[1]/div[2]/div[2]/div[1]/ul[1]/li/div[1]/div[1]/div[1]/h3[1]/a[1]"));
			for (WebElement href : Main) {
				String productlk = href.getAttribute("href");
				System.out.println(productlk);
			}
			}
}
