import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 백준 1021 '회전하는 큐'
// Deque
// 2020.08.03

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		// Get inputs

		int N = Integer.parseInt(tk.nextToken());
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			deque.add(i + 1);
		}

		int M = Integer.parseInt(tk.nextToken());
		tk = new StringTokenizer(br.readLine());

		// Get count

		int target, targetIndex;
		int count = 0;
		for (int i = 0; i < M; i++) {
			target = Integer.parseInt(tk.nextToken());

			// while head is not current target,
			while (deque.peekFirst() != target) {

				/*
				 * 그냥 빼내는건 안되나봄... // if head is smaller than the smallest target among remain
				 * targets // or head is larger than the largest target among remain targets if
				 * (deque.peekFirst() < sortedTargets.get(0) || deque.peekFirst() >
				 * sortedTargets.get(sortedTargets.size() - 1)) { // op 1 deque.pollFirst();
				 * bw.write("op 1\n"); } else {
				 */
				// check which way is faster
				targetIndex = deque.indexOf(target);
				if (targetIndex <= deque.size() - targetIndex - 1) {
					// op 2
					deque.addLast(deque.pollFirst());
				} else {
					// op 3
					deque.addFirst(deque.pollLast());
				}
				count++;
				// }
			}

			// remove head (which is current target) from the queue
			// op 1
			deque.pollFirst();
		}

		bw.write(Integer.toString(count));

		br.close();
		bw.close();
	}
}
