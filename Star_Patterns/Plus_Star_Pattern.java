package Star_Patterns;


public class Plus_Star_Pattern {

	public static void main(String[] args) {
		
		int n=7;
		int middle = (int) Math.ceil((double)n/2);
		System.out.format("Middle value : %d\n\n",middle);
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=n;j++) {
				if( i==middle || j==middle) {
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
