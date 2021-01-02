import java.util.Scanner;
import java.util.ArrayList;

public class Q4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int nums[] = new int[c];
		float perc[] = new float[c];
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		float avg = 0;
		int i, j, input;
		for (i=0 ; i<c ; i++){
			nums[i] = sc.nextInt();
			for (j=0 ; j<nums[i] ; j++){
				input = sc.nextInt();
				arr.add(input);
				avg += input;
			}
			avg /= nums[i];
			for (j=0 ; j<nums[i] ; j++){
				if (arr.get(j) > avg)
					perc[i]++;
			}
			perc[i] /= nums[i];
			avg = 0;
			arr.clear();
		}
		
		for (i=0 ; i<c ; i++){
			System.out.printf("%.3f%%\n", perc[i]*100);
		}
		sc.close();
	}

}
