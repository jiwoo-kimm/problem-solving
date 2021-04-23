// 프로그래머스 '입국심사'
// 이분탐색
// 2021.01.13, 2021.04.23

class Solution {
    
    private static final long MAX_PEOPLE = 1000000000;
    private static final long MAX_TIME = 1000000000;
    private static final long MAX_TOTAL = MAX_PEOPLE * MAX_TIME;
    
    private int n;
    private int[] times;
    
    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;
        
        long left = 1, right = MAX_TOTAL, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (isAvailable(mid)) right = mid;
            else left = mid + 1;
        }
        return (left + right) / 2;
    }
    
    private boolean isAvailable(long totalTime) {
        long finished = 0;
        for (int time : times) finished += totalTime / time;
        return finished >= n;
    }
}