// 백준 2805 '나무 자르기'
// Binary Search
// 2020.08.11

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;           // 나무의 수
    static int M;           // 가져가려고 하는 나무의 길이
    static int[] heights;   // 나무의 높이
    static long maxCutHeight;  // 절단기 설정 높이 최댓값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input (N, M, array)
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        heights = new int[N];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(heights);
        getMaxHeight(0, heights[N - 1]);

        bw.write(Long.toString(maxCutHeight));

        br.close();
        bw.close();
    }

    private static void getMaxHeight(long min, long max) {
        if (min > max)
            return;

        long mid = (min + max) / 2;
        long availableSumOnMid = getAvailableSum(mid);

        if (availableSumOnMid >= M) {
            maxCutHeight = mid;
            getMaxHeight(mid + 1, max);
        } else {
            getMaxHeight(min, mid - 1);
        }
    }

    private static long getAvailableSum(long cutHeight) {
        long sum = 0;
        long availableHeight;
        for (int i = 0; i < N; i++) {
            availableHeight = heights[i] - cutHeight;
            if (availableHeight > 0)
                sum += availableHeight;
        }
        return sum;
    }
}
