// 프로그래머스 도둑질
// DP
// 2021.04.16

class Solution {
    
    private static final int MAX = 1000000;
    private static final int LAST_NOT_VISITED = 0;
    private static final int FIRST_NOT_VISITED = 1;

    private int[][] dp = new int[2][MAX + 1];

    public int solution(int[] money) {
        dp(money);
        return Math.max(dp[LAST_NOT_VISITED][money.length - 1], dp[FIRST_NOT_VISITED][money.length]);
    }

    private void dp(int[] money) {
        dp[LAST_NOT_VISITED][1] = money[0];
        dp[LAST_NOT_VISITED][2] = money[1];
        dp[FIRST_NOT_VISITED][1] = 0;
        dp[FIRST_NOT_VISITED][2] = money[1];
        for (int i = 3; i <= money.length; i++) {
            dp[LAST_NOT_VISITED][i] = Math.max(dp[LAST_NOT_VISITED][i - 2] + money[i - 1],
                    Math.max(dp[LAST_NOT_VISITED][i - 3] + money[i - 1],
                            dp[LAST_NOT_VISITED][i - 1]));
            dp[FIRST_NOT_VISITED][i] = Math.max(dp[FIRST_NOT_VISITED][i - 2] + money[i - 1],
                    Math.max(dp[FIRST_NOT_VISITED][i - 3] + money[i - 1],
                            dp[FIRST_NOT_VISITED][i - 1]));
        }
    }
}