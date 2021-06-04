// LeetCode
// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
// 2021.06.04

class Solution {
    
    private static final int MOD = 1000000007;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxHorizontalGap = findMaxGap(h, horizontalCuts);
        long maxVerticalGap = findMaxGap(w, verticalCuts);
        return (int) (maxHorizontalGap * maxVerticalGap % MOD);
    }
    
    private long findMaxGap(int size, int[] cuts) {
        Arrays.sort(cuts);
        long max = cuts[0];
        for (int i=1 ; i<cuts.length ; i++)
            max = Math.max(max, cuts[i] - cuts[i-1]);
        return Math.max(max, size-cuts[cuts.length-1]);
    }
}