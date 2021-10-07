// LeetCode
// 140. Word Break II
// 2021.10.07

class Solution {
    
    private Set<String> dictionary;
    private StringBuilder sentence = new StringBuilder();
    private List<String> answer = new ArrayList<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        dictionary = new HashSet<>(wordDict);
        
        dfs(s, 0, 0);
        return answer;
    }
    
    private void dfs(String s, int start, int end) {
        if (start == s.length()) {
            answer.add(sentence.toString().trim());
            return;
        }
        
        if (end == s.length()) {
            return;
        }
        
        String word = s.substring(start, end+1);
        if (dictionary.contains(word.toString())) {
            sentence.append(word).append(" ");
            dfs(s, end+1, end+1);
            sentence.replace(sentence.lastIndexOf(word), sentence.length(), "");
        }
        dfs(s, start, end+1);
    }
}