package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(size);
            }

            PerformanceTracker tracker = new PerformanceTracker();
            HeapSort heapSort = new HeapSort(tracker);

            long start = System.nanoTime();
            heapSort.sort(arr);
            long end = System.nanoTime();

            System.out.println("Size: " + size);
            System.out.println("Time(ms): " + (end - start) / 1_000_000);
            System.out.println("Comparisons: " + tracker.getComparisons());
            System.out.println("Swaps: " + tracker.getSwaps());
            System.out.println("Correctly sorted: " + isSorted(arr));

            System.out.println("------");
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

}
