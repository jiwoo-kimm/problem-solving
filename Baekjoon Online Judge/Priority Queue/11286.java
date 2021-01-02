// 백준 11286 '절댓값 힙'
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

        Queue<Integer> minAbsHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absO1 = Math.abs(o1);
                int absO2 = Math.abs(o2);
                if (absO1 < absO2)
                    return -1;
                else if (absO1 > absO2)
                    return 1;
                else {
                    if (o1 < o2)
                        return -1;
                    else if (o1 > 02)
                        return 1;
                    else
                        return 0;
                }
            }
        });

        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            x = Integer.parseInt(tk.nextToken());

            if (x != 0)
                minAbsHeap.offer(x);
            else {
                if (minAbsHeap.isEmpty())
                    bw.write(Integer.toString(0));
                else
                    bw.write(Integer.toString(minAbsHeap.poll()));
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }
}
