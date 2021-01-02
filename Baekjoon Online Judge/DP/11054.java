import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 11054 '가장 긴 바이토닉 부분 수열'
// DP
// 2020.07.22

public class Main {

	static int N;
	static int arr[];
	static int asc[];
	static int desc[];
	static int res;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		arr = new int[N];
		asc = new int[N];
		desc = new int[N];

		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
			asc[i] = 1;
			for (int j = 0; j < i; j++) {
				if (asc[j] + 1 > asc[i] && arr[i] > arr[j]) {
					asc[i] = asc[j] + 1;
				}
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			desc[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (desc[j] + 1 > desc[i] && arr[i] > arr[j]) {
					desc[i] = desc[j] + 1;
				}
			}
			if (asc[i] + desc[i] - 1 > res)
				res = asc[i] + desc[i] - 1;
		}

		bw.write(Integer.toString(res));

		br.close();
		bw.close();
	}
}