// 백준 2193번 이친수
// DP
// 2021.04.13

import java.io.*;

public class Main {

    private static final int MAXIMUM = 90;

    private static int n;
    private static long[] dp = new long[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp();
        bw.append(String.valueOf(dp[n]));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
    }
}