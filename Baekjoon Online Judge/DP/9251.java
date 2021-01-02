import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 백준 9251 'LCS'
// DP
// 2020.07.24

public class Main {

	static String str1;
	static String str2;
	static int len1;
	static int len2;
	static int count[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());
		str1 = tk.nextToken();

		tk = new StringTokenizer(br.readLine());
		str2 = tk.nextToken();

		len1 = str1.length();
		len2 = str2.length();
		count = new int[len1 + 1][len2 + 1];

		for (int i = 0; i < len1; i++) {
			count[i][0] = 0;
		}
		for (int i = 0; i < len2; i++) {
			count[0][i] = 0;
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					count[i][j] = count[i - 1][j - 1] + 1;
				} else {
					count[i][j] = Math.max(count[i][j - 1], count[i - 1][j]);
				}
			}
		}

		bw.write(Integer.toString(count[len1][len2]));

		br.close();
		bw.close();
	}
}
