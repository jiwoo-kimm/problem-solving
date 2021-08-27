// 프로그래머스 '소수 찾기'
// 2021.02.24, 2021.08.27

import java.util.*;

class Solution {
    
    private Set<Integer> primeNumbers = new HashSet<>();
    
    public int solution(String numbers) {
        char[] digits = numbers.toCharArray();
        
        for (int i=0 ; i<digits.length ; i++) {
            if (digits[i] == '0') {
                continue;
            }
            
            boolean[] visited = new boolean[digits.length];
            visited[i] = true;
            
            permutation(""+digits[i], digits, visited);
        }
        
        return primeNumbers.size();
    }
    
    private void permutation(String current, char[] digits, boolean[] visited) {        
        int number = Integer.parseInt(current) ;
        
        if (isPrime(number)) {
            primeNumbers.add(number);
        }
        
        for (int i=0 ; i<digits.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(current+digits[i], digits, visited);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i=2 ; i<=Math.sqrt(number) ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}