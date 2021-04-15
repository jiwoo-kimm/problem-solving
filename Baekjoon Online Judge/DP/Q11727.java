// 백준 11727번 2xn 타일링 2
// DP
// 2021.04.15

import java.io.*;

public class Main {

    private static final int MAXIMUM = 1000;
    private static final int MOD = 10007;

    private static int n;
    private static int[] dp = new int[MAXIMUM + 1];

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
        dp[2] = 3;
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD;
    }
}