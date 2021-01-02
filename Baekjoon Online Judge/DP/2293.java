// 백준 2293 '동전 1'
// DP
// 2020.08.15

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] coins = new int[101];
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Get inputs
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());

        for (int i = 1; i <= n; i++) {
            tk = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(tk.nextToken());
        }

        // Get result
        dp();

        // Print output
        bw.write(Integer.toString(dp[k]));

        br.close();
        bw.close();
    }

    private static void dp() {
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
    }
}
