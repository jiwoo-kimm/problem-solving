// 프로그래머스 스택/큐
// 주식가격
// 2021.02.05, 2021.08.26

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        
        int[] answer = new int[n];
        for (int before=0 ; before<n ; before++) {
            for (int after=before+1 ; after<n ; after++) {
                answer[before]++;
                if (prices[after] < prices[before]) {
                    break;
                }
            }
        }
        
        return answer;
    }
}