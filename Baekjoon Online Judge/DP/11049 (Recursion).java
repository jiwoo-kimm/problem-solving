// 백준 11049 '행렬 곱셈 순서'
// DP
// 2020.08.17

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[] rows = new int[502];
    static int[] cols = new int[502];
    static int[][] dp = new int[502][502];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Get inputs
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());

        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(br.readLine());
            rows[i] = Integer.parseInt(tk.nextToken());
            cols[i] = Integer.parseInt(tk.nextToken());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Print result
        bw.write(Integer.toString(getMinCount(1, N)));

        br.close();
        bw.close();
    }

    private static int getMinCount(int start, int end) {

        if (start == end)
            return 0;

        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }

        for (int i = start; i < end; i++) {
            int cost = getMinCount(start, i) + getMinCount(i + 1, end) + rows[start] * cols[i] * cols[end];
            dp[start][end] = Math.min(dp[start][end], cost);
        }
        return dp[start][end];
    }
}
