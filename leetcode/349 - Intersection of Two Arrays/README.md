##Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = `[1, 2, 2, 1]`, nums2 = `[2, 2]`, return `[2]`.

Note:

Each element in the result must be unique.

The result can be in any order.

##Solution

####solution 1:

使用无序容器 `unorder_set`，时间复杂度为 O(n + m)。

```cpp
vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
    unordered_set<int> us(nums1.begin(), nums1.end());
    vector<int> intersec;
    for (auto i : nums2){
        if (us.count(i)) {
            intersec.push_back(i);
            us.erase(i);
        }
    }
    return intersec;
}
```

####solution 2:

先进行排序，然后创建两个指针分别指向两个 `vector` 进行比较。时间复杂度为 O(max(n, m) log max(n, m))。

```cpp
vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
    vector<int> intersec;
    unordered_set<int> us;
    sort(nums1.begin(), nums1.end()), sort(nums2.begin(), nums2.end());
    for (auto p = nums1.begin(), q = nums2.begin(); p != nums1.end() && q != nums2.end();) {
        if (*p == *q) {
            us.insert(*p);
            p++, q++;
        }
        else if (*p < *q){
            p++;
        }
        else{
            q++;
        }
    }
    
    for (auto i : us){
        intersec.push_back(i);
    }
    
    return intersec;
}
```