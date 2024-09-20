package demo;
import java.util.*;

public class Compare_Strings {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first string");
		String first = sc.nextLine();
		
		System.out.println("Enter second string");
		String second = sc.nextLine();
		
		sc.close();

		if (first.equals(second)) {
			System.out.println("Both strings are equal");
		}
		else if(first.toLowerCase().equals(second.toLowerCase())) {
			System.out.println("Both strings are equal (Excluding case sensitiveness!!)");
		}
		else {
			System.out.println("Both strings are different");
		}
		
	}
}
