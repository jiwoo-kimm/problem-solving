// 프로그래머스 '다리를 지나는 트럭'
// 2021.02.13, 2021.08.26

import java.util.*;

class Solution {
    
    private static final int EMPTY = -1;
    
    public int solution(int bridgeLength, int maxWeight, int[] weights) {
        int totalTruckCount = weights.length;
        
        int truck = 0;
        int weightSum = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        bridge.offer(EMPTY);
        
        int time = 0;
        while (!bridge.isEmpty()) {
            if (truck == totalTruckCount) {
                time += bridgeLength;
                break;
            }
            
            time++;
            
            if (bridge.size() == bridgeLength) {
                int head = bridge.poll();

                if (head != EMPTY) {
                    weightSum -= weights[head];
                }
            }

            if (weightSum + weights[truck] > maxWeight) {
                bridge.offer(EMPTY);
            } else {
                bridge.offer(truck);
                weightSum += weights[truck];
                truck++;
            }
        }
        return time;
    }
}