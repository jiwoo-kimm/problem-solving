// 백준 2042번 구간 합 구하기
// Segment Tree
// 2021.04.27

import java.io.*;

public class Main {

    private static final int MAX = 1000000;
    private static final int UPDATE = 1;
    private static final int PICK = 2;

    private static long[] arr = new long[MAX + 1];
    private static long[] tree = new long[(MAX + 1) * 4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        for (int i = 1; i <= n; i++) arr[i] = Long.parseLong(br.readLine());
        initTree(1, 1, n);

        for (int i = 0; i < m + k; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            long c = Long.parseLong(line[2]);

            if (a == UPDATE) {
                updateTree(1, 1, n, b, c);
                arr[b] = c;
            } else if (a == PICK)
                bw.append(String.valueOf(sum(1, 1, n, b, (int) c))).append("\n");
        }

        br.close();
        bw.close();
    }

    private static long initTree(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = initTree(node * 2, start, mid)
                + initTree(node * 2 + 1, mid + 1, end);
    }

    private static void updateTree(int node, int start, int end, int targetIndex, long newValue) {
        if (targetIndex < start || targetIndex > end) return;
        tree[node] -= arr[targetIndex];
        tree[node] += newValue;
        if (start == end) return;

        int mid = (start + end) / 2;
        updateTree(node * 2, start, mid, targetIndex, newValue);
        updateTree(node * 2 + 1, mid + 1, end, targetIndex, newValue);
    }

    private static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (start >= left && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right)
                + sum(node * 2 + 1, mid + 1, end, left, right);
    }
}