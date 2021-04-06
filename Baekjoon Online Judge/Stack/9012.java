// 백준 9012 Parenthesis
// Stack
// 2021.04.06

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int T;
    private static List<String> lines = new ArrayList<>();

    private static List<String> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        parseInputAndInitParams();
        verifyLinesVPS();
        writeAnswers();

        br.close();
        bw.close();
    }

    private static void parseInputAndInitParams() throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) lines.add(br.readLine());
    }

    private static void verifyLinesVPS() {
        for (String line : lines)
            if (isVPS(line)) answers.add("YES");
            else answers.add("NO");
    }

    private static boolean isVPS(String line) {
        Stack<Character> stack = new Stack<>();
        for (char current : line.toCharArray()) {
            if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private static void writeAnswers() throws IOException {
        for (String answer : answers)
            bw.append(answer).append("\n");
    }
}