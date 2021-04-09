// 백준 11559번 뿌요뿌요
// DFS
// 2021.04.09

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Q11559 {

    private static final int POP = 4;
    private static final int WIDTH = 6;
    private static final int HEIGHT = 12;
    private static final char BLANK = '.';
    private static final int NO_MORE_CHAR = -1;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static char[][] board = new char[HEIGHT][WIDTH];
    private static boolean[][] pop = new boolean[HEIGHT][WIDTH];
    private static boolean isPopAvailable;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initBoard();
        int answer = countPopChain();

        bw.append(Integer.toString(answer));
        br.close();
        bw.close();
    }

    private static void initBoard() throws IOException {
        for (int i = HEIGHT - 1; i >= 0; i--) {
            String line = br.readLine();
            for (int j = 0; j < WIDTH; j++)
                board[i][j] = line.charAt(j);
        }
    }

    private static int countPopChain() {
        int result = 0;
        while (isPopAvailable()) {
            popAndRealignBoard();
            result++;
            pop = new boolean[HEIGHT][WIDTH];
        }
        return result;
    }

    private static boolean isPopAvailable() {
        isPopAvailable = false;
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++) {
                List<Index> indexes = new ArrayList<>();
                indexes.add(new Index(i, j));
                if (board[i][j] != BLANK && !pop[i][j])
                    checkBlocksToPop(i, j, indexes);
            }
        return isPopAvailable;
    }

    private static void checkBlocksToPop(int y, int x, List<Index> indexes) {
        if (indexes.size() >= POP) {
            for (Index index : indexes) pop[index.y][index.x] = true;
            isPopAvailable = true;
        }

        char targetChar = board[y][x];
        for (int i = 0; i < dy.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isInBound(ny, nx) && board[ny][nx] == targetChar && !indexes.contains(new Index(ny, nx))) {
                indexes.add(new Index(ny, nx));
                checkBlocksToPop(ny, nx, indexes);
            }
        }
    }

    private static boolean isInBound(int ny, int nx) {
        return isYInBound(ny) && isXInBound(nx);
    }

    private static boolean isYInBound(int ny) {
        return ny >= 0 && ny < HEIGHT;
    }

    private static boolean isXInBound(int nx) {
        return nx >= 0 && nx < WIDTH;
    }

    private static void popAndRealignBoard() {
        pop();
        realignBoard();
    }

    private static void pop() {
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++)
                if (pop[i][j]) board[i][j] = BLANK;
    }

    private static void realignBoard() {
        for (int i = 0; i < HEIGHT; i++)
            for (int j = 0; j < WIDTH; j++)
                if (board[i][j] == BLANK) {
                    int newCharIndex = getNewCharIndex(i, j);
                    if (newCharIndex != NO_MORE_CHAR) dropDownNewChar(i, newCharIndex, j);
                }
    }

    private static void dropDownNewChar(int i, int newCharIndex, int j) {
        board[i][j] = board[newCharIndex][j];
        board[newCharIndex][j] = BLANK;
    }

    private static int getNewCharIndex(int y, int x) {
        for (int i = y + 1; i < HEIGHT; i++)
            if (board[i][x] != BLANK) return i;
        return NO_MORE_CHAR;
    }
}

class Index {
    int y;
    int x;

    public Index(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Index)) return false;
        Index index = (Index) o;
        return y == index.y && x == index.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}