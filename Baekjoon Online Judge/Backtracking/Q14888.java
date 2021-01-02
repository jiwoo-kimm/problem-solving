import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백준 14888 '연산자 끼워넣기'
// Backtracking
// 2020.07.10

public class Q14888 {

	static final int ADD = 0;
	static final int SUB = 1;
	static final int MUL = 2;
	static final int DIV = 3;

	static int N;
	static int[] nums;
	static int[] operatorCnt = new int[4];

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int[] operators;
	static int[] currentCnt = new int[4];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer tk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tk.nextToken());
		nums = new int[N];
		operators = new int[N];

		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tk.nextToken());
		}

		tk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operatorCnt[i] = Integer.parseInt(tk.nextToken());
		}

		backtracking(0);

		bw.write(Integer.toString(max) + "\n" + Integer.toString(min));

		bw.close();
		br.close();
	}

	private static int calc() {
		int res = nums[0];
		for (int i = 1; i < N; i++) {
			switch (operators[i - 1]) {

			case 0:
				res += nums[i];
				break;
			case 1:
				res -= nums[i];
				break;
			case 2:
				res *= nums[i];
				break;
			case 3:
				if (nums[i] < 0) {
					res /= Math.abs(nums[i]);
					res *= -1;
				} else {
					res /= nums[i];
				}
				break;
			}
		}
		return res;
	}

	private static void backtracking(int index) {

		if (promising()) {
			if (index == N - 1) {
				int res = calc();
				if (res > max)
					max = res;
				if (res < min)
					min = res;
				return;
			} else {
				for (int op = ADD; op <= DIV; op++) {
					operators[index] = op;
					currentCnt[op]++;
					backtracking(index + 1);
					operators[index] = 0;
					currentCnt[op]--;
				}
			}
		}

	}

	private static boolean promising() {
		boolean flag = true;
		for (int i = 0; i < 4; i++) {
			if (currentCnt[i] > operatorCnt[i])
				flag = false;
		}
		return flag;
	}
}
