package Session_3;
import java.util.*;

public class Sum_Of_Evens {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i=1;i<=50;i++) {
			if (i%2==0) {
				sum += i;
			}
		}
		
		System.out.format("Sum of even numbers till 50 : %d",sum);
		
		
	}
	
}
