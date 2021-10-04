// LeetCode
// 32. Longest Valid Parentheses
// 2021.10.04

class Solution {
    public int longestValidParentheses(String s) {
        
        int[] dp = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                continue;
            } 
            
            if (c == ')') {
                if (stack.isEmpty()) {
                    continue;
                }
                
                int left = stack.pop();
                if (s.charAt(left) == '(') {
                    dp[i] = i - left + 1;
                }
            }
        }
        
        int answer = 0;
        for (int i=s.length()-1 ; i>=0 ; i--) {
            if (dp[i] == 0) {
                continue;
            }
            
            int length = 0;
            int j = i;
            while (j >= 0 && dp[j] != 0) {
                length += dp[j];
                j -= dp[j];
            }
            answer = Math.max(answer, length);
        }
        
        return answer;
    }
}