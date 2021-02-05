// 프로그래머스 스택/큐
// 주식가격
// 2021.02.05


import java.util.Arrays;

public class Stock {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) break;
            }
        }
        return answer;
    }
}
