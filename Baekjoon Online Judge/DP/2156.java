import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 2156 '포도주 시식'
// DP
// 2020.07.21

public class Main {

	static int N;
	static int cost[] = new int[10001];
	static int maxCost[] = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());

		for (int i = 1; i < N + 1; i++) {
			tk = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(tk.nextToken());
		}

		maxCost[1] = cost[1];
		maxCost[2] = maxCost[1] + cost[2];
		for (int i = 3; i < N + 1; i++) {
			maxCost[i] = cost[i] + Math.max(maxCost[i - 2], cost[i - 1] + maxCost[i - 3]);
			maxCost[i] = Math.max(maxCost[i], maxCost[i - 1]);
		}

		bw.write(Integer.toString(maxCost[N]));

		br.close();
		bw.close();
	}
}
