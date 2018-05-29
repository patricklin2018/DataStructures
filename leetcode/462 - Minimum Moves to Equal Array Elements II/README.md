##462. Minimum Moves to Equal Array Elements II

Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

**Example:**
```
Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
```

##Solution
排序，找中位数。
```cpp
int minMoves2(vector<int>& nums) {
    sort(nums.begin(), nums.end());
	int size = nums.size(), middle = nums[size / 2], count = 0;
	for (int i = 0; i < size; ++i){
		count += abs(middle - nums[i]);
	}
	return count;
}
```