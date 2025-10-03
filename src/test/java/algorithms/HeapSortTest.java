package algorithms;


import metrics.PerformanceTracker;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HeapSortTest {

    @Test
    public void testEmptyArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        int[] arr = {22};
        sorter.sort(arr);
        assertArrayEquals(new int[]{22}, arr);
    }

    @Test
    public void testSortedArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testRandomArray() {
        PerformanceTracker tracker = new PerformanceTracker();
        HeapSort sorter = new HeapSort(tracker);
        int[] arr = {3, 1, 4, 1, 5, 9, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5, 9}, arr);
    }


}
