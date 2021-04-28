// 백준 6549번 히스토그램에서 가장 큰 직사각형
// Segment Tree
// 2021.04.28

import java.io.*;

public class Main {

    private static final String FINISH = "0";
    private static final int INVALID = -1;

    private static int n;
    private static long[] heights;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line;
        while ((line = br.readLine().split(" ")).length > 1) {
            n = Integer.parseInt(line[0]);
            heights = new long[n + 1];
            tree = new int[(n + 1) * 4];
            for (int i = 1; i <= n; i++) heights[i] = Long.parseLong(line[i]);
            initTree(1, 1, n);
            bw.append(String.valueOf(calcMaxArea(1, n))).append("\n");
        }

        br.close();
        bw.close();
    }

    private static void initTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = start;
            return;
        }
        int mid = (start + end) / 2;
        initTree(node * 2, start, mid);
        initTree(node * 2 + 1, mid + 1, end);
        tree[node] = (heights[tree[node * 2]] < heights[tree[node * 2 + 1]] ? tree[node * 2] : tree[node * 2 + 1]);
    }

    private static long calcMaxArea(int left, int right) {
        if (left > right) return 0;
        if (left == right) return heights[left];
        int index = getMaxHeightIndex(1, 1, n, left, right);
        long max = heights[index] * (long) (right - left + 1);
        max = Math.max(max, calcMaxArea(left, index - 1));
        max = Math.max(max, calcMaxArea(index + 1, right));
        return max;
    }

    private static int getMaxHeightIndex(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return INVALID;
        if (start >= left && end <= right) return tree[node];

        int mid = (start + end) / 2;
        int leftMax = getMaxHeightIndex(node * 2, start, mid, left, right);
        int rightMax = getMaxHeightIndex(node * 2 + 1, mid + 1, end, left, right);
        if (leftMax == INVALID) return rightMax;
        if (rightMax == INVALID) return leftMax;
        return (heights[leftMax] < heights[rightMax] ? leftMax : rightMax);
    }
}
