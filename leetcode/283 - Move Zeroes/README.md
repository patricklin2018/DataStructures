##Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

1. You must do this in-place without making a copy of the array.

2. Minimize the total number of operations.

##Solution:

定义两个变量，一个记住非零元素的结束位置，另一个则向后递增，寻找非零元素，再进行调换。

```cpp
void moveZeroes(vector<int>& nums) {
    size_t  left = 0, right = 1, size = nums.size();
    while (right < size) {
        if (nums[left]) {
            left++;
        }
        else{
            if (nums[right]) {
                swap(nums[left], nums[right]);
                left++;
            }
        }
        right++;
    }
}
```
