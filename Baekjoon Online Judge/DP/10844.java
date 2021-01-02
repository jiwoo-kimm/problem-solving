import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 10844 '쉬운 계단 수'
// DP
// 2020.07.21

public class Main {

	static int N;
	static long count[][];
	static final int mod = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		count = new long[101][10];

		count[1][0] = 0;
		for (int i = 1; i < 10; i++) {
			count[1][i] = 1;
		}

		for (int i = 2; i < N + 1; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					count[i][j] = count[i - 1][1];
				else if (j == 9)
					count[i][j] = count[i - 1][8];
				else
					count[i][j] = count[i - 1][j - 1] + count[i - 1][j + 1];
				count[i][j] %= mod;
			}
		}

		long res = 0;
		for (int i = 0; i < 10; i++) {
			res += count[N][i];
			res %= mod;
		}

		bw.write(Long.toString(res));

		br.close();
		bw.close();
	}
}
