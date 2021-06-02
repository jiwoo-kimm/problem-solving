// LeetCode
// 1262. Greatest Sum Divisible by Three
// 2021.06.02

class Solution {
    
    private static final int INF = Integer.MAX_VALUE;
    
    public int maxSumDivThree(int[] nums) {
        
        int[] minOnes = {INF, INF};
        int[] minTwos = {INF, INF};

        int sum = 0, rest = 0;
        for (int num : nums) {
            sum += num;
            
            if (num % 3 == 0) continue;
            
            if (num % 3 == 1) update(minOnes, num);
            if (num % 3 == 2) update(minTwos, num);
            
            rest += num;
        }
        
        if (rest % 3 == 0) return sum;
        
        int removal = INF;
        
        if (rest % 3 == 1) {
            if (minOnes[0] != INF) removal = Math.min(removal, minOnes[0]);
            if (minTwos[1] != INF) removal = Math.min(removal, minTwos[0] + minTwos[1]);
        }
        
        if (rest % 3 == 2) {
            if (minTwos[0] != INF) removal = Math.min(removal, minTwos[0]);
            if (minOnes[1] != INF) removal = Math.min(removal, minOnes[0] + minOnes[1]);
        }
        
        return sum - removal;
    }
    
    private void update(int[] mins, int num) {
        if (mins[0] == INF) {
            mins[0] = num;
            return;
        }
        
        if (mins[0] > num) {
            mins[1] = mins[0];
            mins[0] = num;
            return;
        }
        
        if (mins[1] == INF || mins[1] > num) {
            mins[1] = num;
            return;
        }
    }
}