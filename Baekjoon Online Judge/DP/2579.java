// 백준 2579번 계단 오르기
// DP
// 2020.07.20, 2021.04.14

import java.io.*;

public class Main {

    private static final int MAXIMUM = 300;

    private static int n;
    private static int[] costs = new int[MAXIMUM + 1];
    private static int[] dp = new int[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++)
            costs[i] = Integer.parseInt(br.readLine());

        dp();
        bw.append(String.valueOf(dp[n]));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1] = costs[1];
        dp[2] = costs[1] + costs[2];
        for (int step = 3; step <= n; step++)
            dp[step] = Math.max(dp[step - 3] + costs[step - 1], dp[step - 2])
                    + costs[step];
    }
}