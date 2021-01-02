import java.util.Scanner;

public class Q2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		
		int i;
		for (i=0 ; i<9 ; i++){
			arr[i] = sc.nextInt();
		}
		
		int idx = -1;
		int max = -1000000;
		for (i=0 ; i<9 ; i++){
			if (arr[i] > max){
				max = arr[i];
				idx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
	}

}