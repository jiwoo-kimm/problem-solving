// 프로그래머스 '카펫'
// 완전탐색
// 2021.03.03

class Solution {
    
    public int[] solution(int brown, int yellow) {
        int yellowHeight = 1, yellowWidth = yellow / yellowHeight;
        while (true) {
            int brownGuess = (yellowWidth + 2) * 2 + yellowHeight * 2;
            int yellowGuess = yellowWidth * yellowHeight;
            if (brown == brownGuess && yellowGuess == yellow)
                break;
            yellowHeight++;
            yellowWidth = yellow / yellowHeight;
        }
        return new int[]{yellowWidth + 2, yellowHeight + 2};
    }
}
