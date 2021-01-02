import java.io.*;

public class Q2231 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int digitCount = (int) Math.log10(n) + 1;
		int generator = n - (9 * digitCount);
		int divisor = 10;
		while (generator != n) {
			
			int digitSum = generator;
			int tmp = generator;
			for (int i=0 ; i<digitCount ; i++){
				digitSum += tmp % divisor;
				tmp /= 10;
			}
			if (digitSum == n){
				break;
			}
			generator++;
		}
		
		if (generator == n) {
			bw.write(Integer.toString(0));
		}
		else {
			bw.write(Integer.toString(generator));
		}
		
		bw.flush();
		bw.close();
	}
}
