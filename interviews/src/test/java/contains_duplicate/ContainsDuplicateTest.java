package contains_duplicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ContainsDuplicateTest {

    @Test
    public void simpleContainsDuplicate() {
        assertTrue(ContainsDuplicate.containsDuplicate(new int[] { 12, 15, 13, 1, 2, 9, 78, 14, 1 }));
    }

    @Test
    public void simpleNotContainsDuplicate() {
        assertFalse(ContainsDuplicate.containsDuplicate(new int[] { 12, 15, 13, 1, 2, 9, 78, 14 }));
    }

    @Test
    public void simpleContainsDuplicates() {
        assertTrue(ContainsDuplicate.containsDuplicates(new int[] { 12, 15, 13, 1, 2, 9, 78, 14, 1 }));
    }

    @Test
    public void simpleNotContainsDuplicates() {
        assertFalse(ContainsDuplicate.containsDuplicates(new int[] { 12, 15, 13, 1, 2, 9, 78, 14 }));
    }

    @Test
    public void simpleContainsDuplicatesRange() {
        assertTrue(ContainsDuplicate.containsDuplicates(new int[] { 12, 15, 13, 1, 2, 1, 78, 14, 1 }, 3));
    }

    @Test
    public void simpleNotContainsDuplicatesRange() {
        assertFalse(ContainsDuplicate.containsDuplicates(new int[] { 12, 15, 13, 1, 2, 9, 78, 14 }, 3));
    }
}