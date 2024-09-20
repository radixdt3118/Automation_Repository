package Session_3;
import java.util.*;

public class Append_An_Array {

	public static void main(String[] args) {
		
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list1.add("First");
		list1.add("Second");
		list2.add("Third");
		list2.add("Fourth");

		list1.addAll(list2);
		System.out.println(list1);
		
	}
	
}
