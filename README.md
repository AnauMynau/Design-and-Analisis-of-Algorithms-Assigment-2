# Assignment 2 — Heap Sort (Bridge Project)

### Course: Design and Analysis of Algorithms  
**Student B:** Heap Sort (In-place, Bottom-up Heapify)  
**Language:** Java  
**Build Tool:** Maven

---

## 📘 Overview
This project implements the **Heap Sort** algorithm with bottom-up heap construction and in-place sorting.  
The implementation includes performance tracking and benchmarking tools that measure the algorithm’s efficiency on arrays of various sizes.

The project is part of a pair assignment:
- **Student A:** Shell Sort  
- **Student B (this project):** Heap Sort  

---

## 📂 Project Structure
assignment-2-Heap-Sort/

├── src/
│ ├── main/java/
│ │ ├── algorithms/HeapSort.java
│ │ ├── metrics/PerformanceTracker.java
│ │ └── cli/BenchmarkRunner.java
│ └── test/java/
│ └── algorithms/HeapSortTest.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance-plots/
│ └── heap_benchmark.csv
├── pom.xml
└── README.md



---

## ⚙️ Implementation Details

**HeapSort.java**
- Implements in-place **Heap Sort** with bottom-up heapify.
- Counts comparisons and swaps using the `PerformanceTracker`.
- Uses an iterative (non-recursive) `siftDown` for efficiency.

**PerformanceTracker.java**
- Tracks the number of comparisons and swaps.
- Provides a simple API for performance analysis.

**BenchmarkRunner.java**
- Generates random input arrays for sizes 100, 1,000, 10,000, and 100,000.
- Measures execution time and algorithmic operations.
- Saves results automatically to `docs/performance-plots/heap_benchmark.csv`.

**HeapSortTest.java**
- Unit tests covering:
  - Empty arrays
  - Single-element arrays
  - Sorted and reverse-sorted arrays
  - Arrays with duplicates

---

## 🚀 How to Run

### ▶ Run in IntelliJ IDEA
- Open the project as a Maven project.
- Right-click on `BenchmarkRunner.java` → **Run 'BenchmarkRunner.main()'**

### 💻 Run via terminal
bash
mvn compile
mvn exec:java -Dexec.mainClass=cli.BenchmarkRunner



📊 Benchmark Results

After running, results are stored in:
docs/performance-plots/heap_benchmark.csv

Example:

| Size (n) | Time (ms) | Comparisons | Swaps | Correctly Sorted |
|-----------|------------|-------------|--------|------------------|
| 100       | 1          | 545         | 210    | true             |
| 1,000     | 8          | 15,175      | 6,982  | true             |
| 10,000    | 72         | 184,125     | 87,534 | true             |
| 100,000   | 830        | 2,471,330   | 1,045,852 | true          |


### Theoretical Complexity
| Case         |  Time Complexity |	Explanation |
|--------------|------------------|----------------------------------------------------------------------------------|
| Best Case	   |  O(n log n)	    |  Even if the array is nearly sorted, heapify still dominates.                    |
| Average Case |  O(n log n)	    |  For random data, heap property maintenance gives log n depth per n elements.    |
| Worst Case	 |  O(n log n)	    |  The heap must be fully restructured for every extracted element.                |
| Space	       |  O(1)	          |  In-place sorting.

<img width="751" height="452" alt="image" src="https://github.com/user-attachments/assets/1a5ae6ca-5571-47c3-b20a-e370724dc584" />


🧩 Optimization Ideas

Use bottom-up heapify (already implemented).

Reduce unnecessary swaps by using value shifting instead of temporary variables.

Skip sorting when the array is already sorted.



🧪 Testing

Run all unit tests:
mvn test


All tests are located in:
src/test/java/algorithms/HeapSortTest.java


🧾 Deliverables

✅ HeapSort implementation (feature/algorithm)

✅ Metrics tracking (feature/metrics)

✅ CLI benchmark (feature/cli)

✅ Unit tests (feature/testing)

✅ Report & performance plots (docs/)

🏁 Conclusion

This project successfully demonstrates the Heap Sort algorithm with clear performance tracking and benchmarking.
The implementation follows clean code principles and fulfills all academic requirements for Assignment 2.

Author: Inayatulla
