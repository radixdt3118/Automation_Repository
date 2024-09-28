package Star_Patterns.Patterns_V2;
/*
 * 		*     *
 * 		*   *
 * 		* *
 * 		*   *
 * 		*     *
 */


public class K_Pattern {

	public static void main(String[] args) {
		int n = 5; 
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=n;j++) {
				if(j==1 || (i+j==n) || (i+j==(2*i-1))) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}
