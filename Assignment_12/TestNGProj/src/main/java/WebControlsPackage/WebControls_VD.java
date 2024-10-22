package WebControlsPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebControls_VD{

	
	//Retrieve data from excel
	public static String getData(String key,int row_num,String sheet_name,File fileobj) throws Exception {
//		FileInputStream fis = new FileInputStream(fileobj);
		XSSFWorkbook wb = new XSSFWorkbook(fileobj);
		XSSFSheet sheet = wb.getSheet(sheet_name);
		int row_size = sheet.getLastRowNum();	//Get number of rows in excel sheet
		int col_size = sheet.getRow(0).getLastCellNum()-1;  //Get number of columns in an excel row
		String value=null;
		
		if(row_num>row_size) {
			System.err.print("Invalid Row number!!!\n");
			throw new IndexOutOfBoundsException();
		}
		
		Row row = sheet.getRow(0);	//For header
		for(int c=0;c<=col_size;c++) {
			if(row.getCell(c).toString().equalsIgnoreCase(key)) {
				value = sheet.getRow(row_num).getCell(c).toString();
				break;
			}
		}		
		return value;	
	}
	
	public static void main(String[] args) throws Exception {
		File fileobj = new File("TestData/ProductData.xlsx");
		getData("Credentials", 1, "username", fileobj);
	}
	
	// Write/Update data to file
	public static void writeToExcel(String value , String key , int row_num ,String sheet_name , File file) throws IOException, InvalidFormatException {
		FileInputStream fis = new FileInputStream(file);	
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheet(sheet_name);
		
		Row row = sheet.getRow(0);
		int col_index = -1;
		for (Cell cell : row) {
			if(cell.toString().equalsIgnoreCase(key)) {
				col_index=cell.getColumnIndex();				
			}
		}
		
		Row target_row = sheet.getRow(row_num);	
		Cell target_cell = target_row.createCell(col_index);
		target_cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		System.out.println("File write success");
	}
	
	//Get XPath from properties file
	public static String getXPath(String key,File file) throws IOException {
		
		String xpath_value = null;
		FileInputStream file_i = new FileInputStream(file);	
		Properties obj = new Properties();
		obj.load(file_i);
		xpath_value = obj.getProperty(key);
		return xpath_value;
	}
	
	//Get keys from .properties file
	public static String[] getKEYS(File file) throws IOException {
		
		String xpath_value = null;
		FileInputStream file_i = new FileInputStream(file);	
		Properties obj = new Properties();
		obj.load(file_i);
		
		Object[] list_obj=obj.keySet().toArray();
		return Arrays.copyOf(list_obj, list_obj.length,String[].class);
	}
	
	//Take screenshots	
	public static void takeScreenshot(String name,WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		String screenshot_dir = "Screenshots/";
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(screenshot_dir+name));
	}
	
	//Highlight elements
	public static void highlightElement(WebElement element,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 3px solid red;');", element);
	}	

	//Interact with element dynamically
	public static void interactWith(String xpath, String data, WebDriver driver) throws Exception{
		WebElement element = customFindElementV2(xpath,driver);
//		WebElement element = driver.findElement(By.xpath(xpath));
		switch (element.getTagName()) {
			case "input":
				if (element.toString().contains("checkbox") && data.equals("active")) {
						element.click();
				} else if(element.toString().contains("radio")) {
					String xpath_new = String.format(xpath,data);
					driver.findElement(By.xpath(xpath_new)).click();
				} 
				else {
					if(element!=null) {
						element.clear();
					}
					element.sendKeys(data);
				}
				break;
				
			case "select":
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(data);
				break;
				
			case "button":
				if(element.toString().contains("@data-id")) {
					//Handles bootstrap dropdown
					element.click();
					String xpath_new = String.format("//div[@class='dropdown-menu show']//self::span[(contains(text(),'%s'))]",data);
					driver.findElement(By.xpath(xpath_new)).click();
				} else if(element.toString().contains("multiselect dropdown-toggle")){
					//Handles hybrid bootstrap dropdown(dropdown + chekcboxes)
					element.click();
					String[] data_splitted = data.split(",");
					for (String check : data_splitted) {
						String xpath_new = String.format("//ul[@class='multiselect-container dropdown-menu show']//self::label[contains(text(),'%s')]", check);
						WebElement checkbox = driver.findElement(By.xpath(xpath_new));
						checkbox.click();
					}
					element.click();
				}
				else {
					try {							
						element.click();
						System.out.println("Worked without action");
					} catch (ElementClickInterceptedException e) {
						Actions actions = new Actions(driver);
						actions.moveToElement(element).click().perform();
						System.out.println("Action performed");
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				break;

			default:
				element.click();
			}
	}	

	//Interact With Elements (Overloading above method - Only for buttons)
	public static void interactWith(String xpath, WebDriver driver) throws Exception{
		WebElement element = customFindElementV2(xpath,driver);
		
		try {
			element.click();			
		} catch (ElementClickInterceptedException e) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();						
		} catch (Exception e) {
			//do nothing
			e.getLocalizedMessage();
		}
	}
	
	//Custom Find element with polling loop
	public static WebElement customFindElementV2(String xpath, WebDriver driver) throws Exception {
		int count=0;
		int limit=1000;
		
		while (count<= limit) {
			
			try {
				WebElement element = driver.findElement(By.xpath(xpath));
				if (element.isDisplayed() && element.isEnabled()) {
					System.out.println("Element found");
					return element;
				}
			}
			catch (StaleElementReferenceException e) {
				System.out.println("Element moved");
				driver.navigate().refresh();
				break;
			}
			catch (Exception e) {
				System.out.println("Element not found , retrying!!!\nElement xpath : "+xpath);
			}
			count++;
		}
		throw new TimeoutException("Timeout : Element not found!!!\nElement xpath : "+xpath);
	}
}