package Star_Patterns;
/*
 *      * * * * *
 *        * * * *
 *          * * *
 *            * *
 *              *
 *            * *
 *          * * *
 *        * * * *
 *      * * * * *  
 * 
 */


public class Right_Arrow_Star {

	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			
			for(int k=1;k<i;k++) {
				System.out.print("  ");
			}
			for(int j=5;j>=i;j--) {
				System.out.print("* ");
			}			
			System.out.println();
		}
		//Reverse
		for(int i=1;i<=5;i++) {
			
			if (i==1) {
				continue;
			}
			for(int k=5;k>i;k--) {
				System.out.print("  ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}			
			System.out.println();
		}
		
	}
	
}
