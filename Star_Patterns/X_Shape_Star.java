package Star_Patterns;
/*
 * 		*       *
 * 		  *   *
 * 		    *
 * 		  *   *
 * 		*       *
 * 
 */

public class X_Shape_Star {
	
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			
			for(int j=1;j<=5;j++) {
				
				if (i==j || (i+j)==6) {					
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			
			System.out.println();
		}
		
	}

}
