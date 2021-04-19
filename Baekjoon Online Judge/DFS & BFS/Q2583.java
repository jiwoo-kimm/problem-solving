// 백준 2583번 영역 구하기
// DFS
// 2021.04.19

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static int m;
    private static int n;
    private static int k;
    private static boolean[][] visited;
    private static List<Integer> areas = new ArrayList<>();
    private static int areaSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        countArea();
        writeAnswer(bw);

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        m = Integer.parseInt(line[0]);
        n = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);

        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            line = br.readLine().split(" ");
            markRectangle(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        }
    }

    private static void markRectangle(int x1, int y1, int x2, int y2) {
        for (int y = y1; y < y2; y++)
            for (int x = x1; x < x2; x++)
                visited[y][x] = true;
    }

    private static void countArea() {
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!visited[i][j]) {
                    areaSize = 0;
                    dfs(i, j);
                    areas.add(areaSize);
                }
    }

    private static void dfs(int y, int x) {
        if (visited[y][x]) return;

        visited[y][x] = true;
        areaSize++;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isInBound(ny, nx)) dfs(ny, nx);
        }
    }

    private static boolean isInBound(int ny, int nx) {
        return ny >= 0 && ny < m && nx >= 0 && nx < n;
    }

    private static void writeAnswer(BufferedWriter bw) throws IOException {
        areas.sort(Integer::compare);
        bw.append(String.valueOf(areas.size())).append("\n");
        for (int size : areas) bw.append(String.valueOf(size)).append(" ");
    }
}