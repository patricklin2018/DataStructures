##31. Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
`1,2,3` → `1,3,2`

`3,2,1` → `1,2,3`

`1,1,5` → `1,5,1`

##Solution

```cpp
 void nextPermutation(vector<int>& nums) {
    int size = nums.size();
	if (size <= 1)
		return;
	int k = -1;
	for (int i = size - 2; i >= 0; --i){
		if (nums[i] < nums[i + 1]){
			k = i;
			break;
		}
	}
	for (int i = size - 1; k != -1 && i > k; --i){
		if (nums[i] > nums[k]){
			swap(nums[i], nums[k]);
			break;
		}
	}
	reverse(nums.begin() + k + 1, nums.end());
}
```