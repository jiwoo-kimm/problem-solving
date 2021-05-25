// LeetCode
// 154. Find Minimum in Rotated Sorted Array II
// 2021.05.25

class Solution {
    public int findMin(int[] nums) {
        int k = 0;
        int before, current;
        for (int i=1 ; i<nums.length ; i++) {
            before = nums[i-1];
            current = nums[i];
            if (before > current) {
                k = i;
                break;
            }
        }
        return Math.min(nums[0], nums[k]);

    }
}