##Same Tree

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

##Solution

DFS，递归方法:

```cpp
bool isSameTree(TreeNode* p, TreeNode* q) {
    if(p == nullptr && q == nullptr){
        return true;
    }
    if(p == nullptr || q == nullptr){
        return false;
    }

    if(p->val == q->val){
        return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);     
    }
    return false;
}
```

这里可以写成：

```cpp
bool isSameTree(TreeNode* p, TreeNode* q) {
	return (!p || !q) ? p == q : 
	(p->val == q->val && isSameTree(p->left, q->left) && isSameTree(p->right, q->right));  
}
```

DFS，非递归方法 ：

```cpp
bool isSameTree(TreeNode* p, TreeNode* q) {
   if(!p || !q){
       return p == q;
   }

    stack<TreeNode*> s1, s2;
    s1.push(p);
    s2.push(q);
    while(!s1.empty() && !s2.empty()){
        auto i1 = s1.top(), i2 = s2.top();
        s1.pop(), s2.pop();
        
        if(i1->val != i2->val){
            return false;
        }
        if (i1->left && i2->left) {
            s1.push(i1->left);
            s2.push(i2->left);
        }
        else if ((!i1->left && i2->left) || (i1->left && !i2->left)){
            return false;
        }
       
        if (i1->right && i2->right) {
            s1.push(i1->right);
            s2.push(i2->right);
        }
        else if ((!i1->right && i2->right) || (i1->right && !i2->right)){
            return false;
        }
    }
    return true;
}
```