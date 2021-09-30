// LeetCode
// 725. Split Linked List in Parts
// 2021.09.30

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        
        int partSize = (size < k) ? 1 : size / k;
        int addCount = (size < k) ? 0 : size % k;
        
        ListNode[] answer = new ListNode[k];
        
        for (int i=0 ; i<k ; i++) {
            if (head == null) {
                break;
            }
            
            ListNode node = new ListNode(head.val);
            answer[i] = node;
            head = head.next;
            
            for (int j=1 ; j<partSize ; j++) {
                if (head == null) {
                    continue;
                }
                node.next = new ListNode(head.val);
                node = node.next;
                head = head.next;
            }
            
            if (addCount > 0 && head != null) {
                node.next = new ListNode(head.val);
                head = head.next;
                addCount--;
            }
        }
        
        return answer;
    }
}