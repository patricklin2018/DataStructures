###Same Tree
***
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
***

###solution:

>遍历两棵树的所有节点，分别比较。如果发现节点不同，则树为不同。若没有发现不同的节点，则树为形同。

非递归遍历树方法：

```
1) 从队列／栈中取出纪录节点
2) 访问节点
3) 将左右节点加入队列／栈
4) 回到 1) 直到队列/栈为空
```