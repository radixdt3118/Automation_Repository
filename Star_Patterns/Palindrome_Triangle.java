package Star_Patterns.Patterns_V2;
//		          1 
//		        2 1 2 
//		      3 2 1 2 3 
//		    4 3 2 1 2 3 4 
//		  5 4 3 2 1 2 3 4 5 
//		6 5 4 3 2 1 2 3 4 5 6 

public class Palindrome_Triangle {

	public static void main(String[] args) {
		
		for(int i=1;i<=6;i++) {
			int n=i;						
			for(int j=6;j>i;j--) {
				System.out.print("  ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(n+" ");
				n--;
			}
			
			for(int l=1;l<=i;l++) {
				n++;
				if(l==1) {
					continue;
				}
				System.out.print(n+" ");
			}
			
			System.out.println();
		}
		
	}
	
}
