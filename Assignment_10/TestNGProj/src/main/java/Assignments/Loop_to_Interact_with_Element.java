package Assignments;

import java.io.File;
import Get_Data_From_Files.*;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Loop_to_Interact_with_Element extends Get_From_Properties {
	public static String url = "https://ops-qa.radixdev79.com/admin/";
	static WebDriver driver;
	static File properties = new File("src/test/resources/xpaths_customers.properties");
	static File excel = new File("TestData/customerData.xlsx");
	
	public static String[] fields = { "usertype", "sales_agent", "firstname", "lastname", "email", "secondaryemail", "password",
			"force_reset", "phonenumber", "company", "usergroup", "address1", "address2", "country", "state",
			"city", "zipcode", "notify", "allow_tax_exemption", "payment_due_days", "pay_on_account",
			"allow_partial_payment", "payment_term"};

	public static void beforeAdding() throws IOException {
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath(getXPath("username", properties))).sendKeys("admin");
		driver.findElement(By.xpath(getXPath("password", properties))).sendKeys("Admin095");
		driver.findElement(By.xpath(getXPath("login", properties))).click();
		driver.navigate().to(url + "/user_listing.php");
	}
	
	public static void beforeMethod() {
		driver.navigate().to(url + "user_action.php");		
	}

	public static void addingCustomers1() throws Exception {
		int row_num=1;
		for (String field : fields) {
			Perform_On_Element.interactWith(getXPath(field, properties), getData("Customers", row_num, field, excel), driver);
		}
		driver.findElement(By.xpath(getXPath("save_and_back", properties))).click();
	}
	public static void addingCustomers2() throws Exception {
		int row_num=2;
		for (String field : fields) {
			Perform_On_Element.interactWith(getXPath(field, properties), getData("Customers", row_num, field, excel), driver);
		}
		driver.findElement(By.xpath(getXPath("save_and_back", properties))).click();
	}
	public static void addingCustomers3() throws Exception {
		int row_num=3;
		for (String field : fields) {
			Perform_On_Element.interactWith(getXPath(field, properties), getData("Customers", row_num, field, excel), driver);
		}
		driver.findElement(By.xpath(getXPath("save_and_back", properties))).click();
	}

	public static void afterAdding() {
		driver.quit();
	}

}
