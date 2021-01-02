// 백준 1300 'K번째 수'
// Binary Search
// 2020.08.13

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        K = Integer.parseInt(tk.nextToken());

        binarySearch(1, K);

        bw.write(Integer.toString(answer));

        br.close();
        bw.close();
    }

    private static void binarySearch(int start, int end) {
        if (start > end)
            return;

        int mid = (start + end) / 2;
        long indexOnB = getIndexOnB(mid);

        if (indexOnB < K)
            binarySearch(mid + 1, end);
        else {
            answer = mid;
            binarySearch(start, mid - 1);
        }
    }

    private static long getIndexOnB(int mid) {
        long index = 0;
        for (int i = 1; i <= N; i++) {
            index += Math.min(mid / i, N);
        }
        return index;
    }
}
