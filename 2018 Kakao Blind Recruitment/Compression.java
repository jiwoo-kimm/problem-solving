// 2018 카카오 블라인드
// 압축
// 2021.03.16

import java.util.*;

class Solution {
    
    private static final int ALPHABET = 64;

    private Map<String, Integer> dict;
    private int longestWordLength;

    public int[] solution(String msg) {
        initDict();
        return LZW(msg);
    }

    private void initDict() {
        dict = new HashMap<>();
        for (char i = 'A'; i <= 'Z'; i++) dict.put(i + "", i - ALPHABET);
        longestWordLength = 1;
    }

    private int[] LZW(String msg) {
        List<Integer> result = new ArrayList<>();
        String current, next;
        int index = 0;
        while (index < msg.length()) {
            int length = getAvailableWordLength(msg, index);
            current = msg.substring(index, index + length);
            result.add(dict.get(current));
            if (index + length < msg.length()) {
                next = msg.charAt(index + length) + "";
                dict.put(current + next, dict.size() + 1);
                longestWordLength = Math.max(longestWordLength, length + 1);
            }
            index += length;
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    private int getAvailableWordLength(String msg, int startIndex) {
        int length = longestWordLength;
        while (length > 1) {
            int endIndex = startIndex + length;
            if (endIndex - 1 < msg.length()) {
                String word = msg.substring(startIndex, endIndex);
                if (dict.containsKey(word)) break;
            }
            length--;
        }
        return length;
    }
}