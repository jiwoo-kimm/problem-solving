// 백준 1260 'DFS와 BFS'
// DFS & BFS
// 2020.12.29

import java.io.*;
import java.util.*;

public class Q1260 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int n;   // 정점의 개수
    private static int m;   // 간선의 개수
    private static int v;   // 시작할 정점의 번호

    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initGraph();

        resetVisited();
        dfs(v);
        printResult();

        resetVisited();
        bfs(v);
        printResult();

        br.close();
        bw.close();
    }

    private static void printResult() throws IOException {
        bw.append("\n");
        bw.flush();
    }

    private static void initGraph() throws IOException {
        getConstants();
        createGraph();
        setGraph();
        sortGraph();
    }

    private static void getConstants() throws IOException {
        String line = br.readLine();
        StringTokenizer tk = new StringTokenizer(line);
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        v = Integer.parseInt(tk.nextToken());
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

    private static void resetVisited() {
        visited = new boolean[n + 1];
        Arrays.fill(visited, false);
    }

    private static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.append(node + " ");
        for (int adjacent : graph.get(node))
            if (!visited[adjacent])
                dfs(adjacent);
    }

    private static void bfs(int node) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.offer(node);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            bw.append(current + " ");
            for (int adjacent : graph.get(current))
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.offer(adjacent);
                }
        }
    }
}