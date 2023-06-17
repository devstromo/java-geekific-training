package linked_list.reverseInKGroups;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class ReverseInKGroups {
    public ListNode reverseListBruteForce(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = getLastNode(head);
        ListNode current = newHead;
        while (current != null && head.next != null) {
            current.next = getLastNode(head);
            current = current.next;
        }
        current.next = head;
        return newHead;
    }

    public ListNode reverseListStack(ListNode head) {
        if (head == null)
            return head;
        var stack = new LinkedList<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        var current = head;
        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        var current = head;
        ListNode prev = null;
        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseListBetween(ListNode head, int left, int right) {
        if (head == null)
            return head;
        ListNode current = head, prev = null;
        while (left > 1) {
            prev = current;
            current = current.next;
            left--;
            right--;
        }
        var lastNodeBeforeReverse = prev;
        var tail = current;
        while (right > 0) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            right--;
        }
        // points to the last node before reverse()head of reversed list
        if (lastNodeBeforeReverse != null)
            lastNodeBeforeReverse.next = prev;
        else
            head = prev;
        // points to the first node that should come after the reversed sub-list
        tail.next = current;
        return head;
    }

    public ListNode reverseListKGroups(ListNode head, int k) {
        if (head == null || k <= 1 || head.next == null)
            return head;

        int count = 0;
        var curr = head;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count != k) {
            return head;
        }

        var tail = head;
        var current = head;
        for (int i = 0; i < k && current != null; i++) {
            var temp = current.next;
            current.next = head;
            head = current;
            current = temp;
        }
        tail.next = current != null ? reverseListKGroups(current, k) : null;
        return head;
    }

    private ListNode getLastNode(ListNode head) {
        if (head.next == null)
            return head;
        while (head.next.next != null)
            head = head.next;
        ListNode tmp = head.next;
        head.next = null;
        return tmp;
    }

}
