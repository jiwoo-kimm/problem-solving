// 백준 2606 '바이러스'
// DFS & BFS
// 2020.12.29

import java.io.*;
import java.util.*;

public class Q2606 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int n;   // 컴퓨터 수
    private static int m;   // 간선 수
    private static int count;   // 감염된 컴퓨터 수

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initGraph();
        initVisited();
        bfs(1);
        printAnswer();

        br.close();
        bw.close();
    }

    private static void initGraph() throws IOException {
        getConstants();
        createGraph();
        setGraph();
        sortGraph();
    }

    private static void getConstants() throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
    }

    private static void createGraph() {
        for (int i = 0; i < n + 1; i++)
            graph.add(new ArrayList<>());
    }

    private static void setGraph() throws IOException {
        String line;
        StringTokenizer tk;
        int src, dst;
        for (int i = 0; i < m; i++) {
            line = br.readLine();
            tk = new StringTokenizer(line);
            src = Integer.parseInt(tk.nextToken());
            dst = Integer.parseInt(tk.nextToken());
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
    }

    private static void sortGraph() {
        for (ArrayList<Integer> edges : graph)
            Collections.sort(edges);
    }

    private static void initVisited() {
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int adjacent : graph.get(current))
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.offer(adjacent);
                }
        }
    }

    private static void printAnswer() throws IOException {
        bw.append(Integer.toString(count - 1)); // 1번 컴퓨터 제외
        bw.close();
    }
}