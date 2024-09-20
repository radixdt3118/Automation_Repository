package Session_3;

import java.util.*;

/*
 * Break statement:

Scenario: While iterating through the products, if we encounter a product with a price of 0 (possibly indicating a pricing error), we stop processing further products.


Continue statement:

Scenario: If a product's quantity is 0 (out of stock), we skip printing its details and move to the next product.


Return statement:

Scenario: We create a method to find a product by its size. If found, we immediately return the product details. If not found, we return null after checking all products.
 */

public class Product_Informations_v2 {
	
	public static class Product{
		String name;
		String size;
		int price;
		int quantity;
		
		public void product(String name , String size , int price , int quantity) {
			this.name = name;
			this.size = size;
			this.price = price;
			this.quantity = quantity;
		}
		
	}

	
	public static void main(String[] args) {

		ArrayList<Product> product_list = new ArrayList<Product>();
		
		Product p1 = new Product();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			System.out.println("Enter product name , size , quantity , price");
			p1.name = sc.next();
			p1.size = sc.next();
			p1.quantity = sc.nextInt();
			p1.price = sc.nextInt();
			
			if(p1.quantity<=0) {
				System.out.println("Quantity can't be less then or equal to zero\nSkipping this record");
				continue;
			}
			if(p1.price<=0) {
				System.out.println("Product price can't be negative");
				break;
			}
			
			product_list.add(p1);
		}
		
		for(int i=0;i<5;i++) {
			System.out.println(product_list.get(i).name);
		}
		}
		

	}
	

