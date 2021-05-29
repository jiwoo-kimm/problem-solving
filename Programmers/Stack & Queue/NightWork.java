// 프로그래머스 연습문제
// 야근 지수
// 2021.05.29

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) pq.offer(work);
        
        while (n > 0) {
            int max = pq.poll();
            if (max == 0) return 0;
            pq.offer(max-1);
            n--;
        }
        
        long answer = 0;
        for (int work : pq) answer += Math.pow(work, 2);
        return answer;
    }
}