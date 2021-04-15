// 백준 10844번 쉬운 계단 수
// DP
// 2020.07.21, 2021.04.15

import java.io.*;

public class Main {

    private static final int MAXIMUM = 100;
    private static final int MOD = 1000000000;
    private static final int NUMBERS = 10;

    private static int n;
    private static long[][] dp = new long[MAXIMUM + 1][NUMBERS];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp();
        bw.append(String.valueOf(sum(dp[n])));

        br.close();
        bw.close();
    }

    private static void dp() {
        for (int i = 1; i < NUMBERS; i++) dp[1][i] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j < NUMBERS; j++)
                if (j == 0) dp[i][j] = dp[i - 1][j + 1];
                else if (j == 9) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
    }

    private static long sum(long[] arr) {
        long sum = 0;
        for (long num : arr) sum = (sum + num) % MOD;
        return sum;
    }
}