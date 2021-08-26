// 프로그래머스 '디스크 컨트롤러'
// Heap
// 2021.08.26

import java.util.*;

class Solution {
    private static final int REQUEST = 0;
    private static final int DURATION = 1;
    
    public int solution(int[][] jobs) {
        int jobCount = jobs.length;
        Arrays.sort(jobs, (o1, o2) -> o1[REQUEST] - o2[REQUEST]);
        
        int finishedCount = 0;
        int queued = 0;
        int time = 0;
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> jobs[o1][DURATION] - jobs[o2][DURATION]
        );
        
        while (finishedCount < jobCount) {
            while (queued < jobCount) {
                if (jobs[queued][REQUEST] > time) {
                    break;
                }
                pq.offer(queued++);
            }
            
            if (pq.isEmpty()) {
                time = jobs[queued][REQUEST];
                pq.offer(queued++);
                continue;
            }
            
            int working = pq.poll();
            answer += time - jobs[working][REQUEST] + jobs[working][DURATION];
            time += jobs[working][DURATION];
            finishedCount++;
        }
        
        return answer / jobCount;
    }
}