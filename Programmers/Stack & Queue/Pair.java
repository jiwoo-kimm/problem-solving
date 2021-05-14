// 2017 팁스타운 : 짝지어 제거하기
// 2021.05.14

import java.util.*;

class Solution {
    
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;

    public int solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (stack.isEmpty())
                stack.push(current);
            else
                if (stack.peek() == current) stack.pop();
                else stack.push(current);
        }
        return stack.isEmpty() ? SUCCESS : FAIL;
    }
}