// LeetCode
// 7. Reverse Integer
// 2021.05.24

class Solution {
    public int reverse(int x) {
        
        if (x < 10 && x > -10) return x;
        
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }
 
        int length = String.valueOf(x).length();
        int answer = 0;
        for (int i=1 ; i<=length ; i++) {
            int digit = (int) (x % Math.pow(10, i) / Math.pow(10, i-1));
            answer += digit * Math.pow(10, length-i);
        }
        
        if (isNegative) answer *= -1;
        
        if (answer <= Integer.MIN_VALUE + 1 || answer >= Integer.MAX_VALUE - 1) return 0;
        
        return answer;
    }
}