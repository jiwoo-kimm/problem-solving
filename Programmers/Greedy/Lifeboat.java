// 프로그래머스 Greedy
// 구명보트
// 2021.03.31

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0, right = people.length - 1;
        while (left < right) {
            answer++;
            int onboardWeight = people[right--];
            if (left < right && onboardWeight + people[left] <= limit) left++;
            if (left < right && people[right] <= limit / 2) break;
        }
        int remaining = right - left + 1;
        return answer + (remaining % 2 == 0 ? remaining / 2 : remaining / 2 + 1);
    }
}