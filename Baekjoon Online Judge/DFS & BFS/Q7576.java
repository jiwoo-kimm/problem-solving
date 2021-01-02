// 백준 7576 '토마토'
// DFS & BFS
// 2020.12.30

import java.io.*;
import java.util.*;

public class Q7576 {

    private static final int[] X = {-1, 1, 0, 0};
    private static final int[] Y = {0, 0, -1, 1};
    private static final int EMPTY = -1;
    private static final int RIPEN = 1;
    private static final int RAW = 0;

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int mapX;
    private static int mapY;
    private static int[][] map;
    private static boolean[][] visited;
    private static ArrayList<Tomato> initialRipen = new ArrayList<>();

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
        mapX = Integer.parseInt(tk.nextToken());
        mapY = Integer.parseInt(tk.nextToken());
    }

    private static void createMap() {
        map = new int[mapY][mapX];
    }

    private static void getMap() throws IOException {
        String line;
        StringTokenizer tk;
        for (int i = 0; i < mapY; i++) {
            line = br.readLine();
            tk = new StringTokenizer(line);
            for (int j = 0; j < mapX; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
    }

    private static void initVisited() {
        visited = new boolean[mapY][mapX];
        for (boolean[] row : visited)
            Arrays.fill(row, false);

        for (int i = 0; i < mapY; i++)
            for (int j = 0; j < mapX; j++) {
                if (map[i][j] == EMPTY) visited[i][j] = true;
                if (map[i][j] == RIPEN) {
                    initialRipen.add(new Tomato(i, j));
                    visited[i][j] = true;
                }
            }
    }

    private static void bfs() {
        Queue<Tomato> queue = new LinkedList<>();
        queue.addAll(initialRipen);

        while (!queue.isEmpty()) {
            if (isAllRipen())
                return;

            ArrayList<Tomato> currents = new ArrayList<>();
            while (!queue.isEmpty())
                currents.add(queue.poll());

            for (Tomato current : currents)
                for (int k = 0; k < 4; k++) {
                    int ni = current.y + Y[k];
                    int nj = current.x + X[k];

                    if (isInXBound(nj) && isInYBound(ni) && map[ni][nj] == RAW && !visited[ni][nj]) {
                        queue.offer(new Tomato(ni, nj));
                        visited[ni][nj] = true;
                    }
                }

            count++;
        }
    }

    private static boolean isAllRipen() {
        for (int i = 0; i < mapY; i++)
            for (int j = 0; j < mapX; j++)
                if (!visited[i][j]) return false;
        return true;
    }

    private static boolean isInYBound(int num) {
        return num >= 0 && num < mapY;
    }

    private static boolean isInXBound(int num) {
        return num >= 0 && num < mapX;
    }

    private static void printAnswer() throws IOException {
        checkIfAllRipen();
        bw.append(count + "\n");
        bw.close();
    }

    private static void checkIfAllRipen() {
        if (!isAllRipen())
            count = -1;
    }
}

class Tomato {

    int x;
    int y;

    public Tomato(int y, int x) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tomato)) return false;
        Tomato position = (Tomato) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}