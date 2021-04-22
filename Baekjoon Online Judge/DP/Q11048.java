// 백준 11048번 이동하기
// DP
// 2021.04.22

import java.io.*;

public class Main {

    private static int n;
    private static int m;
    private static int[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        dp();
        bw.append(String.valueOf(maze[n][m]));

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        maze = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            line = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) maze[i][j] = Integer.parseInt(line[j - 1]);
        }
    }

    private static void dp() {
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                maze[i][j] += Math.max(Math.max(maze[i - 1][j], maze[i][j - 1]), maze[i - 1][j - 1]);
    }
}