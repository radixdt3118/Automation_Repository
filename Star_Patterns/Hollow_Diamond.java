package Star_Patterns;

public class Hollow_Diamond {

	public static void main(String[] args) {
		
		for(int i=1;i<=10;i++) {
			
			for(int j=10;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				if (k>1 && k<i) {
					System.out.print("  ");
				}
				else {
					System.out.print(" *");
				}
			}
			
			System.out.println();

		}
		for(int i=1;i<=10;i++) {
			
			//reverse
			
			for(int j=1;j<=i;j++) {
				System.out.print(" ");
			}
			for(int k=10;k>i;k--) {
				if (k!=10 && k!=i+1) {
					System.out.print("  ");
				}
				else {
					
					System.out.print(" *");
				}
				
			}
			
			System.out.println();
		}
		
	}
	
}
