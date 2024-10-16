package Custom_Wait;

import java.util.concurrent.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Custom_wait {

	public static WebElement customFindElement(String xpath, WebDriver driver) throws Exception {

		int count = 0;
		int limit = 1000;

		while (count <= limit) {
			try {
				WebElement element = driver.findElement(By.xpath(xpath));
				if (element.isDisplayed() && element.isEnabled()) {
					return element;
				}
			} catch (Exception e) {
				// do nothing
			}
			count++;
//			time += interval;
//			Thread.sleep(interval);			
		}
		throw new TimeoutException();

	}
}