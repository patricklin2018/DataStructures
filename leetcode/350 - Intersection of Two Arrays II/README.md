##Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:

Given nums1 = `[1, 2, 2, 1]`, nums2 = `[2, 2]`, return `[2, 2]`.

Note:

* Each element in the result should appear as many times as it shows in both arrays.
* The result can be in any order.

Follow up:

* What if the given array is already sorted? How would you optimize your algorithm?
* What if nums1's size is small compared to nums2's size? Which algorithm is better?
* What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


##Solution

[Intersection of Two Arrays](https://github.com/PatrickLin1993/LeetCode/tree/master/Algorithmn/349%20-%20Intersection%20of%20Two%20Arrays)，思路与之前一样。一种方法，是建立哈希表，进行统计比较。另一种方法，是排序后，用两个指针进行比较递增。

####solution 1:

使用无序容器 `unorder_map`，时间复杂度为 O(n ＋ m)。

```cpp
vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    unordered_map<int, int> um;
    vector<int> result;
    for (auto e : nums1){
        um[e]++;
    }
    for (auto e : nums2){
        if (um[e] > 0){
            um[e]--;
            result.push_back(e);
        }
    }
    return result;
}
```

####solution 2:

先进行排序，然后创建两个指针分别指向两个 `vector` 进行比较。时间复杂度为 O(max(n, m) log max(n, m))。

```cpp
vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    vector<int> result;
    sort(nums1.begin(), nums1.end()), sort(nums2.begin(), nums2.end());
    for (auto p = nums1.begin(), q = nums2.begin(); p != nums1.end() && q != nums2.end();) {
        if (*p == *q) {
            result.push_back(*p);
            p++, q++;
        }
        else if (*p < *q){
            p++;
        }
        else{
            q++;
        }
    }   
    return result;
}
```

###

