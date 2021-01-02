import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 10773 '제로'
// Stack
// 2020.07.27

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(tk.nextToken());

		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0, num;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			num = Integer.parseInt(tk.nextToken());
			if (num == 0) {
				sum -= stack.pop();
			} else {
				stack.push(num);
				sum += num;
			}

		}

		bw.write(Integer.toString(sum));
		br.close();
		bw.close();
	}
}