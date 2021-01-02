import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1463 '1로 만들기'
// DP
// 2020.07.20

public class Main {

	static int N;
	static int cost[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		cost = new int[N + 10];

		cost[1] = 0;

		for (int i = 2; i < N + 1; i++) {
			if (i % 3 == 0)
				cost[i] = Math.min(cost[i / 3], cost[i - 1]) + 1;
			else if (i % 2 == 0)
				cost[i] = Math.min(cost[i / 2], cost[i - 1]) + 1;
			else
				cost[i] = cost[i - 1] + 1;

		}

		bw.write(Integer.toString(cost[N]));

		br.close();
		bw.close();
	}
}
