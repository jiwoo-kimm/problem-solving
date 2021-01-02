// 백준 2740 '행렬 곱셈'
// Divide & Conquer
// 2020.08.07

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[][] A;

    static int K;
    static int[][] B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 행렬 A input
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        // 행렬 B input
        tk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());
        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        // 행렬곱셈
        int res;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                res = 0;
                for (int k = 0; k < M; k++) {
                    res += A[i][k] * B[k][j];
                }
                bw.write(Integer.toString(res)+ " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
