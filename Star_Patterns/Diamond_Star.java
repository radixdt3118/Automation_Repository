package Star_Patterns;

public class Diamond_Star {

	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("* ");
			}

			System.out.println();
		}
		
		for(int i=1;i<=5;i++) {
			
			for(int m=1;m<i;m++) {
				System.out.print(" ");
			}
			for(int n=4;n>=i;n--) {
				System.out.print(" *");
			}

			
			System.out.println();
		}
		
	}
	
}
