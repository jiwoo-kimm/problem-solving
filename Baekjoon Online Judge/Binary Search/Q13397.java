// 백준 13397 구간 나누기 2
// 이분탐색
// 2021.04.05

import java.io.*;
import java.util.Arrays;

public class Q13397 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int N;
    private static int M;
    private static int[] arr;

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInputAndInitParams();
        findAnswer();

        bw.append(Integer.toString(answer));
        br.close();
        bw.close();
    }

    private static void parseInputAndInitParams() throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new int[N];
        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(line[i]);
    }

    private static void findAnswer() {
        int left = 0, right = Arrays.stream(arr).max().getAsInt() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isMaxScoreOfBlocksAvailable(mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    private static boolean isMaxScoreOfBlocksAvailable(int maxScore) {
        int blockCount = 0;
        int currentMax = Integer.MIN_VALUE, currentMin = Integer.MAX_VALUE;
        for (int element : arr) {
            int tmpMax = Math.max(currentMax, element);
            int tmpMin = Math.min(currentMin, element);
            if (tmpMax - tmpMin <= maxScore) {
                currentMax = tmpMax;
                currentMin = tmpMin;
            } else {
                blockCount++;
                currentMax = element;
                currentMin = element;
            }
        }
        return blockCount + 1 <= M;
    }
}
