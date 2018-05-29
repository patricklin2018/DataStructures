##33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

##Solution

二分搜索

>CPP

```cpp
int search(vector<int>& nums, int target) {
    int size = nums.size();
	if (size == 0) {
		return -1;
	}
	int left = 0, right = size - 1;
	while (left + 1 < right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		else if (nums[mid] >= nums[right]) {
			if (target >= nums[left] && target <= nums[mid]) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		else {
			if (target >= nums[mid] && target <= nums[right]) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
	}
    return nums[left] == target ? left : (nums[right] == target ? right : -1);
}
```

>JAVA

```java
public int search(int[] nums, int target) {
	if (nums == null || nums.length == 0){
		return -1;
	}
	
	int left = 0;
	int right = nums.length - 1;
	while (left + 1 < right){
		int mid = left + (right - left) / 2;
		
		if (nums[mid] == target){
			return mid;
		}
		if (nums[mid] <= nums[right]){
			if (target >= nums[mid] && target <= nums[right]){
				left = mid;
			}
			else{
				right = mid;
			}
		}
		else{
			if (target >= nums[left] && target <= nums[mid]){
				right = mid;
			}
			else{
				left = mid;
			}
		}
	}
	if (nums[left] == target){
		return left;
	}
	if (nums[right] == target){
		return right;
	}
	return -1;
}
```