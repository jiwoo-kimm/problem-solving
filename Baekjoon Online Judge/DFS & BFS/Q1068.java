// 백준 1068번 트리
// BFS
// 2021.04.22

import java.io.*;
import java.util.Stack;

public class Main {

    private static final int ROOT = -1;

    private static int n;
    private static int[] parent;
    private static boolean[] removed;
    private static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        removeTargetNode();
        bw.append(String.valueOf(countLeafNode()));

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        removed = new boolean[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) parent[i] = Integer.parseInt(line[i]);
        target = Integer.parseInt(br.readLine());
    }

    private static void removeTargetNode() {
        Stack<Integer> stack = new Stack<>();
        stack.push(target);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            removed[current] = true;
            for (int i = 0; i < n; i++)
                if (parent[i] == current)
                    stack.push(i);
        }
    }

    private static int countLeafNode() {
        int count = 0;
        for (int i = 0; i < n; i++)
            if (!removed[i] && isLeaf(i)) count++;
        return count;
    }

    private static boolean isLeaf(int current) {
        for (int i = 0; i < n; i++)
            if (!removed[i] && parent[i] == current)
                return false;
        return true;
    }
}
