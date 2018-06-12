# 并查集

### 实现

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

### 实验

各 Union Find 版本在时间效率上的比较：
```
N = 100000 次 union 和 isConnected 操作，消耗时间如下：
UnionFind1 : 8497 ms
UnionFind2 : 12780 ms
UnionFind3 : 37 ms
UnionFind4 : 37 ms
UnionFind5 : 36 ms
UnionFind6 : 35 ms
```

在一百万次操作下，比较UnionFind3-6:
```
N = 1000000 次 union 和 isConnected 操作，消耗时间如下：
UnionFind3 : 680 ms
UnionFind4 : 893 ms
UnionFind5 : 456 ms
UnionFind6 : 401 ms
```