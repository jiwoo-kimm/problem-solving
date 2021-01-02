import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1436 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[10000];
		
		int num = 0;
		int idx = 0;
		while (true) {
			if (Integer.toString(num).contains("666")){
				arr[idx] = num;
				if (idx == n-1)
					break;
				idx++;
			}
			num++;
		}
		
		bw.write(Integer.toString(arr[idx]));
		bw.flush();
		bw.close();
	}
}
