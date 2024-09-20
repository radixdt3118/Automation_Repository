package Session_3;
import java.util.*;

public class Abbreviations {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter firstname , middlename and lastname Seperated by <Space>");
		String fn = sc.next();
		String mn = sc.next();
		String ln = sc.next();
		
		String name = fn.charAt(0) + "." + mn.charAt(0) + "." + ln;
		
		System.out.println("Rewritten name with Abbreviations : "+name);
		
	}
	
}
