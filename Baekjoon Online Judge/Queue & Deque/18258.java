import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 18258 '큐 2'
// Queue
// 2020.07.31

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();

		String action;
		boolean isWrite;
		int res = -1, last = -1;
		for (int i = 0; i < N; i++) {
			isWrite = true;
			tk = new StringTokenizer(br.readLine());
			action = tk.nextToken();

			switch (action) {
			case "push":
				last = Integer.parseInt(tk.nextToken());
				queue.add(last);
				isWrite = false;
				break;
			case "pop":
				if (queue.isEmpty())
					res = -1;
				else
					res = queue.poll();
				break;
			case "size":
				res = queue.size();
				break;
			case "empty":
				if (queue.isEmpty())
					res = 1;
				else
					res = 0;
				break;
			case "front":
				if (queue.isEmpty())
					res = -1;
				else
					res = queue.peek();
				break;
			case "back":
				if (queue.isEmpty())
					res = -1;
				else
					res = last;
				break;
			}

			if (isWrite) {
				bw.write(Integer.toString(res) + "\n");
			}
		}

		br.close();
		bw.close();
	}
}
