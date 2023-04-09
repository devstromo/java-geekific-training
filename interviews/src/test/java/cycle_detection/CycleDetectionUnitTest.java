package cycle_detection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CycleDetectionUnitTest {

    private ListNode noCycleList;
    private ListNode cycleList;

    @BeforeEach
    public void setUp() {
        // Create a no-cycle list: 1 -> 2 -> 3 -> 4 -> 5
        noCycleList = new ListNode(new ListNode(new ListNode(new ListNode(new ListNode(null)))));

        // Create a cycle list: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (cycle at node with value 3)
        ListNode cycleNode = new ListNode(new ListNode(new ListNode(null)));
        cycleList = new ListNode(cycleNode);
        cycleNode.next.next.next = cycleNode;
    }

    @Test
    public void testHasCycle() {
        assertFalse(CycleDetection.hasCycle(noCycleList));
        assertTrue(CycleDetection.hasCycle(cycleList));
    }

    @Test
    public void testDetectCycle() {
        assertNull(CycleDetection.detectCycle(noCycleList));
        assertEquals(cycleList.next, CycleDetection.detectCycle(cycleList));
    }

    @Test
    public void testEmptyList() {
        ListNode emptyList = null;
        assertFalse(CycleDetection.hasCycle(emptyList));
        assertNull(CycleDetection.detectCycle(emptyList));
    }

    @Test
    public void testSingleNodeList() {
        ListNode singleNodeList = new ListNode(null);
        assertFalse(CycleDetection.hasCycle(singleNodeList));
        assertNull(CycleDetection.detectCycle(singleNodeList));
    }
}