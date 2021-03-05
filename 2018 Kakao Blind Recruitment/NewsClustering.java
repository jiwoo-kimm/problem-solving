// 2018 카카오 블라인드 채용
// 뉴스 클러스터링
// 2021.03.05

import java.util.*;

class Solution {
        
    private static final int CONST = 65536;

    private Map<String, Integer> union = new HashMap<>();
    private int intersectionCount;

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        double similarity = jaccard(str1, str2);
        return (int) (similarity * CONST);
    }

    private double jaccard(String str1, String str2) {
        Map<String, Integer> subset1 = getSubset(str1);
        Map<String, Integer> subset2 = getSubset(str2);
        if (subset1.size() == 0 && subset2.size() == 0) return 1;
        compareSubsets(subset1, subset2);
        return (double) intersectionCount / sumOfUnionCounts();
    }
    
    private double sumOfUnionCounts() {
        return union.values().stream().mapToInt(Integer::valueOf).sum();
    }

    private Map<String, Integer> getSubset(String str) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (isAlphabet(str.charAt(i)) && isAlphabet(str.charAt(i + 1))) {
                String subString = str.substring(i, i + 2);
                result.put(subString, result.getOrDefault(subString, 0) + 1);
            }
        }
        return result;
    }

    private boolean isAlphabet(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private void compareSubsets(Map<String, Integer> subset1, Map<String, Integer> subset2) {
        for (String key1 : subset1.keySet()) {
            for (String key2 : subset2.keySet()) {
                if (key1.equals(key2)) {
                    intersectionCount += Math.min(subset1.get(key1), subset2.get(key2));
                    union.put(key1, Math.max(subset1.get(key1), subset2.get(key2)));
                } else {
                    union.put(key1, Math.max(subset1.get(key1), union.getOrDefault(key1, 0)));
                    union.put(key2, Math.max(subset2.get(key2), union.getOrDefault(key2, 0)));
                }
            }
        }
    }
}