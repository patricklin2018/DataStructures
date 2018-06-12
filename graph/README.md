# 图问题

### 实现

#### 无权图

| 问题 | 备注 | 链接 |
|---|---|---|
| NonweightedGraph | 无权图接口 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/NonweightedGraph.java) |
| DenseNonweightedGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/DenseGraph.java) |
| SparseNonweightedGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/SparseGraph.java) |
| ReadGraphHelper | 读取文件数据辅助类 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/ReadGraphHelper.java) |
| NonweightedGraphTest | 借助 ReadGraphHelper 测试 DenseNonweightedGraph 和 SparseNonweightedGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/NonweightedGraphTest.java) |
| Component | 采用 DFS 求联通分量 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/Component.java) |
| Path | 采用 BFS 求最短路径 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/Path.java) |

#### 带权图

| 问题 | 备注 | 链接 |
|---|---|---|
| WeightedGraph | 带权图接口 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/WeightedGraph.java) |
| DenseWeightedGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/DenseGraph.java) |
| SparseWeightedGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/SparseGraph.java) ||
| WeightedGraphTest | 借助 ReadGraphHelper 测试 DenseWeightedGraph 和 SparseWeightedGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/DenseAndSparseGraph.java) |

#### 测试数据

| 数据 | 备注 | 链接 |
|---|---|---|
| testG1 | 无权图 | [testG1.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/testG1.txt) |
| testG2 | 无权图 | [testG2.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/testG2.txt) ||
| testG3 | 带权图 | [testG3.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/nonweightedGraph/src/testG3.txt) |
