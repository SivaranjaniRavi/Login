package youvisit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("file:///home/tyss/Desktop/m.html");
		/*String dd="//div[text()='I am a... *']/..";
		driver.findElement(By.xpath(dd)).click();
		String student="//div[text()='Prospective']";
		driver.findElement(By.xpath(student)).click();
		String opt="//div[text()='Graduate Student']";
		driver.findElement(By.xpath(opt)).click();
		String fname="//div[@title='First Name *']";
		driver.findElement(By.xpath(fname)).sendKeys("Madhuri");
		*/
		List<WebElement> tag = driver.findElements(By.tagName("a"));
		WebElement gt = tag.get(1);
		//System.out.println(gt);
		gt.click();
		

	}

}
