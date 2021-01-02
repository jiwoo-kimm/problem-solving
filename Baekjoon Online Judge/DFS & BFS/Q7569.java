// 백준 7569 '토마토'
// DFS & BFS
// 2020.12.31

import java.io.*;
import java.util.*;

public class Q7569 {

    private static final int[] X = {-1, 1, 0, 0, 0, 0};
    private static final int[] Y = {0, 0, -1, 1, 0, 0};
    private static final int[] Z = {0, 0, 0, 0, -1, 1};
    private static final int EMPTY = -1;
    private static final int RIPEN = 1;
    private static final int RAW = 0;

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int mapX;
    private static int mapY;
    private static int mapZ;
    private static int[][][] map;
    private static boolean[][][] visited;
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
        mapZ = Integer.parseInt(tk.nextToken());
    }

    private static void createMap() {
        map = new int[mapZ][mapY][mapX];
    }

    private static void getMap() throws IOException {
        String line;
        StringTokenizer tk;
        for (int i = 0; i < mapZ; i++) {
            for (int j = 0; j < mapY; j++) {
                line = br.readLine();
                tk = new StringTokenizer(line);
                for (int k = 0; k < mapX; k++) {
                    map[i][j][k] = Integer.parseInt(tk.nextToken());
                }
            }
        }
    }

    private static void initVisited() {
        visited = new boolean[mapZ][mapY][mapX];
        for (boolean[][] rows : visited)
            for (boolean[] row : rows)
                Arrays.fill(row, false);

        for (int i = 0; i < mapZ; i++)
            for (int j = 0; j < mapY; j++)
                for (int k = 0; k < mapX; k++) {
                    if (map[i][j][k] == EMPTY) visited[i][j][k] = true;
                    if (map[i][j][k] == RIPEN) {
                        initialRipen.add(new Tomato(i, j, k));
                        visited[i][j][k] = true;
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
                for (int k = 0; k < X.length; k++) {
                    int nx = current.x + X[k];
                    int ny = current.y + Y[k];
                    int nz = current.z + Z[k];

                    if (isInXBound(nx) && isInYBound(ny) && isInZBound(nz) && map[nz][ny][nx] == RAW && !visited[nz][ny][nx]) {
                        queue.offer(new Tomato(nz, ny, nx));
                        visited[nz][ny][nx] = true;
                    }
                }
            count++;
        }
    }

    private static boolean isAllRipen() {
        for (int i = 0; i < mapZ; i++)
            for (int j = 0; j < mapY; j++)
                for (int k = 0; k < mapX; k++)
                    if (!visited[i][j][k]) return false;
        return true;
    }

    private static boolean isInZBound(int num) {
        return num >= 0 && num < mapZ;
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
    int z;

    public Tomato(int z, int y, int x) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tomato)) return false;
        Tomato tomato = (Tomato) o;
        return x == tomato.x && y == tomato.y && z == tomato.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}