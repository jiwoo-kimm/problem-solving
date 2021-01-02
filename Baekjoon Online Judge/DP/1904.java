import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1904 '01타일'
// DP
// 2020.07.15

public class Main {

	static int N;
	static int count[];
	static final int MAX_N = 1000000 + 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(tk.nextToken());
		count = new int[MAX_N];

		count[0] = 1;
		count[1] = 1;
		for (int i = 2; i <= N; i++) {
			count[i] = (count[i - 1] + count[i - 2]) % 15746;
		}

		bw.write(Integer.toString(count[N]));

		br.close();
		bw.close();
	}
}
