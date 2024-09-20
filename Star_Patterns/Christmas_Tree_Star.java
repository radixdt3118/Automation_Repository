/*
 * 			*
  	       * *
  	      * * *
  	     * * * *
  	    * * * * *
  	   * * * * * *
  	  * * * * * * *  
  	       * *
  	       * *
  	       * *
  	       * *
 
 
 */

package Star_Patterns;

public class Christmas_Tree_Star {

	public static void main(String[] args) {
		
		for(int i=1;i<=10;i++) {
			
			for(int j=10;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("* ");
			}
			
			System.out.println();
		}
		
		//For base
		for(int i=1;i<=5;i++) {
			for(int j=5;j>1;j--) {
				System.out.print("  ");
			}
			for(int k=1;k<=2;k++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	
}
