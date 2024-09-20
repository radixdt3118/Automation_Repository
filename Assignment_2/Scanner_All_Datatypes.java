package demo;
import java.util.*;

public class Scanner_All_Datatypes {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a byte value");
		byte a = sc.nextByte();
		
		System.out.println("Enter a short value");
		short b = sc.nextShort();
		
		System.out.println("Enter a integer value");
		int c = sc.nextInt();
		
		System.out.println("Enter a long value");
		long d = sc.nextLong();
		
		System.out.println("Enter a float value");
		float e = sc.nextFloat();
		
		System.out.println("Enter a double value");
		double f = sc.nextDouble();		
		
		System.out.println("Enter a character value");
		char g = sc.next().charAt(0);
		
		System.out.println("Enter a String value");
		String h = sc.next(); // OR sc.next();
		
		System.out.println("Enter a boolean value");
		boolean i = sc.nextBoolean();
		
		System.out.println("Byte : "+a);
		System.out.println("Short : "+b);
		System.out.println("Integer : "+c);
		System.out.println("Long : "+d);
		System.out.println("Float : "+e);
		System.out.println("Double : "+f);
		System.out.println("Character : "+g);
		System.out.println("String : "+h);
		System.out.println("Boolean : "+i);

		
	}
}
