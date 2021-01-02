import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1003 '피보나치 함수'
// DP
// 2020.07.13

public class Main {

	static int N;
	static int zeroCnt[];
	static int oneCnt[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());

		zeroCnt = new int[41];
		oneCnt = new int[41];

		zeroCnt[0] = 1;
		oneCnt[0] = 0;

		zeroCnt[1] = 0;
		oneCnt[1] = 1;

		for (int i = 2; i < 41; i++) {
			zeroCnt[i] = zeroCnt[i - 1] + zeroCnt[i - 2];
			oneCnt[i] = oneCnt[i - 1] + oneCnt[i - 2];
		}

		int index;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			index = Integer.parseInt(tk.nextToken());
			bw.write(Integer.toString(zeroCnt[index]) + " " + Integer.toString(oneCnt[index]) + "\n");
		}

		br.close();
		bw.close();
	}
}
