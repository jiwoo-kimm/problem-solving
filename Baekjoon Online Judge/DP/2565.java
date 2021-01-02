import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 백준 2565 '전깃줄'
// DP
// 2020.07.24

public class Main {

	static int N;
	static int lines[][];
	static int connected[];
	static int maxLines;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		lines = new int[N + 1][2];
		connected = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				lines[i][j] = Integer.parseInt(tk.nextToken());
			}
		}

		Arrays.sort(lines, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});

		/*
		Arrays.sort(lines, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return Integer.compare(o1[1], o2[1]);
			} else {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		*/

		for (int i = 1; i <= N; i++) {
			connected[i] = 1;
			for (int j = 1; j < i; j++) {
				if (lines[i][1] > lines[j][1] && connected[j] + 1 > connected[i])
					connected[i] = connected[j] + 1;
			}
			if (maxLines < connected[i])
				maxLines = connected[i];
		}

		bw.write(Integer.toString(N - maxLines));

		br.close();
		bw.close();
	}
}
