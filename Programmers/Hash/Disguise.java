// 프로그래머스 '위장'
// 해시
// 2021.01.21, 2021.08.24

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> counts = new HashMap<>();
        
        for (String[] each : clothes) {
            String category = each[1];
            counts.put(category, counts.getOrDefault(category, 0) + 1);
        }
        
        return counts.values().stream()
            .mapToInt(count -> count+1)
            .reduce(1, (a,b) -> a*b) - 1;
    }
}