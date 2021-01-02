// 백준 11049 '행렬 곱셈 순서'
// DP
// 2020.08.17

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] rows = new int[502];
    static int[] cols = new int[502];
    static long[][] dp = new long[502][502];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Get inputs
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());

        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(br.readLine());
            rows[i] = Integer.parseInt(tk.nextToken());
            cols[i] = Integer.parseInt(tk.nextToken());
        }

        // Calc dp
        dp();

        // Print result
        bw.write(Long.toString(dp[1][N]));

        br.close();
        bw.close();
    }

    private static void dp() {
        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j][i] = Long.MAX_VALUE;
                for (int k = j; k <= i; k++) {
                    long cost = (dp[j][k] + dp[k + 1][i] + rows[j] * cols[k] * cols[i]);
                    dp[j][i] = Math.min(dp[j][i], cost);
                }
            }
        }
    }
}
