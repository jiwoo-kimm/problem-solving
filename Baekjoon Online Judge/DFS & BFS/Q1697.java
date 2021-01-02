// 백준 1697 '숨바꼭질'
// DFS & BFS
// 2020.12.31

import java.io.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1697 {

    private static final int MAP_SIZE = 100001;

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int src;
    private static int dst;
    private static int[] map = new int[MAP_SIZE];
    private static boolean[] visited = new boolean[MAP_SIZE];
    private static int[] moves = {1, -1, 0};

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
        getConstants();
        bfs();
    }

    private static void getConstants() throws IOException {
        String line = br.readLine();
        StringTokenizer tk = new StringTokenizer(line);
        src = Integer.parseInt(tk.nextToken());
        dst = Integer.parseInt(tk.nextToken());
    }

    private static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(src, 0));

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (current.position == dst) {
                count = current.count;
                return;
            }

            moves[2] = current.position;
            for (int move : moves) {
                int np = current.position + move;

                if (isInBound(np) && !visited[np]) {
                    queue.offer(new Position(np, current.count + 1));
                    visited[np] = true;
                }
            }
        }
    }

    private static boolean isInBound(int num) {
        return num >= 0 && num <= 100000;
    }

    private static void printAnswer() throws IOException {
        bw.append(count + "\n");
        bw.close();
    }
}

class Position {

    int position;
    int count;

    public Position(int position, int count) {
        this.position = position;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}