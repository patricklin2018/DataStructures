##189. Rotate Array

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array `[1,2,3,4,5,6,7]` is rotated to `[5,6,7,1,2,3,4]`.

**Note:**

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

##Solution:

三步翻转法, 可将 Rotated Sorted Array 还原：

```
[4, 5, 6, 1, 2, 3]
-> [6, 5, 4, 1, 2, 3]
-> [6, 5, 4, 3, 2, 1]
-> [1, 2, 3, 4, 5, 6]
```

那么将该过程相反过来可得到 Rotated Sorted Array ：

```
[1, 2, 3, 4, 5, 6]
-> [6, 5, 4, 3, 2, 1]
-> [4, 5, 6, 3, 2, 1]
-> [4, 5, 6, 1, 2, 3]
```

```cpp
void rotate(vector<int>& nums, int k) {
    int delta = k % nums.size();
	reverse(nums.begin(), nums.end());
	reverse(nums.begin(), nums.begin() + delta);
	reverse(nums.begin() + delta, nums.end());
}
```