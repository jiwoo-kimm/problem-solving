import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 2748 '피보나치 수 2'
// DP
// 2020.07.13

public class Main {

	static int N;
	static long res[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		res = new long[N + 1];

		// bw.write(Long.toString(fib(N)));

		res[0] = 0;
		res[1] = 1;
		for (int i = 2; i <= N; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}

		bw.write(Long.toString(res[N]));

		br.close();
		bw.close();
	}

//	private static long fib(int n) {
//
//		if (n == 1)
//			return 1;
//		if (n == 2)
//			return 1;
//		if (res[n] != 0)
//			return res[n];
//		return res[n] = fib(n - 1) + fib(n - 2);
//	}

}
