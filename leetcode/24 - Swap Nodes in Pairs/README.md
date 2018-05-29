##Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given `1->2->3->4`, you should return the list as `2->1->4->3`.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

```cpp
// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
```

##Solution
####1. 
递归方法，简单易理解，从链表后面开始交换，返回第一个指针。
```cpp
ListNode* swapPairs(ListNode* head) {
    ListNode *a, *b;
    if ((a = head) && (b = a->next)){
        a->next = swapPairs(b->next);
        b->next = a;
        return b;
    }
    return head;
}
```
####2. 
非递归方法，使用二级指针`**pp`指向节点中存储下一个节点的位置。
```cpp
ListNode* swapPairs(ListNode* head) {
    ListNode **pp = &head, *a, *b;
    while ((a = *pp) && (b = a->next)){
        a->next = b->next;
        b->next = a;
        *pp = b;
        pp = &(a->next);
    }
    return head;
}
```
