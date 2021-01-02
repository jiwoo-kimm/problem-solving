import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1932 '정수 삼각형'
// DP
// 2020.07.19

public class Main {

	static int N;
	static int cost[][];
	static final int MAX_COST = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		cost = new int[N + 10][N + 10];

		cost[0][0] = 0;
		cost[0][1] = 0;

		int n;
		for (int i = 1; i < N + 1; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 1; j < i + 1; j++) {
				n = Integer.parseInt(tk.nextToken());
				cost[i][j] = n;
				cost[i][j] += Math.max(cost[i - 1][j - 1], cost[i - 1][j]);
			}
		}

		int res = max(cost[N]);

		bw.write(Integer.toString(res));

		br.close();
		bw.close();
	}

	private static int max(int[] arr) {

		int max = 0;
		int size = arr.length;

		for (int i = 1; i < size + 1; i++) {
			if (arr[i] == 0)
				return max;
			if (arr[i] > max)
				max = arr[i];
		}

		return max;
	}
}
