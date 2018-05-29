##Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```
But the following `[1,2,2,null,3,null,3]` is not:
```
    1
   / \
  2   2
   \   \
   3    3
```
**Note:**
Bonus points if you could solve it both recursively and iteratively.

##Solution

Iteratively, 非递归。
```cpp
bool isSymmetric(TreeNode* root) {
	if (root == nullptr)
	    return true;
	    
	queue<TreeNode*> que;
	que.push(root);
	while (!que.empty()){
		int sizeQue = que.size();
		vector<int> vals;
		while (sizeQue--){
			TreeNode* node = que.front();
			que.pop();
			if (node->left){
				que.push(node->left);
				vals.push_back(node->left->val);
			}
			else{
				vals.push_back(NULL);
			}
			if (node->right){
				que.push(node->right);
				vals.push_back(node->right->val);
			}
			else{
				vals.push_back(NULL);
			}
		}
		int sizeVec = vals.size();
		if (sizeVec & 1 == 1){
			return false;
		}
		for (int i = 0, j = sizeVec - 1; i < j; ++i, --j){
			if (vals[i] != vals[j]){
				return false;
			}
		}
	}
	return true;
```

Recursively， 递归
```cpp
bool isSymmetric(TreeNode* left, TreeNode* right){
	if (!left || !right) return left == right;
	if (left->val != right->val) return false;
	return isSymmetric(left->left, right->right) && isSymmetric(left->right, right->left);
}

bool isSymmetric(TreeNode* root) {
	return root == nullptr || isSymmetric(root->left, root->right);
}
```
这里 `if (!left || !right) return left == right;` 语句中，如果左右均为空，则其值皆为 `NULL` ，所以返回 `true` ，如果左右仅一者为空，则返回 `false`