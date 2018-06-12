# 图问题

## 数据结构
### 实现
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

## 最小生成树问题

### 简介

#### 背景知识：
> 切分： 把图中的点划分为两个部分，成为一个切分
>
> 横切边： 一条边的两个端点属于切分中的不同部分
> 
> 切分定理： 给定任意切分，横切边的最小权值边必定属于最小生树

#### Lazy Prim
```
1. 以任意顶点作为开始
2. 访问该顶点，并将该顶点的横切边加入最小堆（或其他辅助方法）
3. 将堆中权值最小的横切边加入生成树，并回到2. 访问该边未访问的顶点，直到所有顶点均加入最小生成树
```

### 实现
| 问题 | 备注 | 代码 |
|---|---|---|
| Lazy Prim| 普利姆最小生成树方法 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/LazyPrimMST.java) |


## 测试数据

| 数据 | 备注 | 链接 |
|---|---|---|
| testG1 | 无权图 | [testG1.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG1.txt) |
| testG2 | 无权图 | [testG2.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG2.txt) ||
| testG3 | 带权图 | [testG3.txt](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/testG3.txt) |
