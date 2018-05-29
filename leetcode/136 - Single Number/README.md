##Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

##Solution

一开始的想法是先进行排序，然后将所有元素进行一加一减运算，所求得的数即为 `Single Number`。但是该算法的时间复杂度为 `O(nlogn)`，不符合题目要求。

```cpp
int singleNumber(vector<int>& nums) {
   sort(nums.begin(), nums.end());
    int n = 0, tmp = 1;
    for(auto i : nums){
        if (tmp == 1) {
            n += i;
        }
        else{
            n -= i;
        }
        tmp = -tmp;
    }
    return n;
}
```

我们知道，异或运算是符合交换规律的，即 `a ^ b ^ c = a ^ c ^ b` 。也就是说，` 3 ^ 4 ^ 3 = 3 ^ 3 ^ 4 = 4`。所以，我们可以将所有元素进行XOR异或运算，所得结果即为 `Single Number`，时间复杂度为 `O(n)`，符合题目要求。

```cpp
int singleNumber(vector<int>& nums) {
    int n = 0;
    for(auto i : nums){
        n ^= i;
    }
    return n;
}
```