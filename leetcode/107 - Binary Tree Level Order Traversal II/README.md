##Binary Tree Level Order Traversal II

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

**For example:**

Given binary tree `[3,9,20,null,null,15,7]`,
 
```
    3
   / \
  9  20
    /  \
   15   7
```
```
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
```

##Solution

使用队列实现中序遍历：

```cpp
vector<vector<int>> levelOrderBottom(TreeNode* root) {
	vector<vector<int>> res;
	if (root == nullptr)
		return res;

	queue<TreeNode*> que;
	que.push(root);
	vector<int> elm(1, root->val);
	res.push_back(elm);
	while (!que.empty()){
		int sizeCurLevel = que.size();
		vector<int> elm;
		while (sizeCurLevel--){
			auto node = que.front();
			que.pop();
			if (node->left){
				que.push(node->left);
				elm.push_back(node->left->val);
			}
			if (node->right){
				que.push(node->right);
				elm.push_back(node->right->val);
			}
		}
		if (!elm.empty())
			res.insert(res.begin(), elm);
	}
	return res;
}
```