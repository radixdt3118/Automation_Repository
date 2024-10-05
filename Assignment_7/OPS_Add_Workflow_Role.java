package Assignments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OPS_Add_Workflow_Role {
    public static void highlightElement(WebElement element,WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Change background color or border temporarily
        js.executeScript("arguments[0].style.border='3px double red'", element);
    }
    
	public static WebElement driverWait(String xpath,WebDriver driver) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		}catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		
		File file = new File("Log_Notes.txt");
		FileWriter writer = new FileWriter(file);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addPreference("browser.link.open_newwindow", 1);           //This opens link in same page
		WebDriver driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get("https://ops-qa.radixdev79.com/admin/");
		
		try {
			//login
			WebElement uname = driver.findElement(By.xpath("//input[@id='username']"));
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement login = driver.findElement(By.xpath("//button[@name='login']"));
			highlightElement(uname, driver);highlightElement(pwd, driver);highlightElement(login, driver);
			uname.sendKeys("admin");
			pwd.sendKeys("Admin095");
			login.click();
			
			//Adding Workflow role
			driver.get("https://ops-qa.radixdev79.com/admin/workflow_action.php");
			WebElement title = driverWait("//input[@id='workflow_title']", driver);
	        WebElement order_status_for_view = driver.findElement(By.xpath("//label[text()='Order Status For View']//ancestor::div[@class='form-group row mb-md-3 mb-2']//child::button[@class='multiselect dropdown-toggle btn btn-white']"));
			WebElement order_product_status_for_view = driver.findElement(By.xpath("//label[text()='Order Product Status For View']//ancestor::div[@class='form-group row mb-md-3 mb-2']//child::button[@class='multiselect dropdown-toggle btn btn-white']"));
			WebElement order_status_for_update = driver.findElement(By.xpath("//label[text()='Order Status For Update']//ancestor::div[@class='form-group row mb-md-3 mb-2']//child::button[@class='multiselect dropdown-toggle btn btn-white']"));
			WebElement order_product_status_for_update = driver.findElement(By.xpath("//label[text()='Order Product Status For Update']//ancestor::div[@class='form-group row mb-md-3 mb-2']//child::button[@class='multiselect dropdown-toggle btn btn-white']"));
			WebElement access_details = driver.findElement(By.xpath("//label[text()='Access Details']//ancestor::div[@class='form-group row mb-md-3 mb-2']//child::button[@class='multiselect dropdown-toggle btn btn-white']"));
			WebElement sort_order = driver.findElement(By.xpath("//input[@id='sort_order']"));
			WebElement save_back = driver.findElement(By.xpath("//button[@id='btn-action-saveback']"));
			
			//Selecting attributes
			WebElement[] list = {order_status_for_view,order_product_status_for_view,order_status_for_update,order_product_status_for_update,access_details};
			String[] status_list = {"Reprint Order","Pending","Ready for Pickup","Reprint Product","Awaiting Proof","Proof Approved","View Customer Details","Download File","Archive"};
			
			for (WebElement element : list) {
				highlightElement(element, driver);
			}
			title.sendKeys("Auto_Workflow_Role");
			for (WebElement element : list) {
				
				element.click();
				for(int i=0;i<status_list.length;i++) {
					try {
						String xpath_status = String.format("//ul[@class='multiselect-container dropdown-menu show']//child::*[contains(text(),'%s')]", status_list[i]);
						driver.findElement(By.xpath(xpath_status)).click();
					} catch (Exception e) {
						//do nothing
					}
				}
			    element.click();
			}
			sort_order.sendKeys("1");
			save_back.click();
			
			//Verifying whether workflow role is created or not
			WebElement created_workflow_role = driverWait("//table[@id='ops-table']//child::*[contains(text(),'Auto_Workflow_Role')]", driver);
			highlightElement(created_workflow_role, driver);
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
			writer.write(e.getLocalizedMessage());
		} 
		finally {
			driver.quit();
			writer.close();
		}	
	}
}
