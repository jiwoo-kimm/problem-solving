// LeetCode
// 23. Merge k Sorted Lists
// 2021.05.19

class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode answer = null;
        
        int idx = 0;
        while (idx < k)
            answer = merge(answer, lists[idx++]);
        
        return answer;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
    
        if (left == null) return right;
        if (right == null) return left;
        
        ListNode merged = null;
        if (left.val <= right.val) {
            merged = left;
            left = left.next;
        } else {
            merged = right;
            right = right.next;
        }
        
        ListNode current = merged;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        if (left != null) current.next = left;
        if (right != null) current.next = right;
        
        return merged;
    }
}