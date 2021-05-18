// 2021 Dev-Matching 웹 백엔드 개발자(상반기)
// 로또의 최고 순위와 최저 순위
// 2021.05.18

import java.util.Arrays;

class Solution {
    
    private static final int UNKNOWN = 0;
    private static final int SIZE = 6;

    public int[] solution(int[] lottos, int[] win_nums) {
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

    private int[] parseAnswer(int lowerBound, int upperBound) {
        int[] result = new int[2];
        result[0] = Math.min(6, 7 - upperBound);
        result[1] = Math.min(6, 7 - lowerBound);
        return result;
    }
}