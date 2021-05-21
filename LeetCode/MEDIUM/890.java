// LeetCode
// 890. Find and Replace Pattern
// 2021.05.21

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        for (String word : words)
            if (isMatch(word, pattern))
                answer.add(word);
        return answer;
    }
    
    private boolean isMatch(String word, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i=0 ; i<word.length() ; i++) {
            if (map.keySet().contains(pattern.charAt(i))) {
                if (word.charAt(i) != map.get(pattern.charAt(i)))
                    return false;
            } else {
                if (map.values().contains(word.charAt(i)))
                    return false;
                map.put(pattern.charAt(i), word.charAt(i));
            }
        }
        return true;
    }
}