// 프로그래머스 Greedy
// 섬 연결하기
// 2021.04.01

import java.util.*;

class Solution {
    
    private static final int COST = 2;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (Comparator.comparingInt(o -> o[COST])));
        int[] parentNodes = createCycleTable(n);
        int answer = 0;
        for (int[] edge : costs) {
            if (parentNodes[edge[0]] != parentNodes[edge[1]]) {
                updateConnectedNodes(parentNodes, edge[1], edge[0]);
                answer += edge[COST];
            }
            if (pathCreated(parentNodes)) break;
        }
        return answer;
    }

    private void updateConnectedNodes(int[] parentNodes, int from, int to) {
        int target = parentNodes[from];
        for (int i = 0; i < parentNodes.length; i++)
            if (parentNodes[i] == target)
                parentNodes[i] = parentNodes[to];
    }

    private boolean pathCreated(int[] parentNodes) {
        for (int i = 0; i < parentNodes.length - 1; i++)
            if (parentNodes[i] != parentNodes[i + 1]) return false;
        return true;
    }

    private int[] createCycleTable(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = i;
        return result;
    }
}