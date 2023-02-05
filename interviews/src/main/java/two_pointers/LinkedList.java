package two_pointers;

public class LinkedList {
    Node head;

    public LinkedList(Node head) {
        this.head = head;
    }

    public Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext()
              .getNext();
        }
        return slow;
    }
}
