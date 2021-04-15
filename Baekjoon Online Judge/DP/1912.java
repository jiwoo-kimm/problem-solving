// 백준 1912번 연속합
// DP
// 2020.07.25, 2021.04.15

import java.io.*;

public class Main {

    private static final int MAXIMUM = 100000;

    private static int n;
    private static long[] nums = new long[MAXIMUM + 1];
    private static long[] dp = new long[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++)
            nums[i] = Integer.parseInt(line[i - 1]);

        dp();
        bw.append(String.valueOf(findMax()));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1] = nums[1];
        for (int i = 2; i <= n; i++)
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
    }

    private static long findMax() {
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) max = Math.max(max, dp[i]);
        return max;
    }
}