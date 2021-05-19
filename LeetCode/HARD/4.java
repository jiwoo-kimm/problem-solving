// LeetCode
// 4. Median of Two Sorted Arrays
// 2021.05.19

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int[] merged = new int[m+n];
        int idx1 = 0, idx2 = 0, mergedIdx = 0;
        
        while (idx1 < m && idx2 < n)
            if (nums1[idx1] <= nums2[idx2])
                merged[mergedIdx++] = nums1[idx1++];
            else
                merged[mergedIdx++] = nums2[idx2++];
        
        while (idx1 < m)
            merged[mergedIdx++] = nums1[idx1++];
        while (idx2 < n)
            merged[mergedIdx++] = nums2[idx2++];
        
        if (merged.length % 2 == 0)
            return ((double) merged[merged.length / 2 - 1] + merged[merged.length/2]) / 2;
        else
            return merged[merged.length / 2];
    }
}