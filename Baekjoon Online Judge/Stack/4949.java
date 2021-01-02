import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 4949 '균형잡힌 세상'
// Stack
// 2020.07.28

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> stack;
		String ps;
		char input, cmp;
		boolean flag;
		while (true) {
			ps = br.readLine();
			if (ps.equals(".")) break;
			stack = new Stack<Character>();
			flag = true;

			for (int j = 0; j < ps.length() && flag; j++) {
				input = ps.charAt(j); 
				switch (input) {
				case '(':
				case '[':
					stack.push(input);
					break;
				case ')':
				case ']':
					if (stack.isEmpty()) {
						flag = false;
					} else {
						cmp = stack.pop();
						if (input == ')' && cmp != '(')
							flag = false;
						if (input == ']' && cmp != '[')
							flag = false;
					}
					break;
				}
			}

			if (flag && stack.isEmpty())
				bw.write("yes\n");
			else
				bw.write("no\n");
		}

		br.close();
		bw.close();
	}
}
