import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 10866 '덱'
// Deque
// 2020.08.03

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());

		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

		String op;
		int num, res = 0;
		boolean isWrite;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			op = tk.nextToken();

			isWrite = true;
			switch (op) {
			case "push_front":
				num = Integer.parseInt(tk.nextToken());
				deque.addFirst(num);
				isWrite = false;
				break;
			case "push_back":
				num = Integer.parseInt(tk.nextToken());
				deque.addLast(num);
				isWrite = false;
				break;
			case "pop_front":
				if (deque.isEmpty())
					res = -1;
				else
					res = deque.pollFirst();
				break;
			case "pop_back":
				if (deque.isEmpty())
					res = -1;
				else
					res = deque.pollLast();
				break;
			case "size":
				res = deque.size();
				break;
			case "empty":
				if (deque.isEmpty())
					res = 1;
				else
					res = 0;
				break;
			case "front":
				if (deque.isEmpty())
					res = -1;
				else
					res = deque.peekFirst();
				break;
			case "back":
				if (deque.isEmpty())
					res = -1;
				else
					res = deque.peekLast();
				break;
			}
			
			if (isWrite)
				bw.write(Integer.toString(res) + "\n");
		}

		br.close();
		bw.close();
	}
}
