// LeetCode
// 75. Sort Colors
// 2021.09.15

class Solution {
    public void sortColors(int[] arr) {
        int zero = -1;
        int two = arr.length;
        
        for (int num : arr) {
            if (num == 0) {
                zero++;
            } else if (num == 2) {
                two--;
            }
        }
        
        for (int i=0 ; i<=zero ; i++) {
            arr[i] = 0;
        }
        
        for (int i=zero+1 ; i<two ; i++) {
            arr[i] = 1;
        }
        
        for (int i=two ; i<arr.length ; i++) {
            arr[i] = 2;
        }
    }
}