// 2017 카카오코드 예선 : 보행자 천국
// 2021.05.28

import java.util.Arrays;

class Solution {
    
    private static final int MOD = 20170805;
    private static final int PASS = 0;
    private static final int BLOCKED = 1;
    private static final int TURN_BLOCKED = 2;
    private static final int LEFT = 0;
    private static final int UP = 1;
    private static final int MAX = 500;

    private int[][][] dp;

    public int solution(int m, int n, int[][] cityMap) {
        init(m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == BLOCKED) {
                    dp[LEFT][i + 1][j + 1] = 0;
                    dp[UP][i + 1][j + 1] = 0;
                    continue;
                }

                if (i >= 1) {
                    switch (cityMap[i - 1][j]) {
                        case BLOCKED -> dp[UP][i + 1][j + 1] = 0;
                        case TURN_BLOCKED -> dp[UP][i + 1][j + 1] = dp[UP][i][j + 1];
                        case PASS -> dp[UP][i + 1][j + 1] = (dp[UP][i][j + 1] + dp[LEFT][i][j + 1]) % MOD;
                    }
                }

                if (j >= 1) {
                    switch (cityMap[i][j - 1]) {
                        case BLOCKED -> dp[LEFT][i + 1][j + 1] = 0;
                        case TURN_BLOCKED -> dp[LEFT][i + 1][j + 1] = dp[LEFT][i + 1][j];
                        case PASS -> dp[LEFT][i + 1][j + 1] = (dp[LEFT][i + 1][j] + dp[UP][i + 1][j]) % MOD;
                    }
                }
            }
        }
        return (dp[LEFT][m][n] + dp[UP][m][n]) % MOD;
    }

    private void init(int m, int n) {
        dp = new int[2][m + 1][n + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i][0], 0);
            for (int j = 0; j < m + 1; j++) dp[i][j][0] = 0;
        }
        dp[LEFT][1][1] = 1;
    }
}