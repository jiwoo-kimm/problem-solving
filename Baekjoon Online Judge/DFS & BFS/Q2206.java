// 백준 2206 '벽 부수고 이동하기'
// DFS & BFS
// 2020.12.31

import java.io.*;
import java.util.*;

public class Q2206 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int mapX;
    private static int mapY;
    private static boolean[][] map;
    private static int[][] visited;
    private static int[] X_MOVES = {1, -1, 0, 0};
    private static int[] Y_MOVES = {0, 0, 1, -1};
    private static Position src;
    private static Position dst;

    private static int count = Integer.MAX_VALUE;

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
        initParams();
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
        map = new boolean[mapY + 1][mapX + 1];
    }

    private static void getMap() throws IOException {
        String line;
        for (int i = 1; i <= mapY; i++) {
            line = br.readLine();
            for (int j = 1; j <= mapX; j++) {
                int tmp = Integer.parseInt(String.valueOf(line.charAt(j - 1)));
                if (tmp == 1) map[i][j] = false;
                else map[i][j] = true;
            }
        }
    }

    private static void initParams() {
        initVisited();
        src = new Position(1, 1, 0, 1);
        dst = new Position(mapX, mapY, 0, 0);
    }

    private static void initVisited() {
        visited = new int[mapY + 1][mapX + 1];
        for (int[] row : visited)
            Arrays.fill(row, Integer.MAX_VALUE);
    }

    private static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(src);
        visited[1][1] = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.equals(dst)) {
                count = current.moveCount;
                return;
            }

            for (int i = 0; i < X_MOVES.length; i++) {
                int nx = current.x + X_MOVES[i];
                int ny = current.y + Y_MOVES[i];

                if (!isInXBound(nx) || !isInYBound(ny)) continue;

                if (visited[ny][nx] <= current.crashCount) continue;

                if (map[ny][nx]) {
                    visited[ny][nx] = current.crashCount;
                    queue.offer(new Position(nx, ny, current.crashCount, current.moveCount + 1));
                } else {
                    if (current.crashCount == 0) {
                        visited[ny][nx] = current.crashCount + 1;
                        queue.offer(new Position(nx, ny, current.crashCount + 1, current.moveCount + 1));
                    }
                }
            }
        }
    }

    private static boolean isInXBound(int num) {
        return num > 0 && num <= mapX;
    }

    private static boolean isInYBound(int num) {
        return num > 0 && num <= mapY;
    }

    private static void printAnswer() throws IOException {
        checkIfRouteAvailable();
        bw.append(count + "\n");
        bw.close();
    }

    private static void checkIfRouteAvailable() {
        if (visited[mapY][mapX] == Integer.MAX_VALUE)
            count = -1;
    }
}

class Position {

    int x;
    int y;
    int crashCount;
    int moveCount;

    public Position(int x, int y, int crashCount, int moveCount) {
        this.x = x;
        this.y = y;
        this.crashCount = crashCount;
        this.moveCount = moveCount;
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