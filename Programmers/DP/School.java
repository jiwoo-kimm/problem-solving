// 프로그래머스 등굣길
// DP
// 2021.04.16

class Solution {
    
    private static final int MOD = 1000000007;
    private static final int MAX = 100;
    private static final int X = 0;
    private static final int Y = 1;
    
    private int[][] dp = new int[MAX + 1][MAX + 1];

    public int solution(int m, int n, int[][] puddles) {
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                if (isPuddle(i, j, puddles)) dp[i][j] = 0;
                else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
        return dp[n][m];
    }

    private boolean isPuddle(int i, int j, int[][] puddles) {
        for (int[] puddle : puddles)
            if (puddle[Y] == i && puddle[X] == j) return true;

        return false;
    }
}