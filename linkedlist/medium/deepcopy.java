public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }

    Map<Node, Node> map = new HashMap<>();
    Node curr = head;
    Node newHead = null;
    Node prev = null;

    // First pass: Create all nodes and store in map
    while (curr != null) {
        Node temp = new Node(curr.val);
        map.put(curr, temp);
        if (newHead == null) {
            newHead = temp;
            prev = newHead;
        } else {
            prev.next = temp;
            prev = temp;
        }
        curr = curr.next;
    }

    // Second pass: Assign next and random pointers
    curr = head;
    Node newCurr = newHead;
    while (curr != null) {
        newCurr.random = (curr.random == null) ? null : map.get(curr.random);
        newCurr = newCurr.next;
        curr = curr.next;
    }

    return newHead;
}