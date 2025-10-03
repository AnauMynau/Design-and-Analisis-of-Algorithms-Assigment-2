package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {

    private final PerformanceTracker tracker;

    public HeapSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] a) {
        int n = a.length;
        if (n < 2) return;

        // 1) Построение max-heap (bottom-up)
        //    идём от последнего внутреннего узла к корню
        for (int i = (n >>> 1) - 1; i >= 0; i--) {
            siftDown(a, i, n);
        }

        // 2) Извлечение max в конец и восстановление кучи на уменьшенном префиксе
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end);      // корень (макс) -> в хвост
            siftDown(a, 0, end);  // heap на диапазоне [0, end)
        }
    }

    /** Итеративный sift-down (bottom-up heapify) для max-heap на диапазоне [0, size). */
    private void siftDown(int[] a, int root, int size) {
        int value = a[root]; // «пузырёк», который проталкиваем вниз
        while (true) {
            int left = (root << 1) + 1; // левый ребёнок
            if (left >= size) break;

            int right = left + 1;
            int child = left;

            // выбираем большего ребёнка
            tracker.addComparison();
            if (right < size && a[right] > a[left]) {
                child = right;
            }

            tracker.addComparison();
            if (a[child] <= value) {
                // value уже не меньше потомков — на место
                break;
            }

            // сдвигаем большего ребёнка вверх
            a[root] = a[child];
            root = child;
        }
        a[root] = value;
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) return;
        tracker.addSwap();
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
