// 백준 1655 '가운데를 말해요'
// Priority Queue
// 2020.08.14

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int x;
    private static Queue<Integer> minHeap;
    private static Queue<Integer> maxHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        initHeaps();

        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tk.nextToken());
            addToHeaps(x);
            bw.write(Integer.toString(getMidNum()) + "\n");
        }

        br.close();
        bw.close();
    }

    private static void addToHeaps(int x) {
        if (minHeap.size() == maxHeap.size())
            addToMaxHeap(x);
        else
            addToMinHeap(x);

        checkHeapsTop();
    }

    private static void checkHeapsTop() {
        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            if (maxHeap.peek() > minHeap.peek()) {
                swapHeapsTop();
            }
        }
    }

    private static void swapHeapsTop() {
        int minTop = minHeap.poll();
        int maxTop = maxHeap.poll();
        minHeap.offer(maxTop);
        maxHeap.offer(minTop);
    }

    private static void addToMaxHeap(int x) {
        maxHeap.offer(x);
    }

    private static void addToMinHeap(int x) {
        minHeap.offer(x);
    }

    private static void initHeaps() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });
        minHeap = new PriorityQueue<>();
    }

    private static int getMidNum() {
        return maxHeap.peek();
    }
}
