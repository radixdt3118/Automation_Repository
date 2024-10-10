package Extra_Crud;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import Get_Data_From_Files.Get_From_Properties;

public class Store_CRUD_OPT extends Get_From_Properties{
	
	public static String url="https://ops-qa.radixdev79.com";	//Website url

	public static void main(String[] args) throws IOException {
		File properties = new File("src/test/resources/xpaths_store.properties");
		File excel = new File("TestData/Store_Data.xlsx");
		File log_file = new File("Log_Notes.txt");
		FileWriter writer = new FileWriter(log_file);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addPreference("browser.link.open_newwindow", 1);           //This opens link in same page
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		
		try {
			driver.get(url+"/admin");
			long startTime = System.nanoTime();	//counting for execution time

			driver.findElement(By.xpath(getXPath("username", properties))).sendKeys(getData("Credentials", 1, "username", excel));
			driver.findElement(By.xpath(getXPath("password", properties))).sendKeys(getData("Credentials", 1, "password", excel));
			driver.findElement(By.xpath(getXPath("login", properties))).click();
			
			//Adding store details
			String[] fields = {"store_name","email","url_type","subdomain_name","main_store_url","username","password","phone_number","sales_agent","add_as_front_customer","markup_type", "markup_master" , "flat_markup" ,  "pay_on_account","pay_on_limit","open_b2b_store","department","fix_billing_address","fix_shipping_address","order_approval","show_price_to_customer","quick_checkout","store_fields","allow_tax_exemption","manage_invoice","allow_partial_payment","notify"};
//			String[] fields = getKEYS(properties);
			ArrayList<String> radio_buttons = new ArrayList<String>(Arrays.asList("url_type","markup_type","pay_on_account","store_fields","manage_invoice"));
			for(int row_num=1;row_num<=3;row_num++){
				//Creating store
				driver.navigate().to(url+"/admin/corporate_listing.php");
				driver.findElement(By.xpath(getXPath("add_store", properties))).click();
				driver.findElement(By.xpath(getXPath("private_store", properties))).click();
				driver.findElement(By.xpath(getXPath("save_and_continue", properties))).click();
				
				//Preload testdata
				Map<String, String> test_data = new LinkedHashMap<String, String>();
				for (String key : fields) {
					test_data.put(key, getData("Store_Details", row_num, key, excel));
				}
				
				//Preload xpaths
				Map<String, String> xpaths_pair = new LinkedHashMap<String, String>();		
				for (String field : fields) {
					xpaths_pair.put(field, Get_From_Properties.getXPath(field, properties));
				}				
				
			for (String field : fields) {
				//retrive testdata earlier
				String data = test_data.get(field);
				//retrive xpath earlier
				String xpath = xpaths_pair.get(field); 
				try {
					WebElement element=null;
					
					//if radio button is found then xpath and testdata is merged through string.format with %s in xpath
					if(radio_buttons.contains(field)){
						String xpath_new = String.format(xpath,data);						
						element = driver.findElement(By.xpath(xpath_new));
						element.click();
					}else {
						//if radio button is not found then we can continue with other methods
						 element = driver.findElement(By.xpath(xpath));
					}
					switch (element.getTagName().toString()) {
						case "input":
							if(element.toString().contains("checkbox")) {
								if(data.equals("active")) {
									element.click();
								}
							}else {
								element.sendKeys(data);
							}
							break;
							
						case "select":
							Select element_select = new Select(element);
							element_select.selectByVisibleText(url);
							break;
							
						default:
							element.click();
							break;
					}
				} catch (Exception e) {
					// TODO: handle exception
//					writer.write("Exception :- "+field+"\n");
				}				
			}
			driver.findElement(By.xpath(getXPath("save_and_back", properties))).click();
//			Thread.sleep(1500);	
		}	//Loop End
			long EndTime = System.nanoTime();
			writer.write("Execution time : "+(EndTime-startTime));
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