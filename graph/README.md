# 图问题

### 实现

| 问题 | 备注 | 链接 |
|---|---|---|
| DenseGraph | 用邻接矩阵存储稠密图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseGraph.java) |
| SparseGraph | 用邻接表存储稀疏图 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/SparseGraph.java) |
| ReadGraphHelper | 读取文件数据，并存进 Graph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/ReadGraphHelper.java) |
| DenseAndSparseGraph | 借助 ReadGraphHelper 测试 DenseGraph 和 SparseGraph | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/graph/src/DenseAndSparseGraph.java) |

### 实验

```
test G1 in Sparse Graph:
false	true	true	false	false	true	true	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
false	false	false	false	true	true	false	false	false	false	false	false	false	
false	false	false	true	false	true	true	false	false	false	false	false	false	
true	false	false	true	true	false	false	false	false	false	false	false	false	
true	false	false	false	true	false	false	false	false	false	false	false	false	
false	false	false	false	false	false	false	false	true	false	false	false	false	
false	false	false	false	false	false	false	true	false	false	false	false	false	
false	false	false	false	false	false	false	false	false	false	true	true	true	
false	false	false	false	false	false	false	false	false	true	false	false	false	
false	false	false	false	false	false	false	false	false	true	false	false	true	
false	false	false	false	false	false	false	false	false	true	false	true	false	

test G2 in Sparse Graph:
vertex 0:	5	1	2	6	
vertex 1:	0	
vertex 2:	0	
vertex 3:	4	5	
vertex 4:	3	6	5	
vertex 5:	0	4	3	
vertex 6:	4	0	
vertex 7:	8	
vertex 8:	7	
vertex 9:	12	10	11	
vertex 10:	9	
vertex 11:	12	9	
vertex 12:	9	11	

test G1 in Sparse Graph:
false	true	true	false	false	true	true	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
true	false	false	false	false	false	false	false	false	false	false	false	false	
false	false	false	false	true	true	false	false	false	false	false	false	false	
false	false	false	true	false	true	true	false	false	false	false	false	false	
true	false	false	true	true	false	false	false	false	false	false	false	false	
true	false	false	false	true	false	false	false	false	false	false	false	false	
false	false	false	false	false	false	false	false	true	false	false	false	false	
false	false	false	false	false	false	false	true	false	false	false	false	false	
false	false	false	false	false	false	false	false	false	false	true	true	true	
false	false	false	false	false	false	false	false	false	true	false	false	false	
false	false	false	false	false	false	false	false	false	true	false	false	true	
false	false	false	false	false	false	false	false	false	true	false	true	false	

test G2 in Sparse Graph:
vertex 0:	5	1	2	6	
vertex 1:	0	
vertex 2:	0	
vertex 3:	4	5	
vertex 4:	3	6	5	
vertex 5:	0	4	3	
vertex 6:	4	0	
vertex 7:	8	
vertex 8:	7	
vertex 9:	12	10	11	
vertex 10:	9	
vertex 11:	12	9	
vertex 12:	9	11
```