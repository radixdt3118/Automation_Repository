package Assignments;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import WebControlsPackage.WebControls_VD;


public class CRUD_Product{

	static String url = "https://ops-qa.radixdev79.com/admin/";
	static WebDriver driver;
	static File excel = new File("TestData/ProductData.xlsx");
	static File properties = new File("src/test/resources/xpaths_Products.properties");
	static Map<String, String> xpaths_dict = new LinkedHashMap<String, String>();
	static Map<String, String> testdata_dict = new LinkedHashMap<String, String>();
	static int row_num;

	static String[] fields = { "product_name", "product_internal_title", "product_type", "url", "search_keywords",
			"default_category","associated_category",  "price_defining_method", "sheet_calculation", "sort", "status",
			"display_at_home_page", "popular_product","production_days",};

	public static void invokeAndNavigate() throws IOException, Exception {
		System.out.println(excel.isFile());
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		driver = new FirefoxDriver(options);
		driver.get(url);
		WebControls_VD.interactWith(WebControls_VD.getXPath("username", properties),WebControls_VD.getData("username",1,"Credentials", excel), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("password", properties),WebControls_VD.getData("password",1,"Credentials", excel), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("login", properties), driver);
		
	}


	public static void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	public static void preloadData(int row) throws Exception {
		
		row_num=row;
		for (String field : fields) {
			xpaths_dict.put(field, WebControls_VD.getXPath(field, properties));
			testdata_dict.put(field, WebControls_VD.getData(field,row_num,"Products",excel));
		}
	}
	
	public static void redirectToListingPage() {
		driver.navigate().to(url + "product_listing.php");
	}

	public static void addProduct() throws IOException, Exception {
		driver.navigate().to(url + "product_action.php");
		for (String field : fields) {
			String xpath = xpaths_dict.get(field);
			String data = testdata_dict.get(field);
	
			WebControls_VD.interactWith(xpath,data, driver);
		}
		WebControls_VD.interactWith(WebControls_VD.getXPath("save_and_back", properties), driver);
	}

	public static void editProduct() throws IOException, Exception {
		
		WebControls_VD.interactWith("//button[@data-id='cid']",WebControls_VD.getData("default_category", 1, "Products", excel),driver);
		WebControls_VD.interactWith("//input[@id='keyword']",WebControls_VD.getData("product_name", 1, "Products", excel),driver);
		WebControls_VD.interactWith("//button[@id='search']",driver);
		
		
		WebControls_VD.interactWith(WebControls_VD.getXPath("product_actions",properties), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("product_edit", properties), driver);
		
		preloadData(2);
		for (String field : fields) {
			String xpath = xpaths_dict.get(field);
			String data = testdata_dict.get(field);
	
			WebControls_VD.interactWith(xpath,data, driver);
		}
		WebControls_VD.interactWith(WebControls_VD.getXPath("save_and_back", properties), driver);
		
	}

	public static void viewProduct() throws IOException, Exception {
		WebControls_VD.interactWith("//button[@data-id='cid']",WebControls_VD.getData("default_category", 1, "Products", excel),driver);
		WebControls_VD.interactWith("//input[@id='keyword']",WebControls_VD.getData("product_name", 1, "Products", excel),driver);
		WebControls_VD.interactWith("//button[@id='search']",driver);
		
		WebControls_VD.interactWith(WebControls_VD.getXPath("product_actions",properties), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("product_view", properties), driver);
		driver.navigate().back();
	}

	public static void deleteProduct() throws IOException, Exception {
		WebControls_VD.interactWith("//button[@data-id='cid']",WebControls_VD.getData("default_category", 1, "Products", excel),driver);
		WebControls_VD.interactWith("//input[@id='keyword']",WebControls_VD.getData("product_name", 1, "Products", excel),driver);
		WebControls_VD.interactWith("//button[@id='search']",driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("product_actions", properties), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("product_delete", properties), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("confirm_delete", properties), driver);
	}
}