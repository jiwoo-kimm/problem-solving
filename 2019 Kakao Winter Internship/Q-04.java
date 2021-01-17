public class SteppingStone {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 200000000;

    public static int solution(int[] stones, int k) {

        int left = MIN_COUNT;
        int right = MAX_COUNT;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (available(mid, stones, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static boolean available(int count, int[] stones, int k) {
        int jumpCount = 0;
        for (int i = 0; i < stones.length && jumpCount < k; i++)
            if (stones[i] - count < 0) jumpCount++;
            else jumpCount = 0;
        return jumpCount < k;
    }
}
