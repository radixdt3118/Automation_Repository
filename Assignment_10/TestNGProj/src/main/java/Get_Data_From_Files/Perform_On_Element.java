package Get_Data_From_Files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Perform_On_Element {

	public static void interactWith(String xpath, String data, WebDriver driver) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			if (element.getTagName().equals("input")) {
				if (element.toString().contains("checkbox")) {
					if (data.equals("active")) {
						element.click();
					}
				} else {
					element.sendKeys(data);
				}
			} else if (element.getTagName().equals("select")) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(data);//
			} else if (element.getTagName().equals("button")) {
				element.click();
				String xpath_new = String.format("//div[@class='dropdown-menu show']//child::*[contains(text(),'%s')]",data);
				driver.findElement(By.xpath(xpath_new)).click();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {

	}

}
