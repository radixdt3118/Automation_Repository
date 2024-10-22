package Assignments_Packages;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Assignments.CRUD_Workflow_Roles;


public class WorkFlow_Roles_Test {
	
	@BeforeTest
	@Parameters("browser")
	public static void setupCase(@Optional("Edge")String browser) throws Exception {
		CRUD_Workflow_Roles.setupAndLogin(browser);			
	}
	
	@BeforeClass
	@Parameters({"properties","Excel"})
	public static void navigateToPage(String path,String excel_file) throws IOException, Exception {
		File properties = new File(path);
		CRUD_Workflow_Roles.navigateToWorkflowRoles(properties,excel_file);
	}
	
	@Test(priority = 1)
	@Parameters({"Sheet1"})
	public static void addRole(String sheet_name) throws IOException, Exception {
		CRUD_Workflow_Roles.addWorkflowRole(sheet_name);
	}	
	
	@Test(priority = 2)
	@Parameters({"Sheet2"})
	public static void editRole(String sheet_name) throws IOException, Exception {
		CRUD_Workflow_Roles.editWorkflowRole(sheet_name);
	}
	
	@Test(priority = 3)
	@Parameters({"Sheet2"})
	public static void viewRole(String sheet_name) throws IOException, Exception {
		CRUD_Workflow_Roles.viewWorkflowRole(sheet_name);
	}
	
	@Test(priority = 4)
	@Parameters({"Sheet2"})
	public static void deleteRole(String sheet_name) throws IOException, Exception {
		CRUD_Workflow_Roles.deleteWorkflowRole(sheet_name);
	}	
	
	@AfterTest
	public static void quitDriver() {
		CRUD_Workflow_Roles.quitBrowser();
	}
	
}
