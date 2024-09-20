package Star_Patterns;

public class Heart_Shape_Star {

	public static void main(String[] args) {
		
		//Pyramid (Cutted down)
		for(int i=1;i<=5;i++) {
			
			
			if(i==1 || i==2) {
				continue;
			}
			for(int j=5;j>i;j--) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("* ");
			}
			//Second part of pyramid
			
			for(int m=5;m>i;m--) {
				System.out.print("  ");
			}
			for(int n=1;n<=i;n++) {
				System.out.print(" *");
			}
			
			System.out.println();
		}
		
		
		//Reverse Pyramid
		for(int i=1;i<=10;i++) {
			
			for(int k=1;k<i;k++) {
				System.out.print(" ");
			}
			for(int j=10;j>=i;j--) {
				System.out.print("* ");
			}
			
			
			System.out.println();
		}
		
				
	}
	
}
