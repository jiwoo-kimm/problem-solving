// 백준 2667 '단지번호붙이기'
// DFS & BFS
// 2020.12.29

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q2667 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int mapSize;
    private static boolean[][] map;
    private static boolean[][] visited;
    private static ArrayList<Integer> towns = new ArrayList<>();
    private static int houseCount;

    private static final int[] X = {-1, 1, 0, 0};
    private static final int[] Y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initMap();
        initVisited();
        countTowns();
        printAnswer();

        br.close();
        bw.close();
    }

    private static void countTowns() {
        for (int i = 1; i <= mapSize; i++)
            for (int j = 1; j <= mapSize; j++)
                if (map[i][j] && !visited[i][j]) {
                    dfs(i, j);
                    towns.add(houseCount);
                    houseCount = 0;
                }
    }

    private static void initMap() throws IOException {
        getMapSize();
        getMap();
    }

    private static void getMapSize() throws IOException {
        mapSize = Integer.parseInt(br.readLine());
    }

    private static void getMap() throws IOException {
        map = new boolean[mapSize + 1][mapSize + 1];
        String line;
        for (int i = 1; i <= mapSize; i++) {
            line = br.readLine();
            for (int j = 1; j <= mapSize; j++) {
                int tmp = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
                if (tmp == 1) map[i][j] = true;
                else map[i][j] = false;
            }
        }
    }

    private static void initVisited() {
        visited = new boolean[mapSize + 1][mapSize + 1];
        for (boolean[] arr : visited)
            Arrays.fill(arr, false);
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        if (!map[i][j])
            return;

        houseCount++;
        for (int k = 0; k < 4; k++) {
            int ni = i + Y[k];
            int nj = j + X[k];

            if (isInBound(ni) && isInBound(nj) && !visited[ni][nj])
                dfs(ni, nj);
        }
    }

    private static boolean isInBound(int num) {
        return num > 0 && num <= mapSize;
    }

    private static void printAnswer() throws IOException {
        Collections.sort(towns);
        bw.append(towns.size() + "\n");
        for (int houseCount : towns)
            bw.append(houseCount + "\n");
        bw.close();
    }
}