import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 2630 '색종이 만들기'
// Divide & Conquer
// 2020.08.04

public class Main {

	static int N;
	static int[][] color;

	static int whiteCount;
	static int blueCount;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		color = new int[N][N];

		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		checkSquare(N, 0, 0);

		bw.write(Integer.toString(whiteCount) + "\n" + Integer.toString(blueCount));

		br.close();
		bw.close();
	}

	private static void checkSquare(int size, int startX, int startY) {

		// 종료조건 1 : 정사각형 한 칸
		if (size == 1) {
			updateCount(startX, startY);
			return;
		} else {
			// 종료조건 2 : 모두 같은 색
			if (isSameColor(size, startX, startY)) {
				updateCount(startX, startY);
				return;
			// 이외의 경우 분할 & recursion
			} else {
				int newSize = size / 2;
				checkSquare(newSize, startX, startY);
				checkSquare(newSize, startX + newSize, startY);
				checkSquare(newSize, startX, startY + newSize);
				checkSquare(newSize, startX + newSize, startY + newSize);
			}
		}
	}

	private static boolean isSameColor(int size, int startX, int startY) {

		boolean result = true;
		int startVal = color[startX][startY];
		for (int i = startX; i < startX + size && result; i++) {
			for (int j = startY; j < startY + size && result; j++) {
				if (color[i][j] != startVal) {
					result = false;
				}
			}
		}
		return result;
	}

	private static void updateCount(int x, int y) {

		if (color[x][y] == 1)
			blueCount++;
		else
			whiteCount++;
	}
}
