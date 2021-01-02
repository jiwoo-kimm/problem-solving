// 백준 11279 '최대 힙'
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

        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
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

        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tk.nextToken());

            if (x > 0)
                maxHeap.offer(x);
            else {
                if (maxHeap.size() == 0)
                    bw.write(Integer.toString(0));
                else
                    bw.write(Integer.toString(maxHeap.poll()));
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }
}
