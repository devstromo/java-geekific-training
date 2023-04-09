package cycle_detection;

public class CycleDetection {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast)
            return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
