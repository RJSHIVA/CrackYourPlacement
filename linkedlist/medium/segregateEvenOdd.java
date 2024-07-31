class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Solution {
    public ListNode segregateEvenOdd(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // Pointers for the even and odd lists
        ListNode evenHead = null, evenTail = null;
        ListNode oddHead = null, oddTail = null;
        
        // Traverse the original list and separate nodes into even and odd lists
        ListNode current = head;
        while (current != null) {
            if (current.val % 2 == 0) { // Even node
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else { // Odd node
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }
            current = current.next;
        }
        
        // End the odd list
        if (oddTail != null) {
            oddTail.next = null;
        }
        
        // If there are no even nodes, return the odd list
        if (evenHead == null) {
            return oddHead;
        }
        
        // Concatenate even list with odd list
        evenTail.next = oddHead;
        
        return evenHead;
    }
}
