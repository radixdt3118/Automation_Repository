package Star_Patterns.Patterns_V2;

//         1 
//        1 1 
//       1 2 1 
//      1 3 3 1 
//     1 4 6 4 1 
//    1 5 10 10 5 1 
//   1 6 15 20 15 6 1 
//  1 7 21 35 35 21 7 1 

import java.util.*;

public class Pascal_Triangle {
	
	static int fact(int f) {		
		if (f==1 || f==0) {
			return 1;
		}else {
			return f*fact(f-1);
		}		
	}

	public static void main(String[] args) {
		
		int target = 7;
		
		//Used formula of nCr = n!/(r!*(n-r)!)
		for(int n=0;n<=target;n++) {
			 for(int space=target;space>n;space--) {
				 System.out.print(" ");
			 }
			 
			 for(int r=0;r<=n;r++) {
				 int formula = fact(n)/(fact(r)*fact(n-r));
				 System.out.print(formula+" ");
			 }
			 System.out.println();
		 }
		
	}

}