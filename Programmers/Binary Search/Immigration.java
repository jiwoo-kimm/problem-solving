import java.util.Arrays;

public class Immigration {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) n * times[times.length - 1];

        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long maxPeopleCount = getPeopleCount(mid, times);

            if (maxPeopleCount < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }

    private static long getPeopleCount(long mid, int[] times) {
        long count = 0;
        for (int time : times) count += mid / time;
        return count;
    }
}
