// LeetCode
// 978. Longest Turbulent Subarray
// 2021.09.16

class Solution {
    
    private static final int UP = 0;    
    private static final int DOWN = 1;
    
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        
        int down = 1;
        int up = 1;
        int max = 1;
        
        for (int i=1 ; i<n ; i++) {
            if (arr[i] > arr[i-1]) {
                up = down + 1;
                down = 1;
                max = Math.max(max, up);
            } else if (arr[i] < arr[i-1]) {
                down = up + 1;
                up = 1;
                max = Math.max(max, down);
            } else {
                down = 1;
                up = 1;
            }
        }
        
        return max;
    }
}