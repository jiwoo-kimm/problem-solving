// 백준 1920 '수 찾기'
// Binary Search
// 2020.08.10

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] numArr;

    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input (N & array)
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        numArr = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(numArr);

        // input (M)
        tk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(tk.nextToken());

        // find target from numArr
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(tk.nextToken());
            bw.write(Integer.toString(findTargetFromArray(0, N, target)) + "\n");
        }

        br.close();
        bw.close();
    }

    public static int findTargetFromArray(int start, int end, int target) {
        int mid = (start + end) / 2;

        if (mid >= end)
            return 0;

        if (numArr[mid] == target) {
            return 1;
        } else if (numArr[mid] < target) {
            return findTargetFromArray(mid + 1, end, target);
        } else {
            return findTargetFromArray(start, mid, target);
        }
    }

}
