###Lowest Common Ancestor of a Binary Search Tree
***
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on [Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor):<br>
 “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

```
        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
```

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
***

###solution:

####solution 1:

>利用递归遍历整颗二叉树,知道得到最近的 root

```
由 root 开始分别递归搜索其左右子树，遇见 p 或 q 则立即返回，否则返回为空。

那么这样就可以从返回的左右子树纪录， 知道 p , q 在 root 的左子树还是右子树，又或者同在其左或右子树。

a) 如果分别在 root 的左右子树，那么 root 必然是其 lowest common ancestor。
b) 若同在左或右子树，那么先返回的左右子树纪录的节点就是 lowest common ancestor。
```

####solution 2:

>由于该二叉树的特点 ：从树的左往右看，数值依次增大。 

```
那么我们根据此特点，从根节点开始寻找第一个遇到的介于两者之间的值的节点必为两者的 lowest common ancestor。

a) 若 root 的值比 p , q 值大，则访问 root 的右节点。
b) 若 root 的值比 p,  q 值小，则访问 root 的左节点。
c) 否则（root 介于 p , q 之间）， 即可返回 root 为第一个遇到的介于两者之间值的节点(lowest common ancestor)。 

```

