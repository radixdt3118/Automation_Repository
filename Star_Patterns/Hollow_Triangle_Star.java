package Star_Patterns;

public class Hollow_Triangle_Star {

	public static void main(String[] args) {
		
		int n=7;
		for(int i=1;i<=n;i++) {
			
			for(int j=n;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				if (k>1 && k<i && i!=n) {
					System.out.print("  ");
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
			
		}
		
	}
	
}
