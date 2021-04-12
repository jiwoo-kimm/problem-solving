// 백준 1146번 지그재그 서기
// DP
// 2021.04.12

import java.io.*;

public class Q1146 {

    private static final int INITIAL_VALUE = -1;
    private static final int MOD = 1000000;

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int n;
    private static int[][] dp = new int[100][100];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initParams();
        int answer = Math.max(calcAnswer(), 1);
        bw.append(Integer.toString(answer));

        br.close();
        bw.close();
    }

    private static void initParams() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp.length; j++)
                dp[i][j] = INITIAL_VALUE;
    }

    private static int calcAnswer() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = (answer + dp(i, n - i - 1)) % MOD;
            answer = (answer + dp(n - i - 1, i)) % MOD;
        }
        return answer;
    }

    private static int dp(int left, int right) {
        if (left + right == 0) return 1;
        if (dp[left][right] != INITIAL_VALUE) return dp[left][right];

        int result = 0;
        if (right == 0) return result;
        for (int i = 0; i < right; ++i)
            result = (result + dp(right - i - 1, left + i)) % MOD;
        return result;
    }
}
