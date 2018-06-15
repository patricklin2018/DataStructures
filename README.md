# DataStructures

### 问题分类链接

| 问题  | 链接 |
|---|---|
|  排序 | [Sort](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/sort) |
|  堆 | [Heap](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap) |
|  二分搜索树 | [Binary-Search-Tree](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/binary-search-tree) |
|  并查集 | [Union-Find](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/union-find) |
|  图 | [Graph](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/graph) |

### 具体问题：

#### 1. 排序

##### 1.1 基础排序(时间复杂度 = O(n^2))

|  问题  | 备注 | 代码 |
|---|---|---|
|  SelectionSort | 选择排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/SelectionSort.java)|
| SelectionSort2 | 同时寻找最大、最小值的索引|[Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/SelectionSort2.java)|
| InsertionSort | 插入排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/InsertionSort.java)|
| BubbleSort | 冒泡排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/BubbleSort.java) |
| BubbleSort2 | 记录上一次冒泡终止位置，下一轮对其之后元素进行忽略 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/BubbleSort2.java)|

##### 1.1 高级排序(时间复杂度 = O(nlogn))

|  问题  | 备注 | 代码 |
|---|---|---|
|  ShellSort | 希尔排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/ShellSort.java)|
| MergeSort | 归并排序 |[Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/MergeSort.java)|
| MergeSort2 | 1,小规模数据直接插入排序 2,省略部分 merge 计算 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/MergeSort2.java)|
| MergeSort3 | 辅助空间统一申请 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/MergeSort3.java) |
| QuickSort | 快速排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort.java)|
| QuickSort2 | 1,小规模数据直接插入排序 2,partition标定采用随机策略，增强稳定性 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort2.java)|
| QuickSort2Ways | 二路快速排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort2Ways.java)|
| QuickSort3Ways | 三路快速排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/sort/src/QuickSort3Ways.java)|
| HeapSort | 堆排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/HeapSort.java)|
| HeapSort2 | 通过 Heapfiy 数组建堆替代一个个元素进堆 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/HeapSort2.java)|
| HeapSort3 | 将堆转数组，省略出堆到数组的额外空间 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/HeapSort3.java)|

#### 2. 堆

| 问题 | 备注 | 链接 |
|---|---|---|
| MaxHeap | 构建最大堆 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/heap/src/MaxHeap.java) |
| PrintableMaxHeap | 打印堆结构辅助类 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/heap/src/PrintableMaxHeap.java) |
| HeapSort | 堆排序 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/HeapSort.java)|
| HeapSort2 | 通过 Heapfiy 数组建堆替代一个个元素进堆 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/HeapSort2.java)|
| HeapSort3 | 将堆转数组，省略出堆到数组的额外空间 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/HeapSort3.java)|
| IndexMaxHeap | 最大索引堆，增加索引，替代直接的数据交换 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/IndexMaxHeap.java)|
| MinHeap | 最小堆 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/heap/src/MinHeap.java)|

#### 3. 二分搜索树

|  算法  | 备注 | 代码 |
|---|---|---|
| BinarySearch | 二分搜索（递归实现：查找、floor、ceil） | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/binary-search-tree/src/BinarySearch.java)|
| BinarySearc2 | 二分搜索（非递归实现：查找、floor、ceil）|[Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/binary-search-tree/src/BinarySearch2.java)|
| BST | 二分搜索树（递归实现:深度优先[前中后序遍历]、广度优先[层次遍历]、Hubbard Deletion等） | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/binary-search-tree/src/BST.java)|
| BST2 | 二分搜索树（非递归实现:深度优先[前中后序遍历]、广度优先[层次遍历]、Hubbard Deletion等） | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/binary-search-tree/src/BST2.java) |
| BSTandSST | 二分搜索树和顺序查找表在搜索时间的效率比较 | [BSTandSST](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/binary-search-tree/src/BSTandSST)|

#### 4. 并查集

| 问题 | 备注 | 代码 |
|---|---|---|
| UnionFindTestHelper | 并查集测试辅助类 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFindTestHelper.java) |
| UnionFind1 | uick find 版本，union 和 isConnected 分别为 O(n) 和 O(1) 的时间复杂度 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind1.java) |
| UnionFind2 | quick union 版本，union 和 isConnected 皆为 O(h 树深) 的时间复杂度 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind2.java) |
| UnionFind3 | quick union 版本，基于 集合规模size 优化树深 h | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind3.java) |
| UnionFind4 | quick union 版本，基于 集合树深rank 优化树深 h | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind4.java) |
| UnionFind5 | 执行 find 操作时，增加Path Compression 路径压缩优化树深，第一种压缩方式 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind5.java) |
| UnionFind6 | 执行 find 操作时，增加Path Compression 路径压缩优化树深，第二种压缩方式 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind6.java) |
| UFTest | 借用UnionFindTestHelper对UF1和UF2两个版本进行时间效率比较 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UFTest.java) |

#### 5. 图

##### 5.1 无权图

| 问题 | 备注 | 代码 |
|---|---|---|
| NonweightedGraph | 无权图接口 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/NonweightedGraph.java) |
| DenseNonweightedGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseNonweightedGraph.java) |
| SparseNonweightedGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/SparseNonweightedGraph.java) |
| ReadGraphHelper | 读取文件数据辅助类 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/ReadGraphHelper.java) |
| NonweightedGraphTest | 借助 ReadGraphHelper 测试 DenseNonweightedGraph 和 SparseNonweightedGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/NonweightedGraphTest.java) |
| Component | 采用 DFS 求联通分量 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/Component.java) |
| Path | 采用 BFS 求最短路径 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/Path.java) |

##### 5.2 带权图

| 问题 | 备注 | 代码 |
|---|---|---|
| WeightedGraph | 带权图接口 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/WeightedGraph.java) |
| DenseWeightedGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseWeightedGraph.java) |
| SparseWeightedGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/SparseWeightedGraph.java) ||
| WeightedGraphTest | 借助 ReadGraphHelper 测试 DenseWeightedGraph 和 SparseWeightedGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/WeightedGraphTest.java) |

##### 5.2 最小生成树

| 问题 | 备注 | 代码 |
|---|---|---|
| Lazy Prim | 普利姆最小生成树方法 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/LazyPrimMST.java) |
| Prim | 普里姆优化-采用最小索引堆，仅维护最小权值的横切边，而不是将访问过的顶点的所有边加入堆 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/LazyPrimMST2.java) |
| PrimAndPrim2 | 对 Lazy Prim 和 Lazy Prim2 于时间效率上进行比较 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/PrimAndPrim2.java) |

### 算法应用问题

| 问题 | 描述 | 分类 | 链接 |
|---|---|---|---|
| Number K  | 求任意数组的第K大元素 | 数组、快排 | [numberK](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/applied/numberK)|
| 八数码问题  | 寻找目标局面的最短路径 | 树、BFS、A* | [8 Numbers](https://github.com/patricklin2018/DataStructures-Algorithmns/tree/master/applied/8numbers)|