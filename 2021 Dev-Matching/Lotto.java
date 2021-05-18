package devmatching2021;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
        )));
        System.out.println(Arrays.toString(solution(
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{38, 19, 20, 40, 15, 25}
        )));
        System.out.println(Arrays.toString(solution(
                new int[]{45, 4, 35, 20, 3, 9},
                new int[]{20, 9, 3, 45, 4, 35}
        )));
    }

    private static final int UNKNOWN = 0;
    private static final int SIZE = 6;

    public static int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int zeroCount = 0;
        for (int lotto : lottos) {
            if (lotto != UNKNOWN) break;
            zeroCount++;
        }

        int lowerBound = 0;
        int lottosIndex = zeroCount, winNumsIndex = 0;
        while (lottosIndex < SIZE && winNumsIndex < SIZE) {
            if (lottos[lottosIndex] == win_nums[winNumsIndex]) {
                lowerBound++;
                lottosIndex++;
                winNumsIndex++;
            } else if (lottos[lottosIndex] > win_nums[winNumsIndex]) {
                winNumsIndex++;
            } else {
                lottosIndex++;
            }
        }

        return parseAnswer(lowerBound, lowerBound + zeroCount);
    }

    private static int[] parseAnswer(int lowerBound, int upperBound) {
        int[] result = new int[2];
        result[0] = Math.min(6, 7 - upperBound);
        result[1] = Math.min(6, 7 - lowerBound);
        return result;
    }
}