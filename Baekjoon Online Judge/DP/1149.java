import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1149 'RGB거리`
// DP
// 2020.07.18

public class Main {

	static int N;
	static int cost[][];
	static int minCost[][];
	static int rgb[];

	static final int MAX_N = 1010;

	static final int R = 0;
	static final int G = 1;
	static final int B = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		cost = new int[MAX_N][3];

		int n;
		tk = new StringTokenizer(br.readLine());
		for (int j = 0; j < 3; j++) {
			n = Integer.parseInt(tk.nextToken());
			cost[1][j] = n;
		}

		for (int i = 2; i < N + 1; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				n = Integer.parseInt(tk.nextToken());
				cost[i][j] = n;
			}
		}

		for (int i = 2; i < N + 1; i++) {
			cost[i][R] += Math.min(cost[i - 1][G], cost[i - 1][B]);
			cost[i][G] += Math.min(cost[i - 1][R], cost[i - 1][B]);
			cost[i][B] += Math.min(cost[i - 1][R], cost[i - 1][G]);
		}

		int res = Math.min(Math.min(cost[N][R], cost[N][G]), cost[N][B]);
		bw.write(Integer.toString(res));

		br.close();
		bw.close();
	}
}
