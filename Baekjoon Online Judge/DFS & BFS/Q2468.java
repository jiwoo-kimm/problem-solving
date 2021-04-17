// 백준 2468번 안전 영역
// DFS
// 2021.04.17

import java.io.*;
import java.util.Arrays;

public class Main {

    private static final int MAX_SIZE = 100;
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_LIMIT = 0;
    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static int n;
    private static int[][] heights = new int[MAX_SIZE][MAX_SIZE];
    private static boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];

    private static int maxHeight = MIN_HEIGHT;
    private static int currentSafeAreaCount;
    private static int maxSafeAreaCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                heights[i][j] = Integer.parseInt(line[j]);
                maxHeight = Math.max(heights[i][j], maxHeight);
            }
        }
        countMaxSafeArea();
        bw.append(String.valueOf(maxSafeAreaCount));

        br.close();
        bw.close();
    }

    private static void countMaxSafeArea() {
        for (int i = maxHeight; i >= MIN_LIMIT; i--) {
            visited = new boolean[MAX_SIZE][MAX_SIZE];
            for (boolean[] row : visited) Arrays.fill(row, false);
            currentSafeAreaCount = 0;
            countSafeAreaOnLimit(i);
            maxSafeAreaCount = Math.max(maxSafeAreaCount, currentSafeAreaCount);
        }
    }

    private static void countSafeAreaOnLimit(int limit) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && heights[i][j] > limit) {
                    dfs(limit, i, j);
                    currentSafeAreaCount++;
                }
                visited[i][j] = true;
            }
        }
    }

    private static void dfs(int limit, int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i], nx = x + dx[i];
            if (isInBound(ny, nx) && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if (heights[ny][nx] > limit)
                    dfs(limit, ny, nx);
            }
        }
    }

    private static boolean isInBound(int ny, int nx) {
        return ny >= 0 && ny < n && nx >= 0 && nx < n;
    }
}