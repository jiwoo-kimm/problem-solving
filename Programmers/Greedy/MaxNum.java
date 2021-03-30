class Solution {
    
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int targetLength = number.length() - k;
        int startIndex = 0, endIndex, maxNumberIndex;
        for (int i = 0; i < targetLength; i++) {
            endIndex = i + k;
            maxNumberIndex = findMaxNumIndex(number, startIndex, endIndex);
            result.append(number.charAt(maxNumberIndex) - '0');
            startIndex = maxNumberIndex + 1;
        }
        return result.toString();
    }

    private int findMaxNumIndex(String number, int startIndex, int endIndex) {
        int maxNum = Integer.MIN_VALUE;
        int maxNumIndex = startIndex;
        for (int i = startIndex; i <= endIndex; i++) {
            if (number.charAt(i) > maxNum) {
                maxNum = number.charAt(i);
                maxNumIndex = i;
            }
        }
        return maxNumIndex;
    }
}