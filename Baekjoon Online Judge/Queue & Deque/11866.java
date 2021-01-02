import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 11866 '요세푸스 문제 0'
// Queue
// 2020.08.01

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());
		int K = Integer.parseInt(tk.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		bw.write("<");
		while (queue.size() > 1) {

			for (int i = 0; i < K - 1; i++) {
				queue.add(queue.poll());
			}

			bw.write(Integer.toString(queue.poll()) + ", ");
		}

		bw.write(Integer.toString(queue.poll()) + ">");

		br.close();
		bw.close();
	}
}
