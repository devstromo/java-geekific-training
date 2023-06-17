package linked_list.sentinelNode;

class SentinelNode {
    public ListNode partition(ListNode head, int x) {
        var headLow = getFirstNodeSmallerThanX(head, x);
        var headHigh = getFirstNodeEqualsOrBiggerThanX(head, x);

        var currentLow = headLow;
        var currentHigh = headHigh;

        while (head != null) {
            if (head.val() < x && head != headLow) {
                currentLow.next = head;
                currentLow = currentLow.next();
            } else if (head.val >= x && head != headHigh) {
                currentHigh.next = head;
                currentHigh = currentHigh.next();
            }
            head = head.next();
        }

        if (currentLow != null)
            currentLow.next = headHigh;
        if (currentHigh != null)
            currentHigh.next = null;
        return headLow != null ? headLow : headHigh;
    }

    public ListNode partitionWithSentinelNode(ListNode head, int x) {
        var sentinelLow = new ListNode();
        var sentinelHigh = new ListNode();

        var currentLow = sentinelLow;
        var currentHigh = sentinelHigh;

        while (head != null) {
            if (head.val() < x) {
                currentLow.next = head;
                currentLow = currentLow.next();
            } else if (head.val >= x) {
                currentHigh.next = head;
                currentHigh = currentHigh.next();
            }
            head = head.next();
        }

        currentLow.next = sentinelHigh.next();
        currentHigh.next = null;
        return sentinelLow.next();
    }

    public ListNode getFirstNodeEqualsOrBiggerThanX(ListNode head, int x) {
        while (head != null) {
            if (head.val() >= x) {
                return head;
            }
            head = head.next();
        }
        return null;
    }

    public ListNode getFirstNodeSmallerThanX(ListNode head, int x) {
        while (head != null) {
            if (head.val() < x) {
                return head;
            }
            head = head.next();
        }
        return null;
    }
}
