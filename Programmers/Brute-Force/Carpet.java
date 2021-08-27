// 프로그래머스 '카펫'
// 완전탐색
// 2021.03.03, 2021.08.27

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int yellowHeight=1 ; yellowHeight<=Math.sqrt(yellow) ; yellowHeight++) {
            if (yellow % yellowHeight == 0) {
                int totalHeight = yellowHeight + 2;
                int totalWidth = (yellow / yellowHeight) + 2;
                
                if ((totalHeight * totalWidth) == total) {
                    return new int[]{totalWidth, totalHeight};
                }
            }
        }
        return null;
    }
}