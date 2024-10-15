package Assignments_Packages;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Assignments.CRUD_Payment_Terms;

public class TestPaymentTermsCRUD {

	@BeforeSuite
	public static void beforeSuite() throws IOException, InterruptedException {
		System.out.println("Before Suite method");
		CRUD_Payment_Terms.beforeCRUD();
	}

	@AfterSuite
	public static void afterSuite() {
		System.out.println("After Suite method");
		CRUD_Payment_Terms.afterCRUD();
	}

//	@BeforeMethod
//	public static void beforeMethod() throws IOException, InterruptedException {
//		System.out.println("Before Method");
//		CRUD_Payment_Terms.navigateToPaymentTerms();
//	}

	@Test
	public static void addPaymentTerm() throws IOException, InterruptedException {
		System.out.println("Adding payment terms");
		CRUD_Payment_Terms.addPaymentTerm();
	}

	@Test
	public static void EditPaymentTerm() throws Exception {
		CRUD_Payment_Terms.editPaymentTerm();
	}

	@Test
	public static void viewPaymentTerm() throws Exception {
		CRUD_Payment_Terms.viewPaymentTerm();
	}

	@Test
	public static void deletePaymentTerm() throws Exception {
		CRUD_Payment_Terms.deletePaymentTerm();
	}

}
