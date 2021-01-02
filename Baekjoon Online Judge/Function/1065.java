import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		int i;
		for (i=1 ; i<n+1 ; i++){
			if (isHanNum(i)) count++;
		}
		System.out.println(count);
	}
	
	public static boolean isHanNum(int n){
		boolean res = false;
		
		if (n / 100 == 0) return true;
		if (n / 1000 == 1) return false;
		
		int digits[] = new int[3];
		int x = 10;
		int i;
		for (i=0 ; i<3 ; i++){
			digits[i] = n % x;
			n /= 10;
		}
		
		if (digits[2]-digits[1] == digits[1]-digits[0]) res = true;
		
		return res;
	}

}
