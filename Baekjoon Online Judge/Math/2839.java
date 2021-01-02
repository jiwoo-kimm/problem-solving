import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int x,y;
		for (x=n/5 ; x>-1 ; x--){
			for (y=n/3 ; y>-1 ; y--){
				if (x+y == 0){
					System.out.println(-1);
					System.exit(0);
				}
				if (x * 5 + y * 3 == n){
					System.out.println(x+y);
					System.exit(0);
				}
			}
		}
	}

}
