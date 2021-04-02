// 프로그래머스 Greedy
// 단속카메라
// 2021.04.02

import java.util.*;

class Solution {
    
    private static final int ENTER = 0;
    private static final int EXIT = 1;

    public int solution(int[][] cars) {
        Arrays.sort(cars, Comparator.comparingInt(car -> car[EXIT]));
        int camera = Integer.MIN_VALUE, count = 0;
        for (int[] car : cars)
            if (car[ENTER] > camera || car[EXIT] < camera) {
                camera = car[EXIT];
                count++;
            }
        return count;
    }
}