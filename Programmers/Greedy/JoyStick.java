// 프로그래머스 그리디
// 조이스틱
// 2021.03.26

class Solution {

    private static final int A = 65;
    private static final int Z = 90;

    public int solution(String name) {
        return countUpDownMovement(name) + countLeftRightMovement(name);
    }

    private int countUpDownMovement(String str) {
        int count = 0;
        for (char ch : str.toCharArray())
            count += Math.min(ch - A, Z - ch + 1);
        return count;
    }

    private int countLeftRightMovement(String name) {
        int min = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int endOfAIndex = i;
            if (name.charAt(endOfAIndex) == A) {
                while (endOfAIndex < name.length() && name.charAt(endOfAIndex) == A) endOfAIndex++;
                int moveCount = ((i - 1) * 2) + (name.length() - endOfAIndex);
                min = Math.min(min, Math.max(0, moveCount));
            }
        }
        return min;
    }
}