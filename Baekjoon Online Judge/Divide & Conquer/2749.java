// 백준 2749 '피보나치 수 3'
// Divide & Conquer
// 2020.08.08

/*
    피사노 주기 성질
    1. 주기의 길이가 P이면, N번째 피보나치 수를 M으로 나눈 값은
    (N % P)번째 피보나치 수를 M으로 나눈 값과 같다.
    2. M = 10^k 일 때, k > 2라면, P는 항상 15 * 10^(k-1)이다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long n;
    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Long.parseLong(tk.nextToken());

        // pisano period
        int pisanoPeriod = getPisanoPeriod(MOD);

        // fibonacci
        bw.write(Integer.toString(calcFibo((int) (n % pisanoPeriod)) % MOD));

        br.close();
        bw.close();
    }

    private static int calcFibo(int index) {

        int fibArr[] = new int[index + 1];
        fibArr[0] = 0;
        fibArr[1] = 1;

        for (int i = 2; i <= index; i++) {
            fibArr[i] = (fibArr[i - 2] + fibArr[i - 1]) % MOD;
        }
        return fibArr[index];
    }

    private static int getPisanoPeriod(int mod) {

        return mod / 10 * 15;
    }
}
