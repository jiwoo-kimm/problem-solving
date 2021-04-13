// 백준 1463번 1로 만들기
// DP
// 2021.04.13

package dp;

import java.io.*;

public class Q1463 {

    private static final int MAXIMUM = 1000000;

    private static int n;
    private static int[] dp = new int[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp();
        bw.append(Integer.toString(dp[n]));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) min = Math.min(min, dp[i / 3]);
            if (i % 2 == 0) min = Math.min(min, dp[i / 2]);
            min = Math.min(min, dp[i - 1]);
            dp[i] = min + 1;
        }
    }
}
