// 백준 1149번 RGB거리
// DP
// 2020.07.18, 2021.04.14

import java.io.*;

public class Main {

    private static final int MAXIMUM = 1000;
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;
    private static final int COLORS = 3;

    private static int n;
    private static int[][] costs = new int[MAXIMUM + 1][COLORS];
    private static int[][] dp = new int[MAXIMUM + 1][COLORS];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String[] chunks = br.readLine().split(" ");
            costs[i][RED] = Integer.parseInt(chunks[RED]);
            costs[i][GREEN] = Integer.parseInt(chunks[GREEN]);
            costs[i][BLUE] = Integer.parseInt(chunks[BLUE]);
        }

        dp();
        bw.append(String.valueOf(Math.min(Math.min(dp[n][RED], dp[n][GREEN]), dp[n][BLUE])));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1][RED] = costs[1][RED];
        dp[1][GREEN] = costs[1][GREEN];
        dp[1][BLUE] = costs[1][BLUE];
        for (int i = 2; i <= n; i++) {
            dp[i][RED] = costs[i][RED] + Math.min(dp[i - 1][GREEN], dp[i - 1][BLUE]);
            dp[i][GREEN] = costs[i][GREEN] + Math.min(dp[i - 1][RED], dp[i - 1][BLUE]);
            dp[i][BLUE] = costs[i][BLUE] + Math.min(dp[i - 1][RED], dp[i - 1][GREEN]);
        }
    }
}