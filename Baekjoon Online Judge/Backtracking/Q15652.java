// 백준 15652 'N과 M (4)'
// Backtracking

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedWriter bw;

	static int M;
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		arr = new int[M];

		backtracking(0);

		bw.close();
	}

	private static void backtracking(int count) throws IOException {

		if (count == M) {
			for (int i : arr) {
				bw.write(Integer.toString(i) + " ");
			}
			bw.write("\n");
		}

		else {
			for (int i = 1; i <= N; i++) {
				if (!descending(count, i)) {
					arr[count] = i;
					backtracking(count + 1);
				}
			}
		}
	}

	private static boolean descending(int count, int key) {
		if (count == 0)
			return false;

		else if (arr[count - 1] > key)
			return true;
		else
			return false;
	}
}
