// 백준 11057번 오르막 수
// DP
// 2021.04.15

import java.io.*;

public class Main {

    private static final int MAXIMUM = 1000;
    private static final int MOD = 10007;
    private static final int NUMBERS = 10;

    private static int n;
    private static int[][] dp = new int[MAXIMUM + 1][NUMBERS];

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
        for (int i = 0; i < NUMBERS; i++) dp[1][i] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = 0; j < NUMBERS; j++)
                dp[i][j] = countAddable(dp[i - 1], j) % MOD;
    }

    private static int countAddable(int[] arr, int upperBound) {
        int count = 0;
        for (int i = 0; i <= upperBound; i++) count = (count + arr[i]) % MOD;
        return count;
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int val : arr) sum = (sum + val) % MOD;
        return sum;
    }
}