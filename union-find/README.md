# 并查集

### 实现
| 问题 | 备注 | 链接 |
|---|---|---|
| UnionFindTestHelper | 并查集测试辅助类 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFindTestHelper.java) |
| UnionFind1 | uick find 版本，union 和 isConnected 分别为 O(n) 和 O(1) 的时间复杂度 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind1.java) |
| UnionFind2 | quick union 版本，union 和 isConnected 皆为 O(h 树深) 的时间复杂度 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UnionFind2.java) |
| UFTest | 借用UnionFindTestHelper对UF1和UF2两个版本进行时间效率比较 | [Java](https://github.com/patricklin2018/DataStructures-Algorithmns/blob/master/union-find/src/UFTest.java) |

### 实验

Quick Find 版本 和 Quick Union 版本在时间效率上的比较：
```
UnionFind1 : 7687 ms
UnionFind2 : 12063 ms
```