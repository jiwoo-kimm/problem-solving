// 백준 2178 '미로 탐색'
// DFS & BFS
// 2020.12.30

import java.io.*;
import java.util.*;

public class Q2178 {

    private static final int[] X = {-1, 1, 0, 0};
    private static final int[] Y = {0, 0, -1, 1};

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int mapX;
    private static int mapY;
    private static boolean[][] map;
    private static boolean[][] visited;

    private static int count;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        run();
        printAnswer();

        br.close();
        bw.close();
    }

    private static void run() throws IOException {
        initMap();
        initVisited();
        bfs();
    }

    private static void initMap() throws IOException {
        getConstants();
        createMap();
        getMap();
    }

    private static void getConstants() throws IOException {
        String line = br.readLine();
        StringTokenizer tk = new StringTokenizer(line);
        mapY = Integer.parseInt(tk.nextToken());
        mapX = Integer.parseInt(tk.nextToken());
    }

    private static void createMap() {
        map = new boolean[mapY][mapX];
        for (boolean[] row : map)
            Arrays.fill(row, false);
    }

    private static void getMap() throws IOException {
        String line;
        int tmp;
        for (int i = 0; i < mapY; i++) {
            line = br.readLine();
            for (int j = 0; j < mapX; j++) {
                tmp = Integer.parseInt(String.valueOf(line.charAt(j)));
                map[i][j] = (tmp == 1);
            }
        }
    }

    private static void initVisited() {
        visited = new boolean[mapY][mapX];
        for (boolean[] row : visited)
            Arrays.fill(row, false);
    }

    private static void bfs() {
        Position end = new Position(mapY - 1, mapX - 1);

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.equals(end)) {
                count = current.count;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int ni = current.y + Y[k];
                int nj = current.x + X[k];

                if (isInXBound(nj) && isInYBound(ni) && map[ni][nj] && !visited[ni][nj]) {
                    queue.offer(new Position(ni, nj, current.count + 1));
                    visited[ni][nj] = true;
                }
            }
        }
    }

    private static boolean isInYBound(int num) {
        return num >= 0 && num < mapY;
    }

    private static boolean isInXBound(int num) {
        return num >= 0 && num < mapX;
    }

    private static void printAnswer() throws IOException {
        bw.append(count + "\n");
        bw.close();
    }
}

class Position {
    int x;
    int y;
    int count;

    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public Position(int y, int x, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}