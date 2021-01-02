// 백준 1012 '유기농 배추'
// DFS & BFS
// 2020.12.30

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1012 {

    private static final int[] X = {-1, 1, 0, 0};
    private static final int[] Y = {0, 0, -1, 1};

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int mapX;
    private static int mapY;
    private static int cabbageCount;
    private static boolean[][] map;
    private static boolean[][] visited;

    private static int wormCount;
    private static ArrayList<Integer> wormCounts = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) run();

        printAnswer();
        br.close();
        bw.close();
    }

    private static void run() throws IOException {
        initMap();
        initVisited();
        countWorms();
        saveWormCount();
    }

    private static void initMap() throws IOException {
        getConstants();
        createMap();
        getMap();
    }

    private static void getConstants() throws IOException {
        String line = br.readLine();
        StringTokenizer tk = new StringTokenizer(line);
        mapX = Integer.parseInt(tk.nextToken());
        mapY = Integer.parseInt(tk.nextToken());
        cabbageCount = Integer.parseInt(tk.nextToken());
    }

    private static void createMap() {
        map = new boolean[mapY][mapX];
        for (boolean[] row : map)
            Arrays.fill(row, false);
    }

    private static void getMap() throws IOException {
        String line;
        StringTokenizer tk;
        int cabbageX, cabbageY;
        for (int i = 0; i < cabbageCount; i++) {
            line = br.readLine();
            tk = new StringTokenizer(line);
            cabbageX = Integer.parseInt(tk.nextToken());
            cabbageY = Integer.parseInt(tk.nextToken());
            map[cabbageY][cabbageX] = true;
        }
    }

    private static void initVisited() {
        visited = new boolean[mapY][mapX];
        for (boolean[] row : visited)
            Arrays.fill(row, false);
    }

    private static void countWorms() {
        for (int i = 0; i < mapY; i++)
            for (int j = 0; j < mapX; j++)
                if (map[i][j] && !visited[i][j]) {
                    dfs(i, j);
                    wormCount++;
                }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        if (!map[i][j])
            return;

        for (int k = 0; k < 4; k++) {
            int ni = i + Y[k];
            int nj = j + X[k];

            if (isInYBound(ni) && isInXBound(nj) && !visited[ni][nj])
                dfs(ni, nj);
        }
    }

    private static boolean isInYBound(int num) {
        return num >= 0 && num < mapY;
    }

    private static boolean isInXBound(int num) {
        return num >= 0 && num < mapX;
    }

    private static void saveWormCount() {
        wormCounts.add(wormCount);
        wormCount = 0;
    }

    private static void printAnswer() throws IOException {
        for (int wormCount : wormCounts)
            bw.append(wormCount + "\n");
        bw.close();
    }
}