package Custom_Wait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

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
//			time += interval;
//			Thread.sleep(interval);			
		}
		throw new TimeoutException();

	}
}