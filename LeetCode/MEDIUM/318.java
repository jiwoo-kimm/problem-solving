// LeetCode
// 318. Maximum Product of Word Lengths
// 2021.05.27

class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, (o1, o2) -> (o2.length() - o1.length()));
        int max = 0;
        for (int i=0 ; i<words.length-1 ; i++) {
            for (int j=i+1 ; j<words.length ; j++) {
                max = Math.max(max, calcValue(words[i], words[j]));
            }
        }
        return max;
    }
    
    private int calcValue(String a, String b) {
        Set<Character> chars = new HashSet<>();
        
        for (char c : a.toCharArray())
            chars.add(c);

        for (char c : b.toCharArray())
            if (chars.contains(c)) return 0;
        
        return a.length() * b.length();
    }
}