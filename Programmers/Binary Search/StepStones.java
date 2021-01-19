// 프로그래머스 '징검다리'
// 이분탐색
// 2021.01.19

import java.util.Arrays;

public class StepStones {

    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    private static int MIN_DISTANCE = 1;
    private static int MAX_DISTANCE = 1000000000;

    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = MIN_DISTANCE;
        int right = MAX_DISTANCE;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isAvailable(distance, rocks, n, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static boolean isAvailable(int distance, int[] rocks, int n, int target) {
        int removalCount = 0;
        int previous = 0;
        for (int rock : rocks)
            if (rock - previous < target) removalCount++;
            else previous = rock;
        if (distance - previous < target) removalCount++;
        return removalCount <= n;
    }
}