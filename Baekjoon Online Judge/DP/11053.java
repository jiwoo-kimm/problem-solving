// 백준 11053번 가장 긴 증가하는 수열
// DP
// 2020.07.22, 2021.04.14

import java.io.*;

public class Main {

    private static final int MAXIMUM = 1000;

    private static int n;
    private static int[] arr = new int[MAXIMUM + 1];
    private static int[] dp = new int[MAXIMUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(line[i - 1]);

        dp();
        bw.append(String.valueOf(getMax()));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--)
                if (arr[i] > arr[j]) max = Math.max(max, dp[j]);
            dp[i] = max + 1;
        }
    }

    private static int getMax() {
        int max = 0;
        for (int val : dp) max = Math.max(max, val);
        return max;
    }
}