package Star_Patterns;


public class Triangle_Number_Pattern {

	public static void main(String[] args) {
		
		int n=1;
		
		for(int i=1;i<=5;i++) {
			
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print(n+" ");
//				n++;
			}
			n++;
			System.out.println();	
		}
		
	}
	
}
