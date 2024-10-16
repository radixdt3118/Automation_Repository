package Get_Data_From_Files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Perform_On_Element {

	public static void interactWith(String xpath, String data, WebDriver driver) throws Exception {
		WebElement element = driver.findElement(By.xpath(xpath));
		
		try {
			switch (element.getTagName()) {
				case "input":
					if (element.toString().contains("checkbox") && data.equals("active")) {
							element.click();
					} else {
						element.sendKeys(data);
					}
					break;
					
				case "select":
					Select dropdown = new Select(element);
					dropdown.selectByVisibleText(data);
					break;
					
				case "button":
					if(element.toString().contains("@data-id")) {
						element.click();
						String xpath_new = String.format("//div[@class='dropdown-menu show']//child::*[contains(text(),'%s')]",data);
						driver.findElement(By.xpath(xpath_new)).click();
					}else {
						element.click();
					}
					break;

				default:
					throw new Exception("Element not interactable");
				}
		} catch (Exception e) {
			//do nothing
		}
	}

	public static void main(String[] args) {

	}

}
