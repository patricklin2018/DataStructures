# 八数码问题

## 问题

> 在3×3的棋盘上，摆有八个棋子，每个棋子上标有1至8的某一数字。棋盘中留有一个空格，空格用0来表示。空格周围的棋子可以移到空格中。
> 要求解的问题是：给出一种初始布局（初始状态）和目标布局（为了使题目简单,设目标状态为123804765），找到一种最少步骤的移动方法，实现从初始布局到目标布局的转变。

[链接-可视化演示](http://senyu.github.io/8nums/DBFS/)

## Solultion

### BFS + HASH

| 代码 |
|---|
| [JAVA](https://github.com/patricklin2018/DataStructures/blob/master/applied/8numbers/bfs.java) |
| [C++](https://github.com/patricklin2018/DataStructures/blob/master/applied/8numbers/bfs.cpp) |


该方法的重点在于判断重复局面，如果采用 HashSet 等红黑树进行遍历判断的话，时间复杂度为 O(logn)，因此需要设计一个哈希函数，将判重时间复杂度缩短为 O(n)。

由于共有 `9！ = 362880` 种局面，因此，哈希函数设计为：

``` JAVA
// 状态树最大规模 9! = 362880
final static Integer MAXSIZE = 1000003;

/**
* 获得局面对应的哈希值
* @param situation
* @return
*/
private static Integer getCode(Integer[] situation) {
    Integer val = 0;
    for (int i = 0; i < 9; ++i) {
        val = situation[i] + val * 10;
    }
    return val % MAXSIZE;
}
```

全部代码见上面链接。
