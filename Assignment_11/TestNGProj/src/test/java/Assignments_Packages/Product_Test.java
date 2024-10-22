package Assignments_Packages;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Assignments.CRUD_Product;

public class Product_Test {

	@BeforeSuite(groups = "WEBDRIVER")
	public static void invokeAndNavigate() throws IOException, Exception {
		CRUD_Product.invokeAndNavigate();
	}
	
	
	@AfterSuite(alwaysRun = true)
	public static void quitBrowser() {
		System.out.println("After suite");
		CRUD_Product.quitBrowser();
	}
	
	@BeforeClass(alwaysRun = true)
	public static void prefetchData() throws Exception {
		CRUD_Product.preloadData(1);
	}
	
	@BeforeMethod(alwaysRun = true)
	public static void redirectToListing() {
		CRUD_Product.redirectToListingPage();
	}
	
	@Test(priority = 1,groups = "CRUD")
	public static void createProduct() throws IOException, Exception {
		CRUD_Product.addProduct();
	}
	
	@Test(priority = 2,groups = "CRUD")
	public static void editProduct() throws IOException, Exception {
		CRUD_Product.editProduct();
	}
	
	@Test(priority = 3,groups = "CRUD")
	public static void viewProduct() throws IOException, Exception {
		CRUD_Product.viewProduct();
	}
	
	
	@Test(priority = 4,groups = "CRUD")
	public static void deleteProduct() throws IOException, Exception {
		CRUD_Product.deleteProduct();
	}
	
}

