# 图问题
#### 无权图
| 问题 | 备注 | 代码 |
|---|---|---|
| NonweightedGraph | 无权图接口 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/NonweightedGraph.java) |
| DenseNonweightedGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseNonweightedGraph.java) |
| SparseNonweightedGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/SparseNonweightedGraph.java) |
| ReadGraphHelper | 读取文件数据辅助类 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/ReadGraphHelper.java) |
| NonweightedGraphTest | 借助 ReadGraphHelper 测试 DenseNonweightedGraph 和 SparseNonweightedGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/NonweightedGraphTest.java) |
| Component | 采用 DFS 求联通分量 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/Component.java) |
| Path | 采用 BFS 求最短路径 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/Path.java) |

#### 带权图
| 问题 | 备注 | 代码 |
|---|---|---|
| WeightedGraph | 带权图接口 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/WeightedGraph.java) |
| DenseWeightedGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseWeightedGraph.java) |
| SparseWeightedGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/SparseWeightedGraph.java) ||
| WeightedGraphTest | 借助 ReadGraphHelper 测试 DenseWeightedGraph 和 SparseWeightedGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/WeightedGraphTest.java) |

#### 最小生成树问题

##### 背景知识：
> 切分： 把图中的点划分为两个部分，成为一个切分
>
> 横切边： 一条边的两个端点属于切分中的不同部分
> 
> 切分定理： 给定任意切分，横切边的最小权值边必定属于最小生树

###### 1. Lazy Prim
```
1. 以任意顶点作为开始
2. 访问该顶点，并将该顶点的横切边加入最小堆（或其他辅助方法）
3. 将堆中权值最小的横切边加入生成树，并回到2. 访问该边未访问的顶点，直到所有顶点均加入最小生成树
```
###### 2. Lazy Prim - 优化
```
采用 edgeTo 数组结合最小索引堆，维护一个记录当前生成树到各顶点的最低权值横切边的数组，而不再是将所有未访问横切边加入堆中排序
```

###### 实现
| 问题 | 备注 | 代码 |
|---|---|---|
| Lazy Prim | 普利姆最小生成树方法 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/LazyPrimMST.java) |
| Lazy Prim2 | 普里姆优化-采用最小索引堆，仅维护最小权值的横切边，而不是将访问过的顶点的所有边加入堆 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/LazyPrimMST2.java) |
| PrimAndPrim2 | 对 Lazy Prim 和 Lazy Prim2 于时间效率上进行比较 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/PrimAndPrim2.java) |

#### 测试数据

| 数据 | 备注 | 链接 |
|---|---|---|
| testG1 | 无权图测试数据 | [testG1.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG1.txt) |
| testG2 | 无权图测试数据 | [testG2.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG2.txt) ||
| testG3 | 带权图测试数据 | [testG3.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG3.txt) |
| testG3 | 带权图， 10000 个顶点， 61731条边 | [testG4.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG4.txt) |