class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Solution {
    public void zigzagRearrange(ListNode head) {
        // If the list is empty or has only one node, it is already in zig-zag order
        if (head == null || head.next == null) return;

        // Initialize flag to true, indicating the first relation is a < b
        boolean flag = true;

        // Start from the head of the list
        ListNode current = head;

        // Traverse the list till the second last node
        while (current != null && current.next != null) {
            if (flag) { // If flag is true, current node should be less than next node
                if (current.val > current.next.val) {
                    // Swap the values if current node is greater than next node
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
            } else { // If flag is false, current node should be greater than next node
                if (current.val < current.next.val) {
                    // Swap the values if current node is less than next node
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                }
            }
            // Toggle the flag for next pair
            flag = !flag;

            // Move to the next node
            current = current.next;
        }
    }
}
