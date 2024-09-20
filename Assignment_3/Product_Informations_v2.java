package Session_3;

import java.util.*;

/*
 * Break statement:

Scenario: While iterating through the products, if we encounter a product with a price of 0 (possibly indicating a pricing error), we stop processing further products.


Continue statement:

Scenario: If a product's quantity is 0 (out of stock), we skip Quantity field for that particular product and move to the next product.


Return statement:

Scenario: We create a method to find a product by its size. If found, we return True/False.
 */

public class Product_Informations_v2 {

	public static void main(String[] args) {
		
		
		String[][] products = new String[5][4];
		
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		for(int i=0;i<=4;i++) {
			System.out.println("Enter Product name , Product price , Product quantity  & Product size (Press enter to enter each)");
			
			for(int j=0;j<=3;j++) {
				String temp = sc.nextLine();
				
				//Used continue statement to skip quantity field when it's entered as zero
				if(j==2 && Integer.parseInt(temp)==0) {
					System.out.println("Quantity can't be zero at this moment\nSkipping Quantity field here");
					continue;
				}
				products[i][j] = temp;
			}
			
			//Used break statement when price is entered as ZERO
			if(Integer.parseInt(products[i][1])==0) {
				System.out.println("Loop break");
				break;
			}
		}
				
		
		for(int i=0;i<products.length;i++) {
			System.out.println(Arrays.deepToString(products[i]));
		}
		
	}
	
}
