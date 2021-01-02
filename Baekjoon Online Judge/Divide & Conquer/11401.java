// 백준 11401 '이항 계수 3'
// Divide & Conquer
// 2020.08.07

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static long K;
    static final long p = 1000000007;

    // A = N!
    // B = K!(N-K)!
    // ((A % p) * (B^(p-2) % p)) % p
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Get inputs
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Long.parseLong(tk.nextToken());
        K = Long.parseLong(tk.nextToken());

        // Calculate factorial(for denominator & numerator) with mod
        long[] factorial = new long[(int) N + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            factorial[i] = factorial[i - 1] * i % p;
        }
        long numerator = factorial[(int) N];
        long denominator = factorial[(int) K] * factorial[(int) (N - K)] % p;

        // Calculate Fermat number
        long fermatNum = 1;
        int expCount = (int) (p - 2);
        while (expCount > 0) {
            if (expCount % 2 == 1) {
                fermatNum = fermatNum * denominator % p;
            }
            denominator = denominator * denominator % p;
            expCount /= 2;
        }

        // Calculate result
        long result = (numerator % p) * (fermatNum % p) % p;
        bw.write(Long.toString(result));

        br.close();
        bw.close();
    }
}
