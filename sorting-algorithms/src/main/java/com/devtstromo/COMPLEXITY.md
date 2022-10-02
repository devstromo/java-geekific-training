# COMPLEXITY

### BUBBLE SORT

No practical use

- Best: Ω(n<sup>2</sup>)
- Average: Θ(n<sup>2</sup>)
- Worst: O(n<sup>2</sup>)
- Space Complexity: O(1)
- Stability: Yes

### SELECTION SORT

Efficient on small data chunks but bat on large number of data Used when write performance is a limit factor

- Best: Ω(n<sup>2</sup>)
- Average: Θ(n<sup>2</sup>)
- Worst: O(n<sup>2</sup>)
- Space Complexity:  O(1)
- Stability: No

### INSERTION SORT

Efficient on small data chunks but bat on large number of data Good performance on almost-sorted data

- Best: Ω(n)
- Average: Θ(n<sup>2</sup>)
- Worst: O(n<sup>2</sup>)
- Space Complexity: O(1)
- Stability: Yes

### SHELL SORT

Improved version of insertion sort. O(n*m) where _n_ are the items in the array and _m_ is the greatest distance between two out-of-place-elements(_m_ = _n_).
Improves on insertion sort by trying to minimize this distance as much as possible.

- Best: Ω(n*log n)
- Average: Θ(n*log n)
- Worst: O(n<sup>2</sup>)
- Space Complexity: O(1)
- Stability: No

### MERGE SORT

Not in-place algorithm(creates an additional temp array)

- Best: Ω(n*log n)
- Average: Θ(n*log n)
- Worst: O(n*log n)
- Space Complexity: O(n)
- Stability: Yes

### QUICK SORT

In-place algorithm. k = log(n) recursive calls stored in the stack memory

- Best: Ω(n*log n)
- Average: Θ(n*log n)
- Worst: O(n*log n) → with bad pivot selection the worst case is **O(n<sup>2</sup>)**
- Space Complexity: O(log n)
- Stability: No

### TIM SORT

- Best: Ω(n)
- Average: Θ(n*log n)
- Worst: O(n*log n)
- Space Complexity: O(n)
- Stability: Yes

### COUNTING SORT

Counting sort is used when: (1)there are smaller integers with multiple counts, (2)linear complexity is the need.

- Best: Ω(n+k)
- Average: Θ(n+k)
- Worst: O(n+k)
- Space Complexity: O(k)
- Stability: Yes

### RADIX SORT

- Best: Ω(n+k)
- Average: Θ(n+k)
- Worst: O(n+k)
- Space Complexity: O(n+k)
- Stability: Yes

### BUCKET SORT

- Best: Ω(n+k)
- Average: Θ(n)
- Worst: O(n<sup>2</sup>)
- Space Complexity: O(n+k)
- Stability: Yes

