// 백준 10816 '숫자 카드 2'
// Binary Search -> Memoization
// 2020.08.10

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] numArr;
    static int[] numCountArr = new int[10000000 * 2 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input (N & array) & update count
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        numArr = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(tk.nextToken());
            numCountArr[getIndexOnCountArr(numArr[i])]++;
        }

        // input (M)
        tk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tk.nextToken());

        // get target count from numArr
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(tk.nextToken());
            bw.write(Integer.toString(numCountArr[getIndexOnCountArr(target)]) + " ");
        }

        br.close();
        bw.close();
    }

    private static int getIndexOnCountArr(int indexOnNumArr) {
        return indexOnNumArr + 10000000;
    }
}
