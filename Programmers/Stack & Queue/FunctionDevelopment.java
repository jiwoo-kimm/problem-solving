// 프로그래머스 스택/큐
// 기능개발
// 2021.02.04, 2021.08.24

import java.util.*;

class Solution {
    
    private static final int DONE = 100;
    
    private int[] progresses;
    private int[] speeds;
    private int total;
    
    public int[] solution(int[] progresses, int[] speeds) {
        this.progresses = progresses;
        this.speeds = speeds;
        this.total = progresses.length;
        
        List<Integer> answer = new ArrayList<>();
        
        int work = 0;
        while (work < total) {
            int day = workDay(work);
            int finished = 1;
            
            work++;
            
            while (work < total) {
                if (workDay(work) > day) {
                    break;
                }
                
                finished++;
                work++;
            }
            
            answer.add(finished);
       }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    private int workDay(int target) {
        int remain = DONE - progresses[target];
        int speed = speeds[target];
        
        if (remain % speed == 0) {
            return remain / speed;
        }
        return remain / speed + 1;
    }
}