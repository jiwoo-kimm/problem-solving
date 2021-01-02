import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 11053 '가장 긴 증가하는 부분 수열'
// DP
// 2020.07.22

public class Main {

	static int N;
	static int arr[];
	static int count[];
	static int res;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		arr = new int[N];
		count = new int[N];

		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
			count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && count[j] + 1 > count[i])
					count[i] = count[j] + 1;
			}
			if (count[i] > res)
				res = count[i];
		}

		bw.write(Integer.toString(res));

		br.close();
		bw.close();
	}
}
