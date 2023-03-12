package container_most_water;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    @Test
    public void testMaxArea() {
        var heights = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        assertEquals(49, ContainerWithMostWater.maxArea(heights));
    }

}