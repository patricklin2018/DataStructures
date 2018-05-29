##Add Two Numbers

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
```

##Solution

非递归方法：

```cpp
ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    ListNode first(0), *end = &first;
    int carry = 0;
    
    while (l1 || l2 || carry){
        int value = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
        end->next = new ListNode(value % 10);
        end = end->next;
        carry = value / 10;
        if(l1 != nullptr)
            l1 = l1->next;
        if(l2 != nullptr)
            l2 = l2->next;
    }
    return first.next;
}
```

递归方法：

```cpp
ListNode* addTwoNumbers(ListNode* l1, ListNode* l2, int carry) {
    if( !l1 && !l2 && !carry)
        return nullptr;
    
    int value = (l1 ? l1->val : 0) + (l2 ? l2->val : 0) + carry;
    carry = value / 10;
    ListNode* ptr = new ListNode(value % 10);
    ptr->next = addTwoNumbers(l1 ? l1->next : nullptr, l2 ? l2->next : nullptr, carry);
    return ptr;
}

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
    return addTwoNumbers(l1, l2, 0);
}
```