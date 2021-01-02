import java.util.Scanner;

public class Q2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int mul = a * b * c;
		
		int counts[] = new int[10];  // 배열 0으로 모두 자동 초기화
		
		int x = 10;
		int n;
		boolean cont = true;
		while (cont){
			n = mul % x / (x / 10);
			counts[n]++;
			if (mul / x == 0) cont = false;
			x *= 10;
		}
		
		for (int i=0 ; i<10 ; i++){
			System.out.println(counts[i]);
		}
		
	}

}
