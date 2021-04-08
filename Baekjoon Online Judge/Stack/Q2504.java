// 백준 2504번 괄호의 값
// Stack
// 2021.04.06, 2021.04.08

import java.io.*;
import java.util.Stack;

public class Q2504_ver1 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int answer = calcValue(line);
        bw.append(Integer.toString(answer));

        br.close();
        bw.close();
    }

    private static int calcValue(String line) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int subValue = 1;
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            switch (current) {
                case '(' -> {
                    stack.push(current);
                    subValue *= 2;
                }
                case '[' -> {
                    stack.push(current);
                    subValue *= 3;
                }
                case ')' -> {
                    if (isInvalid(stack, current)) return 0;
                    if (line.charAt(i - 1) == '(') result += subValue;
                    stack.pop();
                    subValue /= 2;
                }
                case ']' -> {
                    if (isInvalid(stack, current)) return 0;
                    if (line.charAt(i - 1) == '[') result += subValue;
                    stack.pop();
                    subValue /= 3;
                }
            }
        }
        if (!stack.isEmpty()) return 0;
        return result;
    }

    private static boolean isInvalid(Stack<Character> stack, char current) {
        if (stack.isEmpty()) return true;
        if (current == ')' && stack.peek() != '(') return true;
        if (current == ']' && stack.peek() != '[') return true;
        return false;
    }
}

public class Q2504_ver2 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        int answer = calcValue(line);
        bw.append(Integer.toString(answer));

        br.close();
        bw.close();
    }

    private static int calcValue(String line) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (isOpeningParentheses(current)) {
                stack.push(current + "");
            } else if (isClosingParentheses(current)) {
                int subValue = Math.max(getSubValue(stack), 1);
                if (stack.isEmpty() || !stack.pop().equals(pair(current))) return 0;
                stack.push(subValue * unit(current) + "");
            }
        }
        return getResultValue(stack);
    }

    private static boolean isOpeningParentheses(char current) {
        return current == '(' || current == '[';
    }

    private static boolean isClosingParentheses(char current) {
        return current == ')' || current == ']';
    }

    private static int getSubValue(Stack<String> stack) {
        int result = 0;
        while (!stack.isEmpty() && isNumber(stack.peek()))
            result += Integer.parseInt(stack.pop());
        return result;
    }

    private static boolean isNumber(String str) {
        return !str.equals("(") && !str.equals(")")
                && !str.equals("[") && !str.equals("]");
    }

    private static String pair(char current) {
        if (current == ')') return "(";
        else return "[";
    }

    private static int unit(char current) {
        if (current == ')') return 2;
        else return 3;
    }

    private static int getResultValue(Stack<String> stack) {
        int result = 0;
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!isNumber(current)) return 0;
            else result += Integer.parseInt(current);
        }
        return result;
    }
}