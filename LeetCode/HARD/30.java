// LeetCode
// 30. Substring with Concatenation of All Words
// 2021.06.021

class Solution {
        
    public List<Integer> findSubstring(String s, String[] words) {
        
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) counts.put(word, counts.getOrDefault(word, 0) + 1);
        
        int targetLength = words[0].length() * words.length;
        List<Integer> answer = new ArrayList<>();
        for (int i=0 ; i+targetLength <= s.length() ; i++)
            if (isConcatenation(counts, s.substring(i, i+targetLength), words[0].length()))
                answer.add(i);
        return answer;
    }
    
    private boolean isConcatenation(Map<String, Integer> targetCounts, String str, int wordLength) {
        Map<String, Integer> counts = new HashMap<>();
        int startIdx = 0;
        while (startIdx < str.length()) {
            String target = str.substring(startIdx, startIdx+wordLength);
            counts.put(target, counts.getOrDefault(target, 0) + 1);
            if (counts.get(target) > targetCounts.getOrDefault(target, 0)) return false;
            startIdx += wordLength;
        }
        return true;
    }
}