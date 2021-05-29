// 프로그래머스 '단어 변환'
// DFS & BFS
// 2021.01.05, 2021.05.29

import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<ConvertedWord> queue = new LinkedList<>();
        queue.offer(new ConvertedWord(begin, 0));
        while(!queue.isEmpty()) {
            ConvertedWord current = queue.poll();
            if (current.word.equals(target)) return current.count;
            
            for (int i=0 ; i<words.length ; i++) {
                if (visited[i]) continue;
                
                if (current.isConvertable(words[i])) {
                    visited[i] = true;
                    queue.offer(new ConvertedWord(words[i], current.count+1));
                }
            }            
        }
        return 0;
    }
}

class ConvertedWord {
    String word;
    int count;
    
    public ConvertedWord(String word, int count) {
        this.word = word;
        this.count = count;
    }
    
    public boolean isConvertable(String target) {
        if (word.length() != target.length()) return false;
        int count = 0;
        for (int i=0 ; i<word.length() ; i++) {
            if (word.charAt(i) != target.charAt(i))
                if (++count > 1) return false;
        }
        return true;
    }
}