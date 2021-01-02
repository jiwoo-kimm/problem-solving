// 백준 15650 'N과 M (2)'
// Backtracking

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int arr[];
	static BufferedWriter bw;

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

	private static void backtracking(int i, int N) throws IOException {
		// TODO Auto-generated method stub

		if (i == arr.length) {
			for (int j = 0; j < i; j++) {
				bw.write(arr[j] + " ");
			}
			bw.write("\n");
		} else {
			for (int j = 1; j < N + 1; j++) {
				if (!contains(j, i)) {
					if (ascending(j, i)) {
						arr[i] = j;
						backtracking(i + 1, N);
					}
				}
			}
		}
	}

	private static boolean ascending(int key, int k) {
		// TODO Auto-generated method stub
		if (k == 0) return true;
		
		if (arr[k - 1] < key)
			return true;			
		else return false;
	}

	private static boolean contains(int find, int k) {
		// TODO Auto-generated method stub
		for (int i = 0; i < k; i++) {
			if (arr[i] == find)
				return true;
		}
		return false;
	}

}
