package demo;
import java.util.*;


class Calc{
	
	void add(int a,int b) {
		System.out.println("Sum of " + a + " and " + b + " is : " + (a+b));
	}
	void subsract(int a,int b) {
		System.out.println("Substraction of " + a + " and " + b + " is : " + (a-b));
	}
	void multiplication(int a, int b) {
		System.out.println("Multiplication of " + a + " and " + b + " is : " + (a*b));
	}
	void division(int a, int b) {
		System.out.println("Division of " + a + " and " + b + " is : " + ((double)a/(double)b));
	}
}




public class Calculator {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first integer value");
		int a = sc.nextInt();
		
		System.out.println("Enter second integer value");
		int b = sc.nextInt();
		
		sc.close();
		
		Calc obj = new Calc();
		obj.add(a, b);
		obj.subsract(a, b);
		obj.multiplication(a, b);
		obj.division(a, b);
		

	}
	
	
}