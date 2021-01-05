// 프로그래머스 '네트워크'
// DFS & BFS
// 2021.01.04

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Network {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int count;

    public static int solution(int n, int[][] computers) {

        initGraph(n, computers);
        initVisited(n);
        countNetworks(n);
        return count;
    }

    private static void initGraph(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j < computers[i].length; j++)
                if (computers[i][j] == 1 && i != j)
                    graph.get(i).add(j);
        }
    }

    private static void initVisited(int n) {
        visited = new boolean[n];
        Arrays.fill(visited, false);
    }

    private static void countNetworks(int n) {
        for (int i = 0; i < n; i++)
            bfs(i);
    }

    private static void bfs(int node) {
        if (visited[node])
            return;

        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int adjacent : graph.get(current))
                if (!visited[adjacent]) {
                    queue.offer(adjacent);
                    visited[adjacent] = true;
                }
        }
        count++;
    }
}