##81. Search in Rotated Sorted Array II

>Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
>
>Would this affect the run-time complexity? How and why?

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `0 1 2 4 5 6 7` might become `4 5 6 7 0 1 2`).

Write a function to determine if a given target is in the array.

The array may contain duplicates.

##Solution

二分搜索，最坏情况退化 O(n)

>CPP

```cpp
bool search(vector<int>& nums, int target) {
    int size = nums.size();
	if (size == 0) {
		return false;
	}
	int left = 0, right = size - 1;
	while (left + 1 < right) {
		int mid = left + (right - left) / 2;
		if (nums[mid] == target) {
			return true;
		}
		if (nums[mid] < nums[right]) {
			if (target >= nums[mid] && target <= nums[right]) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		else if (nums[mid] > nums[right]) {
			if (target >= nums[left] && target <= nums[mid]) {
				right = mid;
			}
			else {
				left = mid;
			}
		}
		else {
			right--;
		}
	}
	return nums[left] == target || nums[right] == target;
}
```

>JAVA

```java
public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0){
    	return false;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right){
    	int mid = left + (right - left) / 2;
    	if (nums[mid] == target){
    		return true;
    	}
    	else if (nums[mid] < nums[right]){
    		if (target >= nums[mid] && target <= nums[right]){
    			left = mid;
    		}
    		else{
    			right = mid;
    		}
    	}
        else if (nums[mid] > nums[right]) {
    		if (target >= nums[left] && target <= nums[mid]){
    			right = mid;
    		}
    		else{
    			left = mid;
    		}
    	}
    	else{
    		right--;
    	}
    }
    if (nums[left] == target || nums[right] == target){
    	return true;
    }
    return false;
}
```