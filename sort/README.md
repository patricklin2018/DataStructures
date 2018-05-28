# 排序问题

## 简单排序

#### 简介
| 排序算法  | 时间复杂度（一般情况下） | 最坏情况下 | 最好情况下 | 空间复杂度 | 稳定性 |
|---|---|---|---|---|---|
| 选择排序 | O(n^2) | O(n^2) | O(n^2) | O(1) | 不稳定 |
| 插入排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定 |
| 冒泡排序 | O(n^2) | O(n^2) | O(n) | O(1) | 稳定 |

#### 实现
|  排序算法  | 备注 | 代码 |
|---|---|---|
|  SelectionSort | 选择排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/SelectionSort.java)|
| SelectionSort2 | 同时寻找最大、最小值的索引|[Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/SelectionSort2.java)|
| InsertionSort | 插入排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/InsertionSort.java)|
| BubbleSort | 冒泡排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/BubbleSort.java) |
| BubbleSort2 | 记录上一次冒泡终止位置，下一轮对其之后元素进行忽略 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/BubbleSort2.java)|

#### 实验

基础排序算法的时间效率比较: [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/BasicSortTest.java)

结果如下：
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

## 高级排序

#### 简介
| 排序算法  | 时间复杂度（一般情况下） | 最坏情况下 | 最好情况下 | 空间复杂度 | 稳定性 |
|---|---|---|---|---|---|
| 希尔排序 | O(nlogn) | O(n^2) | O(n) | O(1) | 不稳定 |
| 归并排序 | O(nlogn) | O(nlogn) | O(nlogn) | O(n) | 稳定 |
| 快速排序 | O(nlogn) | O(n^2) | O(nlogn) | O(nlogn) | 不稳定 |

#### 实现
|  排序算法  | 备注 | 代码 |
|---|---|---|
|  ShellSort | 希尔排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/ShellSort.java)|
| MergeSort | 归并排序 |[Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/MergeSort.java)|
| MergeSort2 | 1,小规模数据直接插入排序 2,省略部分 merge 计算 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/MergeSort2.java)|
| MergeSort3 | 辅助空间统一申请 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/MergeSort3.java) |
| QuickSort | 快速排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort.java)|
| QuickSort2 | 1,小规模数据直接插入排序 2,partition标定采用随机策略，增强稳定性 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort2.java)|
| QuickSort2Ways | 二路快速排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort2Ways.java)|
| QuickSort3Ways | 三路快速排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort3Ways.java)|

#### 实验

高级排序算法的时间效率比较: [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/AdvancedSortTest.java)

结果如下：
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

