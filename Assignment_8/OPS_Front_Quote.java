package Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class OPS_Front_Quote {
    public static void highlightElement(WebElement element,WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Change background color or border temporarily
        js.executeScript("arguments[0].style.border='3px double red'", element);
    }

	//Get test-data from excel file
	public static String getData(String key,File fileobj) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook(fileobj);
		XSSFSheet sheet = wb.getSheetAt(0);
		int row_size = sheet.getLastRowNum();
		String value=null;
		boolean is_Found = false;
		
		for(int r=0;r<=row_size;r++) {
			Row row = sheet.getRow(r);
			Cell cell = row.getCell(0);
			if (cell.toString().equalsIgnoreCase(key)) {
				value = row.getCell(1).toString();
			}
		}	
		return value;	
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
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		File error_log = new File("Log_Notes.txt");		//used in catch-block to log errors to txt file
		FileWriter writer = new FileWriter(error_log);
		
		File excel_file = new File("TestData/Test_Data.xlsx");
		File properties_file = new File("src/test/resources/xpaths_quote.properties");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addPreference("browser.link.open_newwindow", 1);           //This opens link in same page
		FirefoxDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://ops-qa.radixdev79.com/user_login.php");

		try {			
			//Login to front-store
			WebElement username = driver.findElement(By.xpath(getXPath("username", properties_file)));
			username.sendKeys(getData("username", excel_file));
			WebElement password = driver.findElement(By.xpath(getXPath("password", properties_file)));
			password.sendKeys(getData("password", excel_file));
			WebElement login = driver.findElement(By.xpath(getXPath("login", properties_file)));
			login.click();
			
			//Add new quote
			WebElement quote_link = driver.findElement(By.xpath(getXPath("quote_link", properties_file)));
			quote_link.click();		
			WebElement quote_title = driver.findElement(By.xpath(getXPath("quote_title", properties_file)));
			quote_title.sendKeys(getData("quote_title", excel_file));
			WebElement product_type_custom = driver.findElement(By.xpath(getXPath("product_type_custom", properties_file)));
			product_type_custom.click();
			WebElement product_name = driver.findElement(By.xpath(getXPath("product_name", properties_file)));
			product_name.sendKeys(getData("product_name", excel_file));
			WebElement quantity_1 = driver.findElement(By.xpath(getXPath("quantity_1", properties_file)));
			String val = getData("quantity_1", excel_file);
			quantity_1.sendKeys(val.substring(0, val.indexOf(".")));
			
			WebElement text_box = driver.findElement(By.xpath(getXPath("text_box", properties_file)));
			text_box.sendKeys(getData("text_box", excel_file));
			
			//Multiple images uploading
			for(int i=1;i<=5;i++) {
				WebElement upload = driver.findElement(By.xpath(getXPath("upload", properties_file)));
				String image="Image_"+Integer.toString(i);
				upload.sendKeys(getData(image, excel_file));	
			}
			
			WebElement quote_description = driver.findElement(By.xpath(getXPath("quote_description", properties_file)));
			quote_description.sendKeys(getData("quote_description", excel_file));
			WebElement checkbox_both = driver.findElement(By.xpath(getXPath("checkbox_both", properties_file)));
			checkbox_both.click();
			WebElement dropdown = driver.findElement(By.xpath(getXPath("dropdown", properties_file)));
			dropdown.click();
			WebElement dropdown_value = driver.findElement(By.xpath(getXPath("dropdown_value", properties_file)));
			dropdown_value.click();
			
			WebElement save_and_continue = driver.findElement(By.xpath(getXPath("save_and_continue", properties_file)));
			highlightElement(save_and_continue, driver);
			Thread.sleep(500);
			save_and_continue.click();
			WebElement send_quote = driver.findElement(By.xpath(getXPath("send_quote", properties_file)));
			send_quote.click();
			Thread.sleep(2000);		
			
		} catch (Exception e) {
			writer.write("Date : "+LocalDate.now().toString()+"\n");
			writer.write("Time : "+LocalTime.now().toString()+"\n");
			writer.write("Error Details : \n");
			writer.write(e.getLocalizedMessage());			
		} finally {
			driver.quit();
			writer.close();
		}	
	}
}