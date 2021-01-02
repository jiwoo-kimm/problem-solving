import java.util.Scanner;

public class Q3052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int nums[] = new int[10];
		int vals[] = new int[10];
		
		int i;
		for (i=0 ; i<10 ; i++){
			nums[i] = sc.nextInt();
			vals[i] = nums[i] % 42;
		}
		
		int j;
		int count = 0;
		boolean isNew = true;
		for (i=0 ; i<10 ; i++){
			isNew = true;
			for (j=0; j<i; j++){
				if (vals[i] == vals[j]){
					isNew = false;
					break;
				}
			}
			if (isNew){
				count++;
			}
		}
		
		System.out.print(count);
	}

}
