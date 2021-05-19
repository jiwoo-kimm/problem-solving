// LeetCode
// 345. Reverse Vowels of a String
// 2021.05.19

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');       
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        ArrayList<Integer> vowelIndices = new ArrayList<>();
        for (int i=0 ; i<s.length() ; i++)
            if (vowels.contains(s.charAt(i)))
                vowelIndices.add(i);
            
        StringBuilder sb = new StringBuilder();
        int vowelIndex = vowelIndices.size() - 1;
        for (int i=0 ; i<s.length() ; i++) {
	        if (vowels.contains(s.charAt(i)))
		            sb.append(s.charAt(vowelIndices.get(vowelIndex--)));
	        else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}