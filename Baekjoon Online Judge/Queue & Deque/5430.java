import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 5430 'AC'
// Deque
// 2020.08.03

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Get input

		StringTokenizer tk = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(tk.nextToken());

		ArrayDeque<Integer> deque;
		String funcLine;
		int n;

		for (int i = 0; i < T; i++) {

			tk = new StringTokenizer(br.readLine());
			funcLine = tk.nextToken();

			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());

			deque = new ArrayDeque<Integer>();
			tk = new StringTokenizer(br.readLine(), "[],");
			for (int j = 0; j < n; j++) {
				deque.addLast(Integer.parseInt(tk.nextToken()));
			}

			// Get result
			boolean isReversed = false;
			boolean isError = false;
			for (int j = 0; j < funcLine.length() && !isError; j++) {
				switch (funcLine.charAt(j)) {
				case 'R':
					isReversed = !isReversed;
					break;
				case 'D':
					if (deque.isEmpty()) {
						isError = true;
					} else {
						if (isReversed) {
							deque.pollLast();
						} else {
							deque.pollFirst();
						}
					}
					break;
				}
			}

			if (isError) {
				bw.write("error\n");
			} else {
				// write deque
				int length = deque.size();
				bw.write("[");
				if (isReversed) {
					for (int j = 0; j < length - 1; j++) {
						bw.write(Integer.toString(deque.pollLast()) + ",");
					}
				} else {
					for (int j = 0; j < length - 1; j++) {
						bw.write(Integer.toString(deque.pollFirst()) + ",");
					}
				}
				// check if length is 0
				if (length > 0)
					bw.write(Integer.toString(deque.poll()));
				bw.write("]\n");
			}
		}

		br.close();
		bw.close();
	}
}
