// 백준 2580 '스도쿠'
// Backtracking

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2580 {

	static BufferedWriter bw;

	static int[][] sudoku = new int[9][9];

	// 채워야하는 칸 좌표 (x, y)
	static ArrayList<Integer> xBlanks = new ArrayList<Integer>();
	static ArrayList<Integer> yBlanks = new ArrayList<Integer>();

	static boolean[][] row = new boolean[9][10]; // row[i][j] : i번째 row에 숫자 j가 쓰였는가
	static boolean[][] col = new boolean[9][10]; // col[i][j] : i번째 col에 숫자 j가 쓰였는가
	static boolean[][] square = new boolean[9][10]; // square[i][j] : i번째 square에 숫자 j가 쓰였는가

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력받고 각 배열에 저장
		for (int i = 0; i < 9; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(tk.nextToken());
				if (sudoku[i][j] != 0) {
					row[i][sudoku[i][j]] = true;
					col[j][sudoku[i][j]] = true;
					square[squareIndex(i, j)][sudoku[i][j]] = true;
				} else {
					xBlanks.add(i);
					yBlanks.add(j);
				}
			}
		}

		backtracking(0);
	}

	private static int squareIndex(int i, int j) {
		return i / 3 * 3 + j / 3;
	}

	private static void printResult() throws IOException {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				bw.write(Integer.toString(sudoku[i][j]) + " ");
			}
			bw.write("\n");
		}
		bw.close();
		System.exit(0);
	}

	private static void backtracking(int count) throws IOException {

		if (count == xBlanks.size()) {
			printResult();
		}

		int x = xBlanks.get(count);
		int y = yBlanks.get(count);
		for (int i = 1; i <= 9; i++) {
			// 행, 열, 사각형 체크
			if (!row[x][i] && !col[y][i] && !square[squareIndex(x, y)][i]) {
				sudoku[x][y] = i;
				row[x][i] = true;
				col[y][i] = true;
				square[squareIndex(x, y)][i] = true;
				backtracking(count + 1);	// 숫자 채워넣은 후 다음 좌표 호출

				sudoku[x][y] = 0;
				row[x][i] = false;
				col[y][i] = false;
				square[squareIndex(x, y)][i] = false;
			}
		}
	}
}
