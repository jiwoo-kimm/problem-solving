import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 1780 '종이의 개수'
// Divide & Conquer
// 2020.08.06

public class Main {

    static int N;
    static int[][] origin;
    static int negativeCount;
    static int zeroCount;
    static int positiveCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        checkSquare(N, 0, 0);

        bw.write(Integer.toString(negativeCount) + "\n" + Integer.toString(zeroCount) + "\n" + Integer.toString(positiveCount));

        br.close();
        bw.close();
    }

    private static void checkSquare(int size, int startX, int startY) {

        // 종료조건 1 : 정사각형 한 칸
        if (size == 1) {
            addCount(origin[startX][startY]);
            return;
        } else {
            // 종료조건 2 : 모두 같은 색
            if (isSameNumber(size, startX, startY)) {
                addCount(origin[startX][startY]);
                return;
                // 이외의 경우 분할 & recursion
            } else {
                int newSize = size / 3;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        checkSquare(newSize, startX + newSize * i, startY + newSize * j);
                    }
                }
            }
        }
    }

    private static void addCount(int num) {
        if (num == -1)
            negativeCount++;
        else if (num == 0)
            zeroCount++;
        else
            positiveCount++;
        return;
    }

    private static boolean isSameNumber(int size, int startX, int startY) {

        boolean result = true;
        int startVal = origin[startX][startY];
        for (int i = startX; i < startX + size && result; i++) {
            for (int j = startY; j < startY + size && result; j++) {
                if (origin[i][j] != startVal) {
                    result = false;
                }
            }
        }
        return result;
    }
}
