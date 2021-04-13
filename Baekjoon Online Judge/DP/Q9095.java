// 백준 9095번 1, 2, 3 더하기
// DP
// 2021.04.13

package dp;

import java.io.*;

public class Q9095 {

    private static final int MAXIMUM = 10;

    private static int n;
    private static int[] dp = new int[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        dp();
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(dp[n])).append("\n");
        }

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= MAXIMUM; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
}
