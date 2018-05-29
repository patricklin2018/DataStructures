##Linked List Cycle

Given a linked list, determine if it has a cycle in it.

**Follow up:**
Can you solve it without using extra space?

##Solution

使用两个指针，一个每次跳一步，另一个每次跳两步，这样，如果有环会在某一点相会，最多检查 N 次。
```cpp
bool hasCycle(ListNode *head) {
    if (head == nullptr)
        return false;
    ListNode *walker = head, *runner = head;
    while (runner->next && (runner = runner->next->next)){
        walker = walker->next;
        if (walker == runner)
            return true;
    }
    return false;
}
```