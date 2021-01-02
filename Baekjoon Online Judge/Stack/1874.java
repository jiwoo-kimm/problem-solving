import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 1874 '스택 수열'
// Stack
// 2020.07.29

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 출력 초과 : StringBuilder로 변경
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(tk.nextToken());

		Stack<Integer> stack = new Stack<Integer>();

		int n;
		int pushNum = 0;
		boolean flag = true;
		for (int i = 0; i < N && flag; i++) {			
			tk = new StringTokenizer(br.readLine());
			n = Integer.parseInt(tk.nextToken());
			flag = false;
			
			for (int j = pushNum + 1; j <= n; j++) {
				stack.push(j);
				sb.append("+\n");
				pushNum++;
			}
			
			while (!stack.isEmpty() && stack.peek() >= n) {
				stack.pop();
				sb.append("-\n");
				flag = true;
			}
		}

		if (flag)
			System.out.println(sb.toString());
		else {
			sb.setLength(0);
			sb.append("NO");
			System.out.println(sb.toString());		
		}
	}
}
