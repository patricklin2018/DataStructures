##Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

##Solution

####DFS (Depth-First-Search):

```cpp
int maxDepth(TreeNode* root) {
    if(root == NULL){
        return 0;
    }
    int depth_left = maxDepth(root->left) + 1;
    int depth_right = maxDepth(root->right) + 1;
    return depth_left > depth_right ? depth_left : depth_right;
}
```

也可以用一行代码 ：

```cpp
int maxDepth(TreeNode* root) {
    return root == NULL ? 0 : max(maxDepth(root->left), maxDepth(root->right)) + 1;
}
```

####BFS (Breadth-First-Search):

```cpp
int maxDepth(TreeNode* root) {
    if (root == NULL) {
        return 0;
    }
    queue<TreeNode*> q;
    q.push(root);
    int depth = 0;
    while (!q.empty()) {
        depth++;
        for(int i = 0, n = q.size(); i < n; i++){
            TreeNode* tmp = q.front();
            q.pop();
            if(tmp->left != NULL){
                q.push(tmp->left);
            }
            if(tmp->right != NULL){
                q.push(tmp->right);
            }
        }
    }
    return depth;
}
```