##Majority Element

Given an array of size n, find the majority element. The majority element is the element that appears more than [ n/2 ] times.

You may assume that the array is non-empty and the majority element always exist in the array.

##Solution:

####solution 1:
采用 `unorder_map` 构建哈希表，利用哈希表查找时间复杂度为 O(1) 的优势。所以，算法的时间复杂度为 O(n)：

```cpp
int majorityElement(vector<int>& nums) {
    unordered_map<int, int> us;
    int critical = nums.size() / 2;
    for (auto i : nums) {
        if (++us[i] > critical) {
            return i;
         }
    }
    return nums[0];
}
```

####solution 2:

因为 `majorityElement` 多于总数的一半，所以可以寻找一个临时值，并定义一个 `count` 进行记录。遇到相同 `count` 自增，反而自减，若 `count` 为零，则更换临时值。时间复杂度同为 O(n)。

```cpp
int majorityElement(vector<int>& nums) {
   int count = 0, tmp;
   int critical = nums.size() / 2;
   for (auto i : nums){
       count ? (tmp == i ? count++ : count --) : (tmp = i, count++);
       
       if(count > critical){
           return tmp;
       }
   }
   return tmp;
}
```

####solution 3:

进行排序，然后返回中间的值。

```cpp
int majorityElement(vector<int>& nums) {
   sort(nums.begin(), nums.end());
   return nums[nums.size() / 2];
}
```