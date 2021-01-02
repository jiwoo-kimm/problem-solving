import java.util.Scanner;

public class Q1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		float scores[] = new float[n];
		float max = 0;
		
		int i;
		for (i=0 ; i<n ; i++){
			scores[i] = sc.nextFloat();
			if (scores[i] > max){
				max = scores[i];
			}
		}
		
		float avg = 0;
		for (i=0 ; i<n ; i++){
			scores[i] = scores[i] / max * 100;
			avg += scores[i];
		}
		
		avg = avg / n;
		
		System.out.println(avg);

	}

}
