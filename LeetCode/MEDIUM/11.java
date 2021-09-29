// LeetCode
// 11. Container With Most Water
// 2021.09.30

class Solution {
    public int maxArea(int[] heights) {
        int answer = 0;
        
        int left = 0;
        int right = heights.length - 1;
        
        while (left <= right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            answer = Math.max(answer, area);
            
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }        
        
        return answer;
    }
}