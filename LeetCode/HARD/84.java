// LeetCode
// 84. Largest Rectangle in Histogram
// 2021.06.05

class Solution {
    public int largestRectangleArea(int[] heights) {

        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        for (int i=0 ; i<heights.length ; i++) {
            int l = i-1;
            while (l >= 0 && heights[l] >= heights[i])
                    l = left[l];
            left[i] = l;
        }
        
        for (int i=heights.length-1 ; i>=0 ; i--) {
            int r = i+1;
            while (r < heights.length && heights[r] >= heights[i])
                    r = right[r];
            right[i] = r;
        }
        
        int max = 0;
        for (int i=0 ; i<heights.length ; i++)
            max = Math.max(max, (right[i]-left[i]-1) * heights[i]);
        return max;
    }
}