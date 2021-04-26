// 백준 2243번 사탕상자
// Binary Search, Segment Tree
// 2021.04.26

import java.io.*;

public class Main {

    private static final int MAX = 1000000;
    private static final int TYPE = 0;
    private static final int PICK = 1;
    private static final int UPDATE = 2;

    private static int[] tree = new int[(MAX + 1) * 4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            if (Integer.parseInt(line[TYPE]) == PICK)
                pick(Integer.parseInt(line[1]), bw);
            else if (Integer.parseInt(line[TYPE]) == UPDATE)
                update(1, 1, MAX, Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }

        br.close();
        bw.close();
    }

    private static void pick(int target, BufferedWriter bw) throws IOException {
        bw.append(String.valueOf(binarySearch(1, 1, MAX, target))).append("\n");
    }

    private static int binarySearch(int node, int left, int right, int target) {
        if (left == right) {
            update(1, 1, MAX, left, -1);
            return left;
        }

        int middle = (left + right) / 2;
        if (tree[node * 2] >= target)
            return binarySearch(node * 2, left, middle, target);
        else
            return binarySearch(node * 2 + 1, middle + 1, right, target - tree[node * 2]);
    }

    private static void update(int node, int start, int end, int target, int count) {
        if (start > target || end < target) return;

        tree[node] += count;
        if (start == end) return;
        int middle = (start + end) / 2;
        update(node * 2, start, middle, target, count);
        update(node * 2 + 1, middle + 1, end, target, count);
    }
}
