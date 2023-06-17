package linked_list.sentinelNode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
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
