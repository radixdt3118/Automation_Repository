package Extra_Crud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import Get_Data_From_Files.CRUD_From_Excel;
import Get_Data_From_Files.Get_From_Properties;
import net.bytebuddy.asm.Advice.OffsetMapping.Target.ForStackManipulation.Writable;

public class Store_CRUD extends Get_From_Properties{

	public static void main(String[] args) throws IOException {
		File properties = new File("src/test/resources/xpaths_store.properites");
		File excel = new File("TestData/Store_Data.xlsx");
		File log_file = new File("Log_Notes.txt");
		FileWriter writer = new FileWriter(log_file);
		
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addPreference("browser.link.open_newwindow", 1);           //This opens link in same page
		FirefoxDriver driver = new FirefoxDriver(options);
		String url="https://ops-qa.radixdev79.com";
		
		
		driver.get(url+"/admin");
		int row_num=1;
		
		try {

			driver.findElement(By.xpath(getXPath("username", properties))).sendKeys(getData("Credentials", 1, "username", excel));
			driver.findElement(By.xpath(getXPath("password", properties))).sendKeys(getData("Credentials", 1, "password", excel));
			driver.findElement(By.xpath(getXPath("login", properties))).click();
			
			//Creating store
			driver.navigate().to(url+"/admin/corporate_listing.php");
			driver.findElement(By.xpath(getXPath("add_store", properties))).click();
			driver.findElement(By.xpath(getXPath("private_store", properties))).click();
			driver.findElement(By.xpath(getXPath("save_and_continue", properties))).click();
			
			//Adding store details
			String[] fields = {"store_name","email","url_type","subdomain_name","main_store_url","username","password","phone_number","sales_agent","add_as_front_customer","markup_type", "markup_master" , "flat_markup" ,  "pay_on_account","pay_on_limit","open_b2b_store","department","fix_billing_address","fix_shipping_address","order_approval","show_price_to_customer","quick_checkout","store_fields","allow_tax_exemption","manage_invoice","allow_partial_payment","notify"};
			
			
			for(int i=0;i<fields.length;i++) {				
				try {
					WebElement element=null;
					if(fields[i].equalsIgnoreCase("url_type") || fields[i].equalsIgnoreCase("markup_type")){
						writer.write(fields[i]+"\n");
						String xpath_new = String.format(getXPath(fields[i], properties),getData("Store_Details", row_num, fields[i], excel));						
						element = driver.findElement(By.xpath(xpath_new));
					}else {
						 element = driver.findElement(By.xpath(getXPath(fields[i], properties)));
					}
					if(element.getTagName().contains("input")) {
						
						if(element.toString().contains("checkbox")) {
							if(getData("Store_Details", row_num, fields[i], excel).equals("1.0")) {
								element.click();
							}
						}
						else {
							element.sendKeys(getData("Store_Details", row_num, fields[i], excel));
						}
					}else if(element.toString().contains("radio") ) {
						writer.write(fields[i]);
						element.click();
					}
					else if(element.getTagName().equalsIgnoreCase("select")) {
						Select element_s = new Select(element);
						element_s.selectByVisibleText(getData("Store_Details", row_num, fields[i], excel));
					} else {
						
						element.click();
					}
				} catch (Exception e) {
					// TODO: handle exception
	
					writer.write("Exception :- "+fields[i]+"\n");
				}				
			}			
			Thread.sleep(2000);	
			
		} catch (Exception e) {
			
			writer.write("Date : "+LocalDate.now().toString()+"\n");
			writer.write("Time : "+LocalTime.now().toString()+"\n");
			writer.write("Error Details : \n");
			writer.write(e.getLocalizedMessage());
		} finally {
			writer.close();
			driver.quit();
		}
		
	}
	
}
