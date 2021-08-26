// 프로그래머스 '더 맵게'
// Heap
// 2021.08.26

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int each : scoville) {
            pq.offer(each);
        }
        
        int count = 0;
        while (true) {
            if (pq.peek() >= K) {
                return count;
            }
            
            if (pq.size() == 1) {
                return -1;
            }
            
            int left = pq.poll();
            int right = pq.poll();
            pq.offer(scoville(left, right));
            count++;
        }
    }
    
    private int scoville(int left, int right) {
        return left + (right * 2);
    }
}