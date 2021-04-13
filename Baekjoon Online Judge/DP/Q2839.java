// 백준 2839번 설탕 배달
// DP
// 2021.04.13

package dp;

import java.io.*;

public class Main {

    private static final int IMPOSSIBLE = -1;
    private static final int MAXIMUM = 5000;

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
        dp[1] = IMPOSSIBLE;
        dp[2] = IMPOSSIBLE;
        for (int i = 3; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = i / 5;
                continue;
            }
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0) min = Math.min(min, i / 3);
            for (int j = i - 1; j >= i / 2; j--)
                if (dp[j] != IMPOSSIBLE && dp[i - j] != IMPOSSIBLE)
                    min = Math.min(min, dp[j] + dp[i - j]);
            dp[i] = (min == Integer.MAX_VALUE ? IMPOSSIBLE : min);
        }
    }
}
