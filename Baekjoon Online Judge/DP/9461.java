import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 9461 '파도반 수열'
// DP
// 2020.07.16

public class Main {

	static int T;
	static long res[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		T = Integer.parseInt(tk.nextToken());
		res = new long[110];
		res[0] = 0;
		res[1] = 1;
		res[2] = 1;
		res[3] = 1;

		for (int i = 4; i <= 100; i++) {
			res[i] = res[i - 2] + res[i - 3];
		}

		int n;
		for (int i = 0; i < T; i++) {
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			bw.write(Long.toString(res[n]) + "\n");
		}

		br.close();
		bw.close();
	}
}
