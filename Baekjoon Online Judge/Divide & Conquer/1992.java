import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1992 '쿼드트리'
// Divide & Conquer
// 2020.08.04

public class Main {

	static int N;
	static int[][] color;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		color = new int[N][N];

		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < N; j++) {
				color[i][j] = Integer.parseInt("" + line.charAt(j));
			}
		}

		quadTree(N, 0, 0);

		bw.write(sb.toString());

		br.close();
		bw.close();
	}

	private static void quadTree(int size, int startX, int startY) {

		// 종료조건 1 : 정사각형 한 칸
		if (size == 1) {
			sb.append(color[startX][startY]);
			return;
		} else {
			// 종료조건 2 : 모두 같은 색
			if (isSameColor(size, startX, startY)) {
				sb.append(color[startX][startY]);
				return;
				// 이외의 경우 분할 & recursion
			} else {
				int newSize = size / 2;
				sb.append('(');
				quadTree(newSize, startX, startY);
				quadTree(newSize, startX, startY + newSize);
				quadTree(newSize, startX + newSize, startY);
				quadTree(newSize, startX + newSize, startY + newSize);
				sb.append(')');
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
}
