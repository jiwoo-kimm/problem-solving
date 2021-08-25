// 프로그래머스 '프린터'
// 2021.02.16, 2021.08.25

import java.util.*;

class Solution {
    public int solution(int[] priorities, int targetIndex) {
        Queue<Integer> queue = new LinkedList<>();
        for(int each : priorities){
            queue.add(each);
        }

        Arrays.sort(priorities);
        int size = priorities.length;

        int printedCount = 0;
        while(!queue.isEmpty()){
            int priority = queue.poll();
            int maxPriority = priorities[size - printedCount - 1];
            
            if (priority == maxPriority) {
                printedCount++;
                
                if (targetIndex == 0) {
                    return printedCount;
                } else {
                    targetIndex--;
                }
            } else {
                queue.offer(priority);
                
                if (targetIndex > 0) {
                    targetIndex--;                    
                } else {
                    targetIndex = queue.size()-1;
                }
            }
        }
        return printedCount;
    }
}