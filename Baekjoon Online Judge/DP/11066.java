// 백준 11066 '파일 합치기'
// DP
// 2020.08.15

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int K;

    static int[] file = new int[502];
    static int[] sum = new int[502];
    static int[][] dp = new int[502][502];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        T = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < T; i++) {
            tk = new StringTokenizer(br.readLine());
            K = Integer.parseInt(tk.nextToken());

            tk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= K; j++) {
                file[j] = Integer.parseInt(tk.nextToken());
                sum[j] = sum[j - 1] + file[j];
            }

            // Get result
            dp();

            // Print output
            bw.write(Integer.toString(dp[1][K]) + "\n");

        }

        br.close();
        bw.close();
    }

    private static void dp() {
        // j부터 i까지 합치는 최소 비용
        for (int i = 2; i <= K; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k <= i; k++) {
                    dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k + 1][i]); // k를 거치는 모든 부분구간의 최소비용 확인
                }
                dp[j][i] += sum[i] - sum[j - 1];    // j부터 i까지의 비용
            }
        }
    }
}
