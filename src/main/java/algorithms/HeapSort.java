package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {

    private final PerformanceTracker tracker;

    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }



    //
    public void sort(int[] arr) {
        int n = arr.length;
        if (n < 2) return;

        // 1) Построение max-heap (bottom-up)
        //    идём от последнего внутреннего узла к корню
        for (int i = (n >>> 1) - 1; i >= 0; i--) {
            siftDown(arr, i, n);
        }

        // 2) Извлечение max в конец и восстановление кучи на уменьшенном префиксе
        for (int end = n - 1; end > 0; end--) {
            swap(arr, 0, end);
            siftDown(arr, 0, end);
        }
    }

    /** Итеративный sift-down (bottom-up heapify) для max-heap на диапазоне [0, size). */
    public void siftDown(int[] arr, int root, int size) {
        int value = arr[root];
        while (true) {
            int left = (root << 1) + 1;  // левый chilf
            if (left >= size) break;

            int right = left + 1;
            int child = left;

            //выбираем большего child
            tracker.addComparison();
            if (right < size && arr[right] > arr[left]) {
                child = right;
            }

            tracker.addComparison();
            // value уже не меньше потомков — на место
            if (arr[child] <= value) break;

            // сдвигаем большего child вверх
            arr[root] = arr[child];
            root = child;
        }
        arr[root] = value;

    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        tracker.addSwap();
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
