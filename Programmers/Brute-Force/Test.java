// 프로그래머스 '모의고사'
// 2021.08.27

import java.util.*;
import java.util.stream.*;

class Solution {
    
    private static final int[] PATTERN_ONE = {1, 2, 3, 4, 5};
    private static final int[] PATTERN_TWO = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] PATTERN_THREE = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] correctCounts = new int[3];
        correctCounts[0] = countCorrect(answers, PATTERN_ONE);
        correctCounts[1] = countCorrect(answers, PATTERN_TWO);
        correctCounts[2] = countCorrect(answers, PATTERN_THREE);
        
        int max = IntStream.of(correctCounts).max().getAsInt();
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0 ; i<3 ; i++) {
            if (correctCounts[i] == max) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private int countCorrect(int[] answers, int[] pattern) {
        int count = 0;
        for (int i=0 ; i<answers.length ; i++) {
            int marked = pattern[i % pattern.length];
            int answer = answers[i];
            if (marked == answer) {
                count++;
            }
        }
        return count;
    }
}