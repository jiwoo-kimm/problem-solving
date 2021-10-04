// LeetCode
// 287. Find the Duplicate Number
// 2021.10.04

class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        
        for (int num : nums) {
            if (used[num]) {
                return num;
            }
            used[num] = true;
        }
        
        return -1;
    }
}