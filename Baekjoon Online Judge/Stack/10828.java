import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 10828 '스택'
// Stack
// 2020.07.27

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());
		
		Stack<Integer> stack = new Stack<Integer>();

		String action;
		boolean isWrite;
		int num = 0, res = -1;
		for (int i = 0; i < N; i++) {
			isWrite = true;
			tk = new StringTokenizer(br.readLine());
			action = tk.nextToken();
			if (tk.hasMoreTokens()) {
				num = Integer.parseInt(tk.nextToken());
			}

			switch (action) {
			case "push":
				isWrite = false;
				stack.push(num);
				break;
			case "pop":
				if (stack.isEmpty()) res = -1;
				else res = stack.pop();
				break;
			case "size":
				res = stack.size();
				break;
			case "empty":
				if (stack.isEmpty()) res = 1;
				else res = 0;
				break;
			case "top":
				if (stack.isEmpty()) res = -1;
				else res = stack.peek();
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
