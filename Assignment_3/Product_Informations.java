package Session_3;

import java.util.*;

/*
 * Break statement:
Search for product until sum(quantity) reaches 100 then break

Continue statement:
Skip the product in printing which has quantity = 0

Return statement:
Create a function that returns the product with highest price
 */

public class Product_Informations_v2 {
	
	public static String findProduct(String[][] products){
		String result;
		String[][] products1 = products;
		int max = 0;
		int flag = 0;
		for(int i=0;i<5;i++) {
			if(Integer.parseInt(products1[i][1])>max) {
				max = Integer.parseInt(products1[i][1]);
				flag = i;
				
			}
		}
		
		result = Arrays.deepToString(products1[flag]);
		
		
		return result;
		
	}

	
	public static void main(String[] args) {

			String[][] products = new String[5][4];
			Scanner sc = new Scanner(System.in);
			
			//Adding products
			for(int i=0;i<5;i++) {
					System.out.println("\nProduct name : ");
					products[i][0] = sc.nextLine();
					System.out.println("Product Price : ");
					products[i][1] = sc.nextLine();
					System.out.println("Product Quantity : ");
					products[i][2] = sc.nextLine();
					System.out.println("Product Size : ");
					products[i][3] = sc.nextLine();				
			}
			
			//Break Statement
			int quantity_sum = 0;
			for(int i=0;i<5;i++) {
				quantity_sum+=Integer.parseInt(products[i][2]);
				if(quantity_sum>100) {
					System.out.println("\nSum of quantity reached more then 100 . breaking this loop!!!\n\n");
					break;
				}
				else {
					System.out.format("Product name : %s \nProduct Price : %s \nProduct Quantity : %s \nProduct Size : %s\n\n",products[i][0],products[i][1],products[i][2],products[i][3]);
				}
			}
			
			//Continue Statement
			System.out.println("Printing records with quantity not set as 0\n");
			for(int i=0;i<5;i++) {
				
				if(Integer.parseInt(products[i][2])==0) {
					System.out.println("Skipping the record with quantity 0!!!\n");
					continue;
				} else {
					System.out.format("Product name : %s \nProduct Price : %s \nProduct Quantity : %s \nProduct Size : %s\n\n",products[i][0],products[i][1],products[i][2],products[i][3]);
				}
			}
			
			
			//Return statement
			String max_price_product = findProduct(products);
			System.out.println("Product details with max price\n"+max_price_product);
			
		
		}
		

}
	

