import java.io.*;
import java.util.Arrays;

public class Main {

    private static final int MAX_SIZE = 2000;
    private static final int INVALID = -1;
    private static final int INIT = 0;

    private static int n;
    private static int[] arr = new int[MAX_SIZE + 1];
    private static int[][] dp = new int[MAX_SIZE + 1][MAX_SIZE + 1];

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
        for (int i = 0; i < n; i++) arr[i + 1] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, 1, n + 1);
    }

    private static int findLongestApLength() {
        int max = 1;
        for (int i = 1; i <= n; i++)
            for (int j = i + 1; j <= n; j++)
                max = Math.max(max, dp(i, j));
        return max;
    }

    private static int dp(int i, int j) {
        int result = dp[i][j];
        if (result != INIT) return result;

        int index = findIndex(arr[j] + arr[j] - arr[i], j + 1);

        if (index == INVALID) return dp[i][j] = 2;
        else return dp[i][j] = dp(j, index) + 1;
    }

    private static int findIndex(int target, int start) {
        int left = start, right = n, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) return mid;

            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return INVALID;
    }
}
