// LeetCode
// 448. Find All Numbers Disappeared in an Array
// 2021.06.05

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] == idx+1 || nums[nums[idx]-1] == nums[idx]) {
                idx++;
                continue;
            }
            swap(nums, idx, nums[idx]-1);
        }
        
        List<Integer> result = new ArrayList();
        for (int i=0 ; i<nums.length ; i++)
            if (nums[i] != i+1)
                result.add(i+1);
        return result;
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}