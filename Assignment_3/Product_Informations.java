package Session_3;

import java.util.*;

public class Product_Informations {

	public static void main(String[] args) {
		
		String[][] products = new String[5][4];
		
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		for(int i=0;i<=4;i++) {
			System.out.println("Enter Product name , Product price , Product quantity  & Product size (Press enter to enter each)");
			for(int j=0;j<=3;j++) {
				
				products[i][j] = sc.nextLine();
			
			}
		}
				
		
		for(int i=0;i<products.length;i++) {
			System.out.println(Arrays.deepToString(products[i]));
		}
		
	}
	
}
