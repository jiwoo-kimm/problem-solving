import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		/*
		int unit = a-b;
		v -= b;
		int answer = v / unit;
		if(v % unit > 0)
			answer++;
		
		System.out.println(answer);
		*/
		
		int unit = a-b;
		v -= a;
		int count = v / unit + 1;
		if (v % unit > 0)	// v % unit != 0 : 시간초과
			count ++;
		System.out.println(count);
	}

}
