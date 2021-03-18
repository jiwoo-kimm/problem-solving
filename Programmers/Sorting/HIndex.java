// 프로그래머스 정렬
// H-Index
// 2021.03.18

import java.util.*;

class Solution {
    
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int citation : citations)
            answer = Math.max(Math.min(countLessThan(citation, citations), citation), answer);
        return answer;
    }

    private int countLessThan(int target, int[] citations) {
        int count = 0;
        for (int citation : citations)
            if (citation >= target) count++;
        return count;
    }
}