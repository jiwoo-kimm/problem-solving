// 월간 코드 챌린지 시즌 2 : 괄호 회전하기
// 2021.05.17

import java.util.*;

class Solution {
    
    private final static Set<Character> opens = new HashSet<>();

    public int solution(String target) {
        opens.add('[');
        opens.add('(');
        opens.add('{');

        int answer = 0;
        int startIndex = 0;
        while (startIndex < target.length()) {
            Stack<Character> stack = new Stack<>();
            int currentIndex = startIndex;
            int checked;
            for (checked = 0; checked < target.length(); checked++) {
                char current = target.charAt(currentIndex % target.length());

                if (opens.contains(current)) stack.push(current);
                else if (stack.isEmpty() || !matches(stack.pop(), current)) break;
                currentIndex++;
            }

            if (checked == target.length() && stack.isEmpty()) answer++;
            startIndex++;
        }
        return answer;
    }

    private boolean matches(char before, char current) {
        if (before == '[' && current == ']') return true;
        if (before == '(' && current == ')') return true;
        if (before == '{' && current == '}') return true;
        return false;
    }
}