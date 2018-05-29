##Delete Node in a Linked List

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is `1 -> 2 -> 3 -> 4` and you are given the third node with value 3, the linked list should become `1 -> 2 -> 4` after calling your function.

##Solution:

直接将 node 指向对象替换成下一个节点的对象。

```cpp
void deleteNode(ListNode* node) {
    *node = *(node->next);
}
```

也可以删除下一个节点：

```cpp
void deleteNode(ListNode* node) {
    auto tmp = node->next;
    *node = *tmp;
    delete tmp;
}
```