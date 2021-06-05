// LeetCode
// 41. First Missing Positive
// 2021.06.05

class Solution {
    public int firstMissingPositive(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index + 1 || nums[index] <= 0 || nums[index] > nums.length || nums[nums[index] - 1] == nums[index]) {
                index++;
            } else {
                swap(nums, index, nums[index] - 1);
            }
        }
        
        index = 0;
        while(index < nums.length && nums[index] == index+1) index++;
        return index+1;
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}