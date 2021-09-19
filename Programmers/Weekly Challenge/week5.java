// 프로그래머스 2021 위클리 챌린지
// 5주차 모음사전
// 2021.09.19

import java.util.*;

class Solution {
    
    private static final int A = 1;
    private static final int E = 2;
    private static final int I = 3;
    private static final int O = 4;
    private static final int U = 5;
    private static final Map<Character, Integer> index = new HashMap<>();
    
    public int solution(String word) {
        index.put('A', A);
        index.put('E', E);
        index.put('I', I);
        index.put('O', O);
        index.put('U', U);
        
        int answer = word.length();
        
        for (int i=0 ; i<word.length() ; i++) {
            int currentIndex = index.get(word.charAt(i));
            int count = (currentIndex-A) * multipleSum(5-i);
            answer += count;
        }
        
        return answer;
    }
    
    private int multipleSum(int time) {
        return (int) (Math.pow(5, time) - 1) / 4;
    }
}