// 백준 1922번 네트워크 연결
// Graph
// 2021.04.07

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q1922 {

    private static final int SRC = 0;
    private static final int DST = 1;
    private static final int WEIGHT = 2;

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int nodeCount;
    private static int edgeCount;
    private static int[][] costs;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initParams();
        int costForConnection = calcCostForConnection();
        bw.append(Integer.toString(costForConnection));

        br.close();
        bw.close();
    }

    private static void initParams() throws IOException {
        nodeCount = Integer.parseInt(br.readLine());
        edgeCount = Integer.parseInt(br.readLine());
        costs = new int[edgeCount][3];
        for (int i = 0; i < edgeCount; i++) {
            String[] line = br.readLine().split(" ");
            costs[i][SRC] = Integer.parseInt(line[SRC]) - 1;
            costs[i][DST] = Integer.parseInt(line[DST]) - 1;
            costs[i][WEIGHT] = Integer.parseInt(line[WEIGHT]);
        }
    }

    private static int calcCostForConnection() {
        Arrays.sort(costs, (Comparator.comparingInt(o -> o[WEIGHT])));
        int[] parentNodes = createCycleTable();
        int answer = 0;
        for (int[] edge : costs) {
            if (!hasSameParent(parentNodes, edge[SRC], edge[DST])) {
                union(parentNodes, edge[SRC], edge[DST]);
                answer += edge[WEIGHT];
            }
            if (pathCreated(parentNodes)) break;
        }
        return answer;
    }

    private static int[] createCycleTable() {
        int[] result = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) result[i] = i;
        return result;
    }

    private static boolean hasSameParent(int[] parentNodes, int a, int b) {
        return findParent(parentNodes, a) == findParent(parentNodes, b);
    }

    private static int findParent(int[] parentNodes, int node) {
        if (parentNodes[node] == node) return node;
        return findParent(parentNodes, parentNodes[node]);
    }

    private static void union(int[] parentNodes, int a, int b) {
        int parentA = findParent(parentNodes, a);
        int parentB = findParent(parentNodes, b);
        if (parentA > parentB) parentNodes[parentA] = parentB;
        else parentNodes[parentB] = parentA;
    }

    private static boolean pathCreated(int[] parentNodes) {
        for (int i = 0; i < parentNodes.length - 1; i++)
            if (parentNodes[i] != parentNodes[i + 1]) return false;
        return true;
    }
}
