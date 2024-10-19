package Assignments_Packages;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Assignments.CRUD_Product;

public class Product_Test {

	@BeforeSuite
	public static void invokeAndNavigate() throws IOException, Exception {
		CRUD_Product.invokeAndNavigate();
	}
	
	
	@AfterSuite
	public static void quitBrowser() {
		CRUD_Product.quitBrowser();
	}
	
	@BeforeClass
	public static void prefetchData() throws Exception {
		CRUD_Product.preloadData(1);
	}
	
	@BeforeMethod
	public static void redirectToListing() {
		CRUD_Product.redirectToListingPage();
	}
	
	@Test(priority = 1,groups = {"CRUD"})
	public static void createProduct() throws IOException, Exception {
		CRUD_Product.addProduct();
	}
	
	@Test(priority = 2,groups = {"CRUD"})
	public static void editProduct() throws IOException, Exception {
		CRUD_Product.editProduct();
	}
	
	@Test(priority = 3,groups = {"CRUD"})
	public static void viewProduct() throws IOException, Exception {
		CRUD_Product.viewProduct();
	}
	
	
	@Test(dependsOnGroups = {"CRUD"})
	public static void deleteProduct() throws IOException, Exception {
		CRUD_Product.deleteProduct();
	}
	
}
