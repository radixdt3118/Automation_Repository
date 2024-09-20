//package demo;
//import java.util.*;
//
//public class Append_Names {
//
//	public static void main(String[] args) {
//		
//		ArrayList<String> firstnames = new ArrayList<String>();
//		ArrayList<String> lastnames = new ArrayList<String>();
//		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter first names , Press enter to add another firstname");
//		String f1 = sc.nextLine();
//		String f2 = sc.nextLine();
//		String f3 = sc.nextLine();
//		String f4 = sc.nextLine();
//		String f5 = sc.nextLine();
//		
//		System.out.println("\nEnter last names , Press enter to add another lastname");
//		String l1 = sc.nextLine();
//		String l2 = sc.nextLine();
//		String l3 = sc.nextLine();
//		String l4 = sc.nextLine();
//		String l5 = sc.nextLine();
//		
//		sc.close();
//		
//		System.out.println("Concatinated firstnames and lastnames\n");
//		System.out.println(f1 +" "+ l1);
//		System.out.println(f2 +" "+ l2);
//		System.out.println(f3 +" "+ l3);
//		System.out.println(f4 +" "+ l4);
//		System.out.println(f5 +" "+ l5);
//		
//		
//	}
//	
//}



package demo;
import java.util.*;

public class Append_Names {

	public static void main(String[] args) {
		
		ArrayList<String> firstnames = new ArrayList<String>();
		ArrayList<String> lastnames = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first names , Press enter to add another firstname");
		for(int i=1;i<=5;i++) {
			String fn = sc.nextLine();
			firstnames.add(fn);
		}
		
		System.out.println("\nEnter last names , Press enter to add another lastname");
		for(int i=1;i<=5;i++) {
			String ln = sc.nextLine();
			lastnames.add(ln);
		}
		
		sc.close();
		
		System.out.println("Appended firstnames and lastnames");
		ArrayList<String> fullnames = new ArrayList<String>();
		
		for(int i=0;i<firstnames.size();i++) {
			fullnames.add(firstnames.get(i) + " " + lastnames.get(i));
		}
		
		System.out.println("Sorted names : Alphabetically by firstnames");
		Collections.sort(fullnames);
		
		for(int i=0;i<fullnames.size();i++) {
			System.out.println(fullnames.get(i));
		}
		
	}
	
}
