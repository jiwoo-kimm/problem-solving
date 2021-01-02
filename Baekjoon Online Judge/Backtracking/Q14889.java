import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 14889 '스타트와 링크'
// Backtracking
// 2020.07.11

public class Main {

	static int N;
	static int ability[][];
	static boolean isStartMember[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		ability = new int[N][N];
		isStartMember = new boolean[N];

		int tmp;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				tmp = Integer.parseInt(tk.nextToken());
				ability[i][j] = tmp;
			}
		}

		backtracking(0, -1);

		bw.write(Integer.toString(min));

		br.close();
		bw.close();
	}

	private static void backtracking(int count, int index) {

		if (count == N / 2) {
			min = Math.min(min, getDist());
		} else if (count < N / 2) {
			for (int i = index + 1; i < N; i++) {
				isStartMember[i] = true;
				backtracking(count + 1, i);
				isStartMember[i] = false;
			}
		}
	}

	private static int getDist() {

		int startSum = 0;
		int linkSum = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isStartMember[i] && isStartMember[j]) {
					startSum += ability[i][j];
				} else if (!isStartMember[i] && !isStartMember[j]) {
					linkSum += ability[i][j];
				}
			}
		}

		return Math.abs(startSum - linkSum);
	}
}
