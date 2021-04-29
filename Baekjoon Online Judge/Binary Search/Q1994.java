package bs;

import java.io.*;
import java.util.Arrays;

public class Q1994 {

    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 2000;
    private static final int MAX_VALUE = 1000000000;
    private static final int INVALID = -1;

    private static int n;
    private static int[] arr = new int[MAX_SIZE];
    private static int[][] dp = new int[MAX_SIZE][MAX_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        int maxLength = findLongestApLength();
        bw.append(String.valueOf(maxLength));

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
    }

    private static int findLongestApLength() {
        if (n == MIN_SIZE) return MIN_SIZE;

        Arrays.fill(dp[1], 2);
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int gap = arr[j] - arr[i];
                if (gap == 0) {

                } else {
                    int next = findIndexNext(j, gap);
                    if (next == INVALID) dp[i][j] = 2;
                    else dp[i][j] = dp[j][next] + 1;
                }
            }
        }
    }

    private static int findIndexNext(int index, int gap) {
        int left = index + 1, right = n, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] == arr[index] + gap) left = mid + 1;
            else right = mid - 1;
        }
        int result = (left + right) / 2;
        if (arr[result] != arr[index] + gap) result = INVALID;
        return result;
    }
}
