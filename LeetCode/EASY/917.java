// LeetCode
// 917. Reverse Only Letters
// 2021.09.15

import java.util.*;

class Solution {
    
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        
        if (n < 2) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = arr.length - 1;
        
        while (true) {
            while (left < n && !Character.isAlphabetic(arr[left])) {
                left++;
            }
            
            while (right >= 0 && !Character.isAlphabetic(arr[right])) {
                right--;
            }
            
            if (left >= right || left >= n || right < 0) {
                break;
            }
            
            swap(arr, left, right);
            left++;
            right--;
        }
        
        return String.valueOf(arr);
    }
    
    private void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}