// 프로그래머스 가장 먼 노드
// Graph
// 2021.04.23

import java.util.*;

class Solution {
    
    private List<List<Integer>> graph;
    
    public int solution(int n, int[][] edges) {
        initGraph(n, edges);
        int[] distances = countDistances(n);
        return countFarthestNodes(distances);
    }
    
    private void initGraph(int n, int[][] edges){
        graph = new ArrayList<>();
        for (int i=0 ; i<n+1 ; i++)
            graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
    
    private int[] countDistances(int n){
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for (int adjacent : graph.get(current.index)){
                if (!visited[adjacent]){
                    visited[adjacent] = true;
                    queue.offer(new Node(adjacent, current.distance + 1));
                    distances[adjacent] = Math.min(distances[adjacent], current.distance + 1);
                }
            }
        }
        return distances;
    }
    
    private int countFarthestNodes(int[] distances) {
        int max = findMaxValue(distances);
        int result = 0;
        for (int distance : distances)
            if (distance == max) result++;
        return result;
    }
    
    private int findMaxValue(int[] arr) {
        int result = Integer.MIN_VALUE;
        for (int i=2 ; i<arr.length ; i++)
            if (arr[i] != Integer.MAX_VALUE)
                result = Math.max(result, arr[i]);
        return result;
    }
}

class Node {
    
    int index;
    int distance;
    
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
}