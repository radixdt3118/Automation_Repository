package Assignments_Packages;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Assignments.*;

public class TestCustomerAdd {

	@BeforeSuite
	public static void beforeSuite() throws IOException {
		Loop_to_Interact_with_Element.beforeAdding();
	}
	
	@Test
	public static void customerAdd_1() throws Exception {
		Loop_to_Interact_with_Element.addingCustomers1();
	}
	
	@Test
	public static void customerAdd_2() throws Exception {
		Loop_to_Interact_with_Element.addingCustomers2();
	}
	
	@Test
	public static void customerAdd_3() throws Exception {
		Loop_to_Interact_with_Element.addingCustomers3();
	}
	
	@BeforeMethod
	public static void beforeMethod() {
		Loop_to_Interact_with_Element.beforeMethod();
	}
	

	@AfterSuite
	public static void afterSuite(){
		Loop_to_Interact_with_Element.afterAdding();
	}
	
}
