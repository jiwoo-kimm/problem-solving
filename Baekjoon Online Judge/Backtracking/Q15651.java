// 백준 15651 'N과 M (3)'
// Backtracking

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedWriter bw;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		arr = new int[M];

		backtracking(0, N);

		bw.close();
	}

	public static void backtracking(int i, int N) throws IOException {

		if (i == arr.length) {
			for (int j = 0; j < arr.length; j++) {
				bw.write(Integer.toString(arr[j]) + " ");
			}
			bw.write("\n");
		} else {
			for (int j = 1; j <= N; j++) {
				arr[i] = j;
				backtracking(i + 1, N);
			}
		}
	}
}
