import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1912 '연속합'
// DP
// 2020.07.25

public class Main {

	static int N;
	static int cost[];
	static int res = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		cost = new int[N + 1];

		cost[0] = 0;
		tk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(tk.nextToken());
			if (cost[i - 1] + cost[i] > cost[i])
				cost[i] += cost[i - 1];
			if (cost[i] > res)
				res = cost[i];
		}

		bw.write(Integer.toString(res));

		br.close();
		bw.close();
	}
}
