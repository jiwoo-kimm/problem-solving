// 백준 1654 '랜선 자르기'
// Binary Search
// 2020.08.10

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static int N;
    static int[] lengthOfLANs;
    static long maxLANLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input (K, N, array)
        StringTokenizer tk = new StringTokenizer(br.readLine());
        K = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());
        lengthOfLANs = new int[K];
        for (int i = 0; i < K; i++) {
            tk = new StringTokenizer(br.readLine());
            lengthOfLANs[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(lengthOfLANs);
        getMaxLength(1, lengthOfLANs[K - 1]);

        bw.write(Long.toString(maxLANLength));

        br.close();
        bw.close();
    }

    private static void getMaxLength(long min, long max) {
        if (min > max)
            return;

        long mid = (min + max) / 2;  // 오답의 주범1... max가 integer max값일 때 더하면 overflow 발생
        long LANCountOnMid = getLANCountOnLength(mid);  // 오답의 주범2... 모든 랜선을 1cm 단위로 자른다 했을 때 개수가 int 범위를 넘어감

        if (LANCountOnMid >= N) {
            maxLANLength = mid;
            getMaxLength(mid + 1, max);
        } else {
            getMaxLength(min, mid - 1);
        }
    }

    private static long getLANCountOnLength(long length) {
        long LANCount = 0;
        for (int i = 0; i < K; i++) {
            LANCount += lengthOfLANs[i] / length;
        }
        return LANCount;
    }
}
