// 프로그래머스 '네트워크'
// DFS & BFS
// 2021.01.04, 2021.05.29

import java.util.*;

class Solution {
    
    private static final int CONNECTED = 1;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i=0 ; i<n ; i++) {
            if (visited[i]) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited[current] = true;
                
                for (int j=0 ; j<n ; j++)
                    if (current != j && computers[current][j] == CONNECTED && !visited[j])
                        queue.offer(j);
            }
            answer++;
        }
        return answer;
    }
}