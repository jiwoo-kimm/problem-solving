// 프로그래머스 정렬
// 가장 큰 수
// 2021.03.17

import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        String[] numberStrings = parseIntoString(numbers);
        Arrays.sort(numberStrings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (numberStrings[0].equals("0")) return "0";
        return buildAnswer(numberStrings);
    }

    private String[] parseIntoString(int[] numbers) {
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) result[i] = String.valueOf(numbers[i]);
        return result;
    }

    private String buildAnswer(String[] numberStrings) {
        StringBuilder answer = new StringBuilder();
        for (String number : numberStrings) answer.append(number);
        return answer.toString();
    }
}