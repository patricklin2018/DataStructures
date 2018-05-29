##House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

##Solution:
动态规划，需要比较 `i-2` 和 `i-3` 的情况，因为可能出现连续两个不偷。
```cpp
int rob(vector<int>& nums) {
    int size = nums.size(), sum = 0;
	int *dp = new int[size];
	if (size == 0)
		return 0;
	else if (size == 1){
		return nums[0];
	}
	dp[0] = nums[0];
	dp[1] = nums[1];
	for (int i = 2; i < size; ++i){
		dp[i] = nums[i] + (dp[i - 2] >= dp[i - 3] ? dp[i - 2] : dp[i - 3]);
	}
	return dp[size - 1] >= dp[size - 2] ? dp[size - 1] : dp[size - 2];
}
```