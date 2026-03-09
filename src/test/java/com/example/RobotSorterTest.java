package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotSorterTest {

    private final RobotSorter robotSorter = new RobotSorter();

    @Test
    public void testSortStandard() {
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(10, 10, 10, 10));
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(10, 10, 10, 19.99999));
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(10, 10, 10, 0.00001));
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(150, 10, 10, 10));
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(10, 150, 10, 10));
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(10, 10, 150, 10));
        assertEquals(RobotSorter.STACK_TYPE.STANDARD.name(), robotSorter.sort(0.00001, 0.00001, 0.00001, 0.00001));
    }

    @Test
    public void testSortSpecialBulkyVolume() {
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(1000000, 10, 10, 10));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(100, 10000, 100, 10));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(100, 10, 1000, 10));
    }

    @Test
    public void testSortSpecialBulkyDimension() {
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(151, 10, 10, 10));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(10, 151, 10, 10));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(10, 10, 151, 10));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(10, 10, 150.00001, 10));
    }

    @Test
    public void testSortSpecialHeavy() {
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(10, 10, 10, 21));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(10, 10, 10, 20.00001));
        assertEquals(RobotSorter.STACK_TYPE.SPECIAL.name(), robotSorter.sort(1, 1, 1, 50000));
    }

    @Test
    public void testSortRejected() {
        assertEquals(RobotSorter.STACK_TYPE.REJECTED.name(), robotSorter.sort(10, 10, 151, 21));
        assertEquals(RobotSorter.STACK_TYPE.REJECTED.name(), robotSorter.sort(10, 10, 100000, 21));
        assertEquals(RobotSorter.STACK_TYPE.REJECTED.name(), robotSorter.sort(10, 10, 151, 20.00001));
        assertEquals(RobotSorter.STACK_TYPE.REJECTED.name(), robotSorter.sort(10, 10, 150.00001, 21));
        assertEquals(RobotSorter.STACK_TYPE.REJECTED.name(), robotSorter.sort(100000, 100000, 10000, 50000));
        assertEquals(RobotSorter.STACK_TYPE.REJECTED.name(), robotSorter.sort(0.00001, 10000000, 151, 21));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(10, 10, 10, 0));
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(10, 10, 10, -1));
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(-10, 10, 10, 10));
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(10, -10, 10, 10));
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(10, 10, -10, 10));
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(1000, 1000, 0, 10));
        assertThrows(IllegalArgumentException.class, () -> robotSorter.sort(1000, 1000, 1000, 0));
    }
}