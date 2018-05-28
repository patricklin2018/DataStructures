# 排序问题

## 简单排序

| 排序算法  | 时间复杂度（一般情况下） | 最坏情况下 | 最好情况下 | 空间复杂度 | 稳定性 |
|---|---|---|---|---|---|---|---|
| 选择排序 | O(n^2) | O(n^2) | O(n^2) | O(1) | 不稳定 |
| 插入排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定 |
| 冒泡排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定 |

|  排序算法  | 备注 | 代码 |
|---|---|---|
|  选择排序 | 简单选择排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/SelectionSort.java)|
| 选择排序 2 | 同时寻找最大、最小值的索引|[Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/SelectionSort2.java)


```
Test for random array, size = 20000, random range [0, 20000]
SelectionSort : 417 ms
SelectionSort2 : 373 ms
InsertionSort : 491 ms
BubbleSort : 1899 ms
BubbleSort2 : 1727 ms

Test for ordered random array, size = 20000, random range [0, 3]
SelectionSort : 336 ms
SelectionSort2 : 572 ms
InsertionSort : 285 ms
BubbleSort : 1290 ms
BubbleSort2 : 1177 ms

Test for nearly ordered array, size = 20000, swap time = 100
SelectionSort : 490 ms
SelectionSort2 : 295 ms
InsertionSort : 251 ms
BubbleSort : 1687 ms
BubbleSort2 : 1219 ms
```



```
经过 100 组大小为 1000000 的数据测试，结果如下：
ShellSort 平均时间 = 884 ms
MergeSort 平均时间 = 304 ms
MergeSort2 平均时间 = 250 ms
MergeSort3 平均时间 = 238 ms
QuickSort 平均时间 = 227 ms
QuickSort2 平均时间 = 212 ms
QuickSort2Ways 平均时间 = 208 ms
QuickSort3Ways 平均时间 = 373 ms
```

