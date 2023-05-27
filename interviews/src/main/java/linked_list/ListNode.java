package linked_list;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int val() {
        return val;
    }

    public ListNode next() {
        return next;
    }
}
