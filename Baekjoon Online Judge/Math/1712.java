import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		
		long n;
		if (b >= c){
			n = -1;
		}
		else{
			n = a / (c - b) + 1;
		}
		
		System.out.println(n);
	}

}
