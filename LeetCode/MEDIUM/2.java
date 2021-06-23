// LeetCode
// 2. Add Two Numbers
// 2021.06.24

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = null, before = null, digit;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            if (sum > 9) {
                digit = new ListNode(sum - 10);
                carry = 1;
            } else {
                digit = new ListNode(sum);
                carry = 0;
            }
            
            
            if (before != null) {
                before.next = digit;
            }
            before = digit;
            
            if (answer == null) {
                answer = before;
            }
        }
        
        if (carry == 1) {
            before.next = new ListNode(carry);
        }
        
        return answer;
    }
}