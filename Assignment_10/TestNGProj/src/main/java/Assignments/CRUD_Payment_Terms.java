package Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Custom_Find.Custom_Find;
import Get_Data_From_Files.Get_From_Properties;

public class CRUD_Payment_Terms extends Get_From_Properties {
	
	public static String url = "https://ops-qa.radixdev79.com/admin/";
	static WebDriver driver;
	static File properties = new File("src/test/resources/xpaths_payment_terms_crud.properties");
	public static String term_title_value = "Auto_1";

	// before crud , login to site
	public static void beforeCRUD() throws IOException, InterruptedException {
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.xpath(getXPath("username", properties))).sendKeys("admin");
		driver.findElement(By.xpath(getXPath("password", properties))).sendKeys("Admin095");
		driver.findElement(By.xpath(getXPath("login", properties))).click();
		driver.navigate().to(url + "/configuration_payment_listing.php");
		driver.findElement(By.xpath(getXPath("edit_partial", properties))).click();
		driver.findElement(By.xpath(getXPath("payment_term_master", properties))).click();
		WebElement iframe = driver.findElement(By.xpath(getXPath("iframe", properties)));
		driver.switchTo().frame(iframe);
	}

	// after crud , quit browser
	public static void afterCRUD() {
		driver.switchTo().defaultContent();
		driver.quit();
	}

	// add payment term
	public static void addPaymentTerm() throws IOException, InterruptedException {
		driver.findElement(By.xpath(getXPath("add", properties))).click();
		driver.findElement(By.xpath(getXPath("term_title", properties))).sendKeys(term_title_value); // Term title
		String[] percentages = { "20", "30", "50" };
		String[] termdays = { "5", "10", "15" };
		for (int i = 0; i <= 2; i++) { // Payment terms
			String new_xpath_percentage = String.format(getXPath("percentage", properties), Integer.toString(i));
			String new_xpath_termDays = String.format(getXPath("term_days", properties), Integer.toString(i));
			driver.findElement(By.xpath(new_xpath_percentage)).sendKeys(percentages[i]);
			driver.findElement(By.xpath(new_xpath_termDays)).sendKeys(termdays[i]);
			if (i != 2) {
				driver.findElement(By.xpath(getXPath("payment_term", properties))).click();
			}
		}
		driver.findElement(By.xpath(getXPath("status", properties))).click();
		driver.findElement(By.xpath(getXPath("save_and_back", properties))).click();

	}

	// edit payment term
	public static void editPaymentTerm() throws Exception {
		Custom_Find obj = new Custom_Find();
		System.out.println("Calling edit payment terms");
		String new_xpath = String.format(getXPath("edit_term", properties), term_title_value);
		WebElement edit_button = Custom_Find.customFindElement(new_xpath, driver);
		edit_button.click();
		
		WebElement term_title = driver.findElement(By.xpath(getXPath("term_title", properties)));
//		WebElement term_title = Custom_wait.customFindElement(getXPath("term_title", properties),driver);
		term_title.clear();
		term_title_value = "Auto_1_Updated";
		term_title.sendKeys(term_title_value);
		driver.findElement(By.xpath(getXPath("save_and_back", properties))).click();
	}

	// view payment term
	public static void viewPaymentTerm() throws Exception {
		String new_xpath = String.format(getXPath("edit_term", properties), term_title_value);
		WebElement edit_button = Custom_Find.customFindElement(new_xpath, driver);
		edit_button.click();
//		driver.findElement(By.xpath(new_xpath)).click();
		driver.findElement(By.xpath(getXPath("back_button", properties))).click();
	}

	// delete payment term
	public static void deletePaymentTerm() throws Exception {
		String new_xpath = String.format(getXPath("delete_term", properties), term_title_value);
		WebElement delete_button = Custom_Find.customFindElement(new_xpath, driver);
		delete_button.click();
//		driver.findElement(By.xpath(new_xpath)).click();
//		driver.findElement(By.xpath(getXPath("confirm_delete", properties))).click();
		WebElement confirm_delete= Custom_Find.customFindElement(getXPath("confirm_delete", properties), driver);
		confirm_delete.click();
	}
}
