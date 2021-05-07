// 2021 카카오 블라인드 채용 : 합승 택시 요금
// 2021.05.07

import java.util.*;

class Solution {
    
    private static final int MAX = 200;

    private List<List<Integer>> graph = new ArrayList<>();
    private int[][] costs = new int[MAX + 1][MAX + 1];
    private int[][] dp = new int[MAX + 1][MAX + 1];

    public int solution(int n, int s, int a, int b, int[][] fares) {
        parseFares(n, fares);

        calcMinCost(s);
        calcMinCost(a);
        calcMinCost(b);

        int minCost = dp[s][a] + dp[s][b];
        for (int shared = 1; shared <= n; shared++) {
            if (dp[s][shared] == Integer.MAX_VALUE || dp[shared][a] == Integer.MAX_VALUE || dp[shared][b] == Integer.MAX_VALUE)
                continue;
            minCost = Math.min(minCost, dp[s][shared] + dp[shared][a] + dp[shared][b]);
        }
        return minCost;
    }

    private void parseFares(int n, int[][] fares) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int[] fare : fares) {
            int start = fare[0], end = fare[1], cost = fare[2];
            graph.get(start).add(end);
            graph.get(end).add(start);
            costs[start][end] = cost;
            costs[end][start] = cost;
        }
    }

    private void calcMinCost(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int nextPosition : graph.get(current.position)) {
                int nextCost = current.cost + costs[current.position][nextPosition];
                if (dp[start][nextPosition] > nextCost) {
                    dp[start][nextPosition] = nextCost;
                    dp[nextPosition][start] = nextCost;
                    queue.offer(new Node(nextPosition, nextCost));
                }
            }
        }
    }
}

class Node {
    int position;
    int cost;

    public Node(int position, int cost) {
        this.position = position;
        this.cost = cost;
    }
}