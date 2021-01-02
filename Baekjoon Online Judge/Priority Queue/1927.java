// 백준 1927 '최소 힙'
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> minHeap = new PriorityQueue<>();

        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tk.nextToken());

            if (x > 0)
                minHeap.offer(x);
            else {
                if (minHeap.size() == 0)
                    bw.write(Integer.toString(0));
                else
                    bw.write(Integer.toString(minHeap.poll()));
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }
}
