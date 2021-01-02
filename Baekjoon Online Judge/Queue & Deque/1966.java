import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1966 '프린터 큐'
// Queue
// 2020.08.01

public class Main {

	static Queue<Integer> queue;
	static int[] priority;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(tk.nextToken());

		int target, order;
		for (int i = 0; i < T; i++) {

			// Get input
			tk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tk.nextToken());
			target = Integer.parseInt(tk.nextToken());

			queue = new LinkedList<Integer>();
			priority = new int[N];

			tk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				queue.add(j);
				priority[j] = Integer.parseInt(tk.nextToken());
			}

			// Get order
			order = getOrder(target);
			bw.write(Integer.toString(order) + "\n");
		}

		br.close();
		bw.close();
	}

	private static int getOrder(int target) {

		int order = 0;

		if (queue.size() == 1)
			return order + 1;

		int currentPriority;
		int currentItem;
		boolean isPriority;

		while (!queue.isEmpty()) {

			isPriority = true;
			currentItem = queue.peek();
			currentPriority = priority[currentItem];
			
			// priority check for current item
			for (int i = 0; i < N && isPriority; i++) {
				if (priority[i] > currentPriority)
					isPriority = false;
			}

			// if priority,
			if (isPriority) {
				order++;
				// if target, return
				if (currentItem == target) {
					return order;
				// if not, print current item
				} else {
					priority[currentItem] = 0;
					queue.poll();
				}
			// if not, adjust queue
			} else {
				queue.add(queue.poll());
			}
		}

		return -1;
	}

}
