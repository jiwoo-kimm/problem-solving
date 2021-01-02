// 백준 9663 'N-Queen'
// Backtracking

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] cols;
	static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		cols = new int[N + 1];

		nqueen(0);

		bw.write(Integer.toString(count));
		bw.close();
	}

	private static void nqueen(int row) {

		int i;
		if (promising(row)) {
			if (row == N)
				count++;
			else {
				for (i = 1; i <= N; i++) {
					cols[row + 1] = i;
					nqueen(row + 1);
				}
			}
		}
	}

	private static boolean promising(int row) {

		int i = 1;
		while (i < row) {
			if (cols[row] == cols[i] || Math.abs(cols[row] - cols[i]) == row - i)
				return false;
			i++;
		}
		return true;
	}

}
