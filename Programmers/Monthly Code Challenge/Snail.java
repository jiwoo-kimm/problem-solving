// 프로그래머스 '삼각달팽이'
// 2021.02.20

import java.util.Arrays;

public class Snail {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }

    private static final int DOWN = 0;
    private static final int SIDE = 1;
    private static final int UP = 2;

    public static int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int value = 1, index = 0, direction = DOWN;
        int indexGap = 0, remainingCount = n;
        while (n > 0) {
            remainingCount--;
            if (direction == DOWN) {
                index += indexGap;
                answer[index] = value++;
                indexGap++;
                if (remainingCount == 0) {
                    direction = SIDE;
                    remainingCount = --n;
                }
            } else if (direction == SIDE) {
                answer[++index] = value++;
                if (remainingCount == 0) {
                    direction = UP;
                    remainingCount = --n;
                }
            } else {
                index = index - indexGap;
                answer[index] = value++;
                indexGap--;
                if (remainingCount == 0) {
                    direction = DOWN;
                    remainingCount = --n;
                }
            }
        }
        return answer;
    }
}
