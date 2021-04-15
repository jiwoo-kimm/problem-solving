// 백준 11052번 카드 구매하기
// DP
// 2021.04.15

import java.io.*;

public class Main {

    private static final int MAXIMUM = 1000;

    private static int n;
    private static int[] prices = new int[MAXIMUM + 1];
    private static int[] dp = new int[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            prices[i] = Integer.parseInt(line[i - 1]);

        dp();
        bw.append(String.valueOf(dp[n]));

        br.close();
        bw.close();
    }

    private static void dp() {
        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i];
            for (int j = 1; j <= i / 2; j++)
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
        }
    }
}