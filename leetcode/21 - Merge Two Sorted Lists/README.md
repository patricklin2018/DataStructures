##Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

```cpp
// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
```

##Solution

递归方法：

```cpp
ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
	if (l1 == nullptr) return l2;
	if (l2 == nullptr) return l1;

	ListNode* res;
	if (l1->val <= l2->val){
		res = new ListNode(l1->val);
		res->next = mergeTwoLists(l1->next, l2);
	}
	else{
		res = new ListNode(l2->val);
		res->next = mergeTwoLists(l1, l2->next);
	}
	return res;
}
```

非递归方法：

```cpp
ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
	ListNode *ptr, *first;
	first = ptr = new ListNode(0);
	while (true){
		if (l1 == nullptr) {
			ptr->next = l2;
			return first->next;
		}
		else if (l2 == nullptr){
			ptr->next = l1;
			return first->next;
		}
		else if(l1->val <= l2->val){
			ptr->next = new ListNode(l1->val);
			ptr = ptr->next;
			l1 = l1->next;
		}
		else{
			ptr->next = new ListNode(l2->val);
			ptr = ptr->next;
			l2 = l2->next;
		}
	}
}
```
