public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;

        // Calculate the length of the linked list
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int k = length - n;

        // If removing the first node
        if (k == 0) {
            return head.next;
        }

        ListNode curr = head;

        // Move to the node just before the one to be removed
        for (int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }

        // Remove the Nth node
        curr.next = curr.next.next;

        return head;
    }
}