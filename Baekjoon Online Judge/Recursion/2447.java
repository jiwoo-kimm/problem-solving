import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char arr[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new char[n][n];
		for (int i=0 ; i<n ; i++){
			Arrays.fill(arr[i], ' ');
		}
		
		make_stars(n, 0, 0);
		
		for (int i=0 ; i<n ; i++){
			System.out.println(arr[i]);
		}
	}

	private static void make_stars(int n, int row, int col) {
		
		if (n == 1){
			arr[row][col] = '*';
			return;
		}
		
		int m = n / 3;
		for (int i=0 ; i<3 ; i++){
			for (int j=0 ; j<3 ; j++){
				if (i==1 && j==1) continue;	// 3x3의 가운데만 비우고 재귀 호출
				make_stars(m, row + i*m, col + j*m);
			}
		}
	}

}