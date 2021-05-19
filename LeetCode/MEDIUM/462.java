// LeetCode
// 462. Minimum Moves to Equal Array Elements II
// 2021.05.19

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int answer = 0;
        for (int num : nums)
            answer += Math.abs(mid - num);
        return answer;
    }
}