// 백준 10830 '행렬 제곱'
// Divide & Conquer
// 2020.08.08

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long B;
    static int[][] A;
    static int[][] result;

    static final int p = 1000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // inputs
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        B = Long.parseLong(tk.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        // 행렬 B제곱
        long expCount = B;
        while (expCount > 0) {
            if (expCount % 2 == 1) {
                if (result == null)
                    result = A;
                else
                    result = mulMat(result, A);
            }
            A = mulMat(A, A);
            expCount /= 2;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(Integer.toString(result[i][j] % p) + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }

    private static int[][] mulMat(int[][] A, int[][] B) {
        int[][] resultMat = new int[N][N];
        int res;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = 0;
                for (int k = 0; k < N; k++) {
                    res += A[i][k] * B[k][j] % p;
                }
                resultMat[i][j] = res % p;
            }
        }
        return resultMat;
    }
}
