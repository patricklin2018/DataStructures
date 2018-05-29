//
//  Created by Patrick-Lin on 15/11/26.
//  Copyright © 2015年 Patrick-Lin. All rights reserved.
//

/*
 
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// Solution 1
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (!p&&!q)
            return true;
        if (!p||!q)
            return false;
        return (p->val==q->val) && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
    }
};

// Solution 2
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        queue<TreeNode*> q1,q2;
        q1.push(p);
        q2.push(q);
        
        while (q1.size()>0 || q2.size()>0) {
            TreeNode *p1,*p2;
            p1=q1.front();
            q1.pop();
            p2=q2.front();
            q2.pop();
            if(!p1 && !p2)
                continue;
            if (!p1 || !p2)
                return false;
            if (p1->val!=p2->val)
                return false;
            q1.push(p1->left);
            q1.push(p1->right);
            q2.push(p2->left);
            q2.push(p2->right);
        }
        
        return true;
    }
};