import java.util.Scanner;

public class Q10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		int i;
		for (i=0 ; i<n ; i++){
			arr[i] = sc.nextInt();
		}
		
		int max = -1000000;
		int min = 1000000;
		for (i=0 ; i<n ; i++){
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
		}
		
		System.out.print(min+" "+max);
		
		sc.close();
	}

}