// 2020 카카오 인턴 : 보석 쇼핑
// 2021.05.06

import java.util.*;

class Solution {
    
    private int minStart = Integer.MAX_VALUE;
    private int minSize = Integer.MAX_VALUE;

    public int[] solution(String[] gems) {
        Map<String, Integer> bucket = initBucket(gems);
        findMinSection(gems, bucket);
        return new int[]{minStart + 1, minStart + minSize};
    }

    private Map<String, Integer> initBucket(String[] gems) {
        Map<String, Integer> bucket = new HashMap<>();
        for (String gem : gems) bucket.putIfAbsent(gem, 0);
        return bucket;
    }

    private void findMinSection(String[] gems, Map<String, Integer> bucket) {
        int start = 0, end = 1, typeCount = 1;
        bucket.put(gems[start], 1);
        while (start < end) {
            if (typeCount == bucket.size()) {
                int size = end - start;
                if (size < minSize) {
                    minStart = start;
                    minSize = size;
                }
                bucket.put(gems[start], bucket.get(gems[start]) - 1);
                if (bucket.get(gems[start]) < 1) typeCount--;
                start++;
            } else {
                if (end < gems.length) {
                    bucket.put(gems[end], bucket.get(gems[end]) + 1);
                    if (bucket.get(gems[end]) == 1) typeCount++;
                    end++;
                } else {
                    bucket.put(gems[start], bucket.get(gems[start]) - 1);
                    if (bucket.get(gems[start]) < 1) typeCount--;
                    start++;
                }
            }
        }
    }
}