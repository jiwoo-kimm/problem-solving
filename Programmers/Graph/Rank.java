// 프로그래머스 순위
// Graph
// 2021.04.23

import java.util.*;

class Solution {
    
    private static final int WINNER = 0;
    private static final int LOSER = 1;
    
    private int n;
    private List<List<Integer>> graph;
    
    public int solution(int n, int[][] results) {
        this.n = n;
        initGraph(results);
        return countRanked();
    }
    
    private void initGraph(int[][] results) {
        graph = new ArrayList<>();
        for (int i=0 ; i<=n ; i++)
            graph.add(new ArrayList<>());
        for (int[] result : results)
            graph.get(result[WINNER]).add(result[LOSER]);
    }
    
    private int countRanked() {
        int count = 0;
        for (int i=1 ; i<=n ; i++)
            if (isRanked(i)) count++;
        return count;
    }
    
    private boolean isRanked(int target) {
        return countUpper(target) + countLower(target) == n - 1;
    }
    
    private int countUpper(int target) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> uppers = new LinkedList<>();
        uppers.offer(target);
        int count = 0;
        while(!uppers.isEmpty()) {
            int current = uppers.poll();
            visited[current] = true;
            count++;
            for (int i=1 ; i<=n ; i++)
                if (graph.get(i).contains(current) && !visited[i]) {
                    visited[i] = true;
                    uppers.offer(i);
                }
        }
        return count - 1;
    }
    
    private int countLower(int target) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> lowers = new LinkedList<>();
        lowers.offer(target);
        int count = 0;
        while(!lowers.isEmpty()) {
            int current = lowers.poll();
            count++;
            for (int lower : graph.get(current)) {
                if (!visited[lower]) {
                    visited[lower] = true;
                    lowers.offer(lower);
                }
            }
        }
        return count - 1;
    }
}