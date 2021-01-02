import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 9012 '괄호'
// Stack
// 2020.07.28

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());

		Stack<Character> stack;
		String ps;
		char input, cmp;
		boolean flag;
		for (int i = 0; i < N; i++) {
			tk = new StringTokenizer(br.readLine());
			ps = tk.nextToken();
			stack = new Stack<Character>();
			flag = true;

			for (int j = 0; j < ps.length() && flag; j++) {
				input = ps.charAt(j); 
				switch (input) {
				case '(':
					stack.push(input);
					break;
				case ')':
					if (stack.isEmpty()) {
						flag = false;
					} else {
						cmp = stack.pop();
						if (cmp != '(')
							flag = false;
					}
					break;
				}
			}

			if (flag && stack.isEmpty())
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}

		br.close();
		bw.close();
	}
}
