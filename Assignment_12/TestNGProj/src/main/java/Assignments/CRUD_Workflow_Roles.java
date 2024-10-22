package Assignments;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import WebControlsPackage.GlobalUtility_VD;
import WebControlsPackage.WebControls_VD;
import bsh.This;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CRUD_Workflow_Roles {
	static WebDriver driver;
	static String url = "https://ops-qa.radixdev79.com/admin/";
	static String[] fields = {"title", "order_status_for_view", "order_product_status_for_view", "order_status_for_update",
					   "order_product_status_for_edit", "access_details", "sort" };
	static File xpaths;
	static File excel;
	
	public static void setupAndLogin(String browser) throws Exception{		
		switch (browser) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions chrome_options = new ChromeOptions();
				chrome_options.setAcceptInsecureCerts(true);
				driver = new ChromeDriver(chrome_options);
				break;
			case "Firefox":
				FirefoxOptions firefox_options = new FirefoxOptions();
				firefox_options.setAcceptInsecureCerts(true);
				driver = new FirefoxDriver(firefox_options);
				break;
			case "Edge":
				EdgeOptions edge_options= new EdgeOptions();
				edge_options.setAcceptInsecureCerts(true);
				driver = new EdgeDriver(edge_options);
				break;

			default:
				throw new Exception("Invalid browser selection, update xml!!!");
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		WebControls_VD.interactWith(GlobalUtility_VD.username,"admin", driver);
		WebControls_VD.interactWith(GlobalUtility_VD.password,"Admin095",driver);
		WebControls_VD.interactWith(GlobalUtility_VD.login,driver);

	}
	
	public static void navigateToWorkflowRoles(File properties,String excel_file) throws IOException, Exception {
		xpaths = properties;
		excel=new File(excel_file);
		WebControls_VD.interactWith(WebControls_VD.getXPath("admin_tab", xpaths), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("workflow_admin_tab", xpaths), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("workflow_roles", xpaths), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("workflow_add", xpaths), driver);
	}
	
	public static void addWorkflowRole(String sheet_name) throws IOException, Exception {
		for (String field : fields) {			
			WebControls_VD.interactWith(WebControls_VD.getXPath(field, xpaths),WebControls_VD.getData(field, 1, sheet_name, excel) ,driver);
		}
		WebControls_VD.interactWith(GlobalUtility_VD.save_and_back, driver);
	}
	
	public static void editWorkflowRole(String sheet_name) throws IOException, Exception {
		WebControls_VD.interactWith(WebControls_VD.getXPath("search", xpaths), WebControls_VD.getData("title", 1, sheet_name, excel),driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("edit_role", xpaths), driver);
		addWorkflowRole(sheet_name);
	}
	
	public static void viewWorkflowRole(String sheet_name) throws IOException, Exception {
		WebControls_VD.interactWith(WebControls_VD.getXPath("search", xpaths), WebControls_VD.getData("title", 1, sheet_name, excel),driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("edit_role", xpaths), driver);
		WebControls_VD.interactWith(GlobalUtility_VD.back, driver);
	}
	
	public static void deleteWorkflowRole(String sheet_name) throws IOException, Exception {
		WebControls_VD.interactWith(WebControls_VD.getXPath("search", xpaths), WebControls_VD.getData("title", 1, sheet_name, excel),driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("delete_role", xpaths), driver);
		WebControls_VD.interactWith(WebControls_VD.getXPath("confirm_delete", xpaths), driver);
	}
	public static void quitBrowser() {
		driver.quit();
	}	
}