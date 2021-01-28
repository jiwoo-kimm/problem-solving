// 2020 카카오 블라인드 채용
// 괄호 변환
// 2021.01.28


import java.util.Stack;

public class Parentheses {

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static String solution(String p) {
        return makeCorrect(p);
    }

    private static String makeCorrect(String str) {
        if (str.isEmpty() || isCorrect(str)) return str;
        int mid = getMinimumBalancedSubstringIndex(str);
        String u = str.substring(0, mid);
        String v = str.substring(mid);
        String answer;
        if (isCorrect(u)) answer = u + makeCorrect(v);
        else answer = "(" + makeCorrect(v) + ")" + makeReversed(u);
        return answer;
    }

    private static boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for (char current : str.toCharArray())
            if (!stack.isEmpty() && stack.peek() == '(' && current == ')') stack.pop();
            else stack.push(current);
        return stack.isEmpty();
    }

    private static int getMinimumBalancedSubstringIndex(String str) {
        int leftCount = 0, rightCount = 0;
        for (char current : str.toCharArray()) {
            if (current == '(') leftCount++;
            else rightCount++;
            if (leftCount == rightCount) return leftCount + rightCount;
        }
        return leftCount + rightCount;
    }

    private static String makeReversed(String str) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < str.length() - 1; i++)
            if (str.charAt(i) == '(') answer.append(")");
            else answer.append("(");
        return answer.toString();
    }
}
