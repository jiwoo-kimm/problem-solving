// 프로그래머스 '2xn 타일링'
// 2021.02.22

public class Tile {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    private static final int MOD = 1000000007;
    private static int[] dp = new int[60001];

    public static int solution(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        return dp[n];
    }
}