##Reverse Linked List

Reverse a singly linked list.

Hint:

A linked list can be reversed either iteratively or recursively. Could you implement both?

##Solution:

####solution 1:
利用栈读取链，然后再逐一取出，建立一条新的链接表。

```cpp
ListNode* reverseList(ListNode* head) {
    if(head == nullptr || head->next == nullptr){
        return head;
    }
    stack<ListNode*> st;
    while (head != nullptr){
        st.push(head);
        head = head->next;
    }
    ListNode *first, *ptr;
    first = ptr = st.top();
    st.pop();
    while (!st.empty()) {
        ptr->next = st.top();
        st.pop();
        ptr = ptr->next;
    }
    ptr->next = nullptr;
    return first;
}
```

####solution 2:
设置左右两个指针，`head`指向要改变的节点，左右指针则分别记录该节点的前后节点。

```cpp
ListNode* reverseList(ListNode* head) {
    ListNode *left = nullptr;
    while (head != nullptr){
        ListNode* right = head->next;
        head->next = left;
        left = head;
        head = right;
    }
    return left;
}
```

####solution 3:
递归方法，思路与 `solution 2` 一致。

```cpp
ListNode* reverseList(ListNode* left, ListNode* head){
    if (!head)
        return left;
    auto right = head->next;
    head->next = left;
    return reverseList(head, right);
}

ListNode* reverseList(ListNode* head) {
    return reverseList(nullptr, head);
}
```