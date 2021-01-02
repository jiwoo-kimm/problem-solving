import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int res[] = new int[t];
		int tmp1[], tmp2[], count;
		int k, n;
		for (int i=0 ; i<t ; i++){
			
			k = sc.nextInt();
			n = sc.nextInt();
			res[i] = 0;
			
			tmp1 = new int[n];
			tmp2 = new int[n];
			
			for (int j=0 ; j<n ; j++){
				tmp1[j] = j+1;
				tmp2[j] = 0;
			}
			
			boolean isOddFloor = false;
			count = 0;
			while(count < k){
				if (isOddFloor){
					for (int j=0 ; j<n ; j++){
						for (int l=0 ; l<=j ; l++){
							tmp1[j] += tmp2[l];
						}
					}
					for (int j=0 ; j<n ; j++){
						tmp2[j] = 0;
					}
					res[i] = tmp1[n-1];
				}
				else {
					for (int j=0 ; j<n ; j++){
						for (int l=0 ; l<=j ; l++){
							tmp2[j] += tmp1[l];
						}
					}
					for (int j=0 ; j<n ; j++){
						tmp1[j] = 0;
					}
					res[i] = tmp2[n-1];
				}
				count++;
				isOddFloor = !isOddFloor;
			}
		}
		
		for (int i=0 ; i<t ; i++){
			System.out.println(res[i]);
		}
	}

}
