// LeetCode
// 154. Find Minimum in Rotated Sorted Array II
// 2021.05.25

// Linear Search
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

// Binary Search
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1, mid;
	    while (left < right) {
		    if (nums[left] < nums[right]) return nums[left];
            mid = (left + right) / 2;
		    if (nums[mid] < nums[right]) right = mid;
		    else if (nums[mid] > nums[right]) left = mid+1;
		    else left++;
	    }
	    return nums[left];
    }
}