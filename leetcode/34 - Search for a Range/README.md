##34. Search for a Range

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return `[-1, -1]`.

For example,
Given `[5, 7, 7, 8, 8, 10]` and target value 8,
return `[3, 4]`.

##Solution

>CPP

```cpp
vector<int> searchRange(vector<int>& nums, int target) {
    vector<int> res(2, -1);
	if (nums.size() == 0) {
		return res;
	}
	int size = nums.size();
	int left = 0, right = size - 1;
	while (left + 1 < right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] < target) {
			left = mid;
		}
		else {
			right = mid;
		}
	}
	int start = (nums[left] == target ? left : (nums[right] == target ? right : -1));
	if (start == -1) {
		return res;
	}
	left = 0;
	right = size - 1;
	while (left + 1 < right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] > target) {
			right = mid;
		}
		else {
			left = mid;
		}
	}
	int end = (nums[right] == target ? right : (nums[left] == target ? left : -1));
	res[0] = start;
	res[1] = end;
	return res;
}
```

>JAVA

```java
public int[] searchRange(int[] nums, int target) {
	 int[] result = {-1, -1};
	 if (nums == null || nums.length == 0){
		 return result;
	 }

	 int left = 0;
	 int right = nums.length - 1;
	 while (left + 1 < right){
		 int mid = left + (right - left) / 2;
		 if (nums[mid] >= target){
			 right = mid;
		 }
		 else{
			 left = mid;
		 }
	 }
	 if (nums[left] == target){
		 result[0] = left;
	 }
	 else if (nums[right] == target){
		 result[0] = right;
	 }
	 if (result[0] == -1){
		 return result;
	 }
	 
	 right = nums.length - 1;
	 while (left + 1 < right){
		 int mid = left + (right - left) / 2;
		 if (nums[mid] <= target){
			 left = mid;
		 }
		 else{
			 right = mid;
		 }
	 }
	 if (nums[right] == target){
		 result[1] = right;
	 }
	 else if (nums[left] == target){
		 result[1] = left;
	 }

	 return result;
 }
```