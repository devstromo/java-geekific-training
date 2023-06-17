package linked_list.reverseInKGroups;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseInKGroupsUnitTest {
    ReverseInKGroups reverseInKGroups = new ReverseInKGroups();
    ListNode head;
    ListNode expected;

    @BeforeEach
    void setUp() {
        head = new ListNode(4, new ListNode(7, new ListNode(3, new ListNode(9, new ListNode(8, new ListNode(2, new ListNode(5, null)))))));
        expected = new ListNode(5, new ListNode(2, new ListNode(8, new ListNode(9, new ListNode(3, new ListNode(7, new ListNode(4, null)))))));
    }

    @Test
    void testBruteForce() {
        var cursorResult = reverseInKGroups.reverseListBruteForce(head);
        var cursorExpected = expected;
        while (cursorExpected != null) {
            assertNotNull(cursorResult);
            assertEquals(cursorExpected.val, cursorResult.val);
            cursorResult = cursorResult.next;
            cursorExpected = cursorExpected.next;
        }
    }

    @Test
    void testStack() {
        var cursorResult = reverseInKGroups.reverseListStack(head);
        var cursorExpected = expected;
        while (cursorExpected != null) {
            assertNotNull(cursorResult);
            assertEquals(cursorExpected.val, cursorResult.val);
            cursorResult = cursorResult.next;
            cursorExpected = cursorExpected.next;
        }
    }

    @Test
    void testReverseList() {
        var cursorResult = reverseInKGroups.reverseList(head);
        var cursorExpected = expected;
        while (cursorExpected != null) {
            assertNotNull(cursorResult);
            assertEquals(cursorExpected.val, cursorResult.val);
            cursorResult = cursorResult.next;
            cursorExpected = cursorExpected.next;
        }
    }
}