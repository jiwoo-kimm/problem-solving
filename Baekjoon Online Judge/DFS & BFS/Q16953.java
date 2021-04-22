// 백준 16953번 A→B
// BFS
// 2021.04.22

import java.io.*;
import java.util.Stack;

public class Main {

    private static final int IMPOSSIBLE = -1;
    private static final int MUL = 2;
    private static final int ADD = 1;

    private static long a;
    private static long b;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInput(br);
        countMinOperation();
        bw.append(String.valueOf(answer == Integer.MAX_VALUE ? IMPOSSIBLE : answer + 1));

        br.close();
        bw.close();
    }

    private static void parseInput(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        a = Long.parseLong(line[0]);
        b = Long.parseLong(line[1]);
    }

    private static void countMinOperation() {
        Stack<Result> stack = new Stack<>();
        stack.push(new Result(a, 0));
        while (!stack.isEmpty()) {
            Result current = stack.pop();

            long mul = mul(current.value);
            if (mul == b) answer = Math.min(answer, current.count + 1);
            else if (mul < b) stack.push(new Result(mul, current.count + 1));

            long add = add(current.value);
            if (add == b) answer = Math.min(answer, current.count + 1);
            else if (add < b) stack.push(new Result(add, current.count + 1));
        }
    }

    private static long mul(long current) {
        return current * MUL;
    }

    private static long add(long current) {
        return Long.parseLong(current + String.valueOf(ADD));
    }
}

class Result {
    long value;
    int count;

    public Result(long value, int count) {
        this.value = value;
        this.count = count;
    }
}
