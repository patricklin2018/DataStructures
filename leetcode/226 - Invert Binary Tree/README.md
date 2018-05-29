##Invert Binary Tree

Invert a binary tree.

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

to

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

Trivia:

This problem was inspired by this original tweet by Max Howell:

>Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

##Solution:

####solution 1:
DFS，递归方法：

```cpp
TreeNode* invertTree(TreeNode* root) {
    if(root){
        auto tmp = invertTree(root->left);
        root->left = invertTree(root->right);
        root->right = tmp;
    }
    return root;
}
```

DFS，非递归方法：

```cpp
TreeNode* invertTree(TreeNode* root) {
   if (root) {
        stack<TreeNode*> s;
        s.push(root);
        while (!s.empty()) {
            auto i = s.top();
            s.pop();
            TreeNode *left = i->left, *right = i->right;
            if (left) {
                s.push(left);
            }
            if (right) {
                s.push(right);
            }
            i->left = right;
            i->right = left;
        }
    }
    return root;
}
```

####solution 2:

BFS, 非递归方法：

```cpp
TreeNode* invertTree(TreeNode* root) {
   if (root) {
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            auto i = q.front();
            q.pop();
            TreeNode *left = i->left, *right = i->right;
            if (left) {
                q.push(left);
            }
            if (right) {
                q.push(right);
            }
            i->left = right;
            i->right = left;
        }
    }
    return root;
}
```