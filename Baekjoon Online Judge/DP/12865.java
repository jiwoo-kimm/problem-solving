import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// ���� 12865 '����� �賶'
// DP
// 2020.07.25

public class Main {

	static int N;
	static int K;
	static int weight[];
	static int value[];

	static int res[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		K = Integer.parseInt(tk.nextToken());
		weight = new int[N + 1];
		value = new int[N + 1];
		res = new int[N + 1][K + 1];

		weight[0] = 0;
		value[0] = 0;
		for (int i = 1; i <= N; i++) {
			tk = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(tk.nextToken());
			value[i] = Integer.parseInt(tk.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (weight[i] <= j) {	// i��° ������ ���԰� �Ѱ�뷮 ������ ��
					res[i][j] = Math.max(value[i] + res[i - 1][j - weight[i]], res[i - 1][j]);	// ���� ������, �ȳ����� �� �� ū �� �ֱ�
				} else {
					res[i][j] = res[i - 1][j];	// �Ѱ�뷮 �̻��̸� ���� �ִ� �״�� �ֱ�
				}
			}
		}

		bw.write(Integer.toString(res[N][K]));

		br.close();
		bw.close();
	}
}