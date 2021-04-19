// 백준 1028번 다이아몬드 광산
// DP
// 2021.04.19

import java.io.*;

public class Main {

    private static final int MAXIMUM = 750;

    private static final int DIRECTIONS = 4;
    private static final int LEFT_DOWN = 0;
    private static final int RIGHT_DOWN = 1;
    private static final int LEFT_UP = 2;
    private static final int RIGHT_UP = 3;

    private static int r;
    private static int c;
    private static int maxSize;
    private static int[][] mine = new int[MAXIMUM][MAXIMUM];
    private static int[][][] dp = new int[MAXIMUM][MAXIMUM][DIRECTIONS];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        dp();
        bw.append(String.valueOf(maxSize));

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        r = Integer.parseInt(line[0]);
        c = Integer.parseInt(line[1]);

        for (int i = 0; i < r; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < c; j++)
                mine[i][j] = Integer.parseInt(line[j]);
        }
    }

    private static void dp() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mine[i][j] == 1) {
                    maxSize = Math.max(maxSize, 1);
                    for (int direction = LEFT_DOWN; direction < DIRECTIONS; direction++)
                        dp[i][j][direction] = countMaxLengthOnDirection(i, j, direction);
                    
                    if (dp[i][j][LEFT_UP] > maxSize && dp[i][j][RIGHT_UP] > maxSize) {
                        int length = Math.min(dp[i][j][LEFT_UP], dp[i][j][RIGHT_UP]);
                        if (dp[i - length + 1][j - length + 1][RIGHT_UP] >= length
                                && dp[i - length + 1][j + length - 1][LEFT_UP] >= length)
                            maxSize = length;
                    }
                }
            }
        }
    }

    private static int countMaxLengthOnDirection(int i, int j, int direction) {
        int count = 0;
        int dy = 0, dx = 0;
        int ny, nx;
        while (true) {
            ny = i + dy;
            nx = j + dx;
            if (!isInBound(ny, nx) || mine[ny][nx] == 0) break;
            count++;

            if (direction == LEFT_DOWN) {
                dy++;
                dx--;
            } else if (direction == RIGHT_DOWN) {
                dy++;
                dx++;
            } else if (direction == LEFT_UP) {
                dy--;
                dx--;
            } else if (direction == RIGHT_UP) {
                dy--;
                dx++;
            }
        }
        return count;
    }

    private static boolean isInBound(int i, int j) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }
}