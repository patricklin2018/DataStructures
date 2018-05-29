##Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

**For example:**

```
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
```
```
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
```

##Solution

使用队列实现中序遍历：

```cpp
vector<vector<int>> levelOrder(TreeNode* root) {
	vector<vector<int>> res;
	if (!root)
		return res;
	queue<TreeNode*> que;
	que.push(root);
	while (!que.empty()){
		int curLevelSize = que.size();
		vector<int> curLevelRes;
		while (curLevelSize--){
			TreeNode* node = que.front();
			que.pop();
			curLevelRes.push_back(node->val);
			if (node->left)
				que.push(node->left);
			if (node->right)
				que.push(node->right);
		}
		res.push_back(curLevelRes);
	}
	return res;
}
```