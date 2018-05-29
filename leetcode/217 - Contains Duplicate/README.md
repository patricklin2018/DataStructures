##Contains Duplicate

Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.


##Solution:

利用无序容器进行统计，发现出现次数大于 1 的返回 `true`。

```cpp
bool containsDuplicate(vector<int>& nums) {
    unordered_map<int, int> um;
    for (auto e : nums){
        if ( ++um[e] > 1){
            return true;
        }
    }
    return false;
}
```