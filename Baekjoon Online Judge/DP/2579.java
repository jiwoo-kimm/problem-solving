import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2579 '계단 오르기'
// DP
// 2020.07.20

public class Main {

	static int N;
	static int cost[];
	static int maxCost[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		cost = new int[N + 10];
		maxCost = new int[N + 10];

		int n;
		for (int i = 1; i < N + 1; i++) {
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			cost[i] = n;
		}

		maxCost[0] = 0;
		maxCost[1] = cost[1];
		maxCost[2] = cost[1] + cost[2];
		for (int i = 3; i < N + 1; i++) {
			maxCost[i] = Math.max(cost[i] + cost[i - 1] + maxCost[i - 3], cost[i] + maxCost[i - 2]);
		}

		bw.write(Integer.toString(maxCost[N]));

		br.close();
		bw.close();
	}
}
