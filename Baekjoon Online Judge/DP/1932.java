// 백준 1932번 정수 삼각형
// DP
// 2020.07.19, 2021.04.14

import java.io.*;

public class Main {

    private static final int MAXIMUM = 500;

    private static int n;
    private static int[][] triangle = new int[MAXIMUM + 1][MAXIMUM + 1];
    private static int[][] dp = new int[MAXIMUM + 1][MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(line[j - 1]);
            }
        }

        dp();
        bw.append(String.valueOf(getMax()));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1][0] = 0;
        dp[1][1] = triangle[1][1];
        for (int i = 2; i <= n; i++)
            for (int j = 1; j <= i; j++)
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
    }

    private static int getMax() {
        int max = 0;
        for (int val : dp[n])
            max = Math.max(max, val);
        return max;
    }
}