import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 2164 '카드2'
// Queue
// 2020.07.31

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		while (queue.size() > 1) {
			queue.poll();
			if (queue.size() == 1)
				break;
			queue.add(queue.poll());
		}

		bw.write(Integer.toString(queue.poll()));

		br.close();
		bw.close();
	}
}
