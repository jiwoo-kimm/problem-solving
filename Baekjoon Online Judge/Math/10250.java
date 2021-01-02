import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int h, w, n, tmp;
		int t = sc.nextInt();
		String room[] = new String[t];
		for (int i=0 ; i<t ; i++){

			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();
			
			room[i] = "";
			
			// Ãþ
			tmp = n % h;
			if (tmp == 0)
				room[i] += h;
			else
				room[i] += tmp;
			
			// È£¼ö
			tmp = (int) Math.ceil((double)n / h);
			if (tmp < 10)
				room[i] += "0";
			room[i] += tmp;
		}
		
		for (int i=0 ; i<t ; i++){
			System.out.println(room[i]);
		}
		
		
	}

}
