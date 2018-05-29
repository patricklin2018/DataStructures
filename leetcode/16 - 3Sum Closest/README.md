##16. 3Sum Closest

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

```
For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
```

##Solution
排序，然后遍历，设置两个指标，当比 target 小则左标右移， 比 target 大则右标左移。 O(n)
```cpp
int threeSumClosest(vector<int>& nums, int target) {
	int size = nums.size(), gap = 0x7fffffff, sum;
	sort(nums.begin(), nums.end());
	for (int i = 0; i < size - 2; ++i){
		int j = i + 1, k = size - 1;
		while (j < k){
			int tmp = nums[i] + nums[j] + nums[k];
			if (abs(target - tmp) < gap){
				gap = abs(target - tmp);
				sum = tmp;
			}
			tmp < target ? j++ : k--;
		}
	}
	return sum;
}
```
[[1] http://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number](http://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number)